package whatsapp_situation.lemonlab.com.whatsapp_situation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.add_note_layout.*
import whatsapp_situation.lemonlab.com.whatsapp_situation.data.TopicAdapter
import whatsapp_situation.lemonlab.com.whatsapp_situation.data.topic
import whatsapp_situation.lemonlab.com.whatsapp_situation.data.user_note
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by HP on 10/09/2018.
 */
class AddNoteFragment() : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.add_note_layout,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        var request = AdRequest.Builder().build()
        adView.loadAd(request)

        send_user_note_btn.setOnClickListener {

            if(user_note_textView.text.trim().isEmpty()){
                Toasty.error(context!!,"نص فارغ",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var data = FirebaseDatabase.getInstance().getReference("user_notes")
            progressbar_add_note_layout.visibility = View.VISIBLE
            var note_id = data.push().key
            var new_note = user_note(note_id,user_note_textView.text.toString())

            data.child(note_id).setValue(new_note).addOnCompleteListener {
                progressbar_add_note_layout.visibility = View.INVISIBLE
                Toasty.custom(context!!, "تم إرسال حالتك", R.drawable.ic_action_check, context!!.resources.getColor(R.color.purble), 1000, true,
                        true).show();
            }
        }
    }
}