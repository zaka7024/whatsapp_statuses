package whatsapp_situation.lemonlab.com.whatsapp_situation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.user_layout.*
import whatsapp_situation.lemonlab.com.whatsapp_situation.data.DB_SQL_LITE
import whatsapp_situation.lemonlab.com.whatsapp_situation.data.note
import whatsapp_situation.lemonlab.com.whatsapp_situation.data.user_note

/**
 * Created by HP on 10/09/2018.
 */
class UserFragment() : Fragment() {

    var items:ArrayList<user_note>? = ArrayList<user_note>();
    var layoutMnager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    var adapter:userAdapter? = null;
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.user_layout,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)
        initRecyclerView();


        // connect to firsbaseDatabase

        var data = FirebaseDatabase.getInstance().getReference("user_notes")
        data.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                Toast.makeText(context,"تأكد من اتصالك بالشبكة",Toast.LENGTH_SHORT).show()
            }

            override fun onDataChange(p0: DataSnapshot) {
                items!!.clear()
                if(p0!!.exists()){
                    for(item in p0!!.children){
                        items!!.add(item.getValue(user_note::class.java)!!)
                    }
                }
                Log.i("result",items!!.size.toString())
                adapter!!.notifyDataSetChanged()
            }
        })
    }

    fun initRecyclerView(){
        adapter = userAdapter(context!!,items)
        user_recyclerView.layoutManager = layoutMnager
        user_recyclerView.adapter = adapter
    }
}