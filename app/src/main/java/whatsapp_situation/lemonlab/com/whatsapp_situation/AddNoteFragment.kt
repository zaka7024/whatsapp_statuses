package whatsapp_situation.lemonlab.com.whatsapp_situation

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.net.Uri
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

        privacy.setOnClickListener {
            var dialog = AlertDialog.Builder(context)
            dialog.setTitle("سياسة الخصوصية")
            dialog.setMessage("Privacy Policy of Lemon Lab\n" +
                    "\n" +
                    "Lemon Lab offers, which provides the SERVICE.\n" +
                    "\n" +
                    "This page is used to inform lemonlab offers visitors regarding our policies with the collection, use, and disclosure of Personal Information if anyone decided to use our Service, the Lemon Lab.\n" +
                    "\n" +
                    "If you choose to use our Service, then you agree to the collection and use of information in relation with this policy. The Personal Information that we collect are used for providing and improving the Service. We will not use or share your information with anyone except as described in this Privacy Policy.\n" +
                    "\n" +
                    "The terms used in this Privacy Policy have the same meanings as in our Terms and Conditions, which is accessible at Lemonlab, unless otherwise defined in this Privacy Policy.\n" +
                    "\n" +
                    "Information Collection and Use\n" +
                    "\n" +
                    "For a better experience while using our Service, we may require you to provide us with certain personally identifiable information, including but not limited to your name, phone number, and postal address. The information that we collect will be used to contact or identify you.\n" +
                    "\n" +
                    "Log Data\n" +
                    "\n" +
                    "We want to inform you that whenever you visit our Service, we collect information that your browser sends to us that is called Log Data. This Log Data may include information such as your computer’s Internet Protocol (\"IP\") address, browser version, pages of our Service that you visit, the time and date of your visit, the time spent on those pages, and other statistics.\n" +
                    "\n" +
                    "Cookies\n" +
                    "\n" +
                    "Cookies are files with small amount of data that is commonly used an anonymous unique identifier. These are sent to your browser from the website that you visit and are stored on your computer’s hard drive.\n" +
                    "\n" +
                    "Our apps uses these \"cookies\" to collection information and to improve our Service. You have the option to either accept or refuse these cookies, and know when a cookie is being sent to your computer. If you choose to refuse our cookies, you may not be able to use some portions of our Service.\n" +
                    "\n" +
                    "Service Providers\n" +
                    "\n" +
                    "We may employ third-party companies and individuals due to the following reasons:\n" +
                    "\n" +
                    "To facilitate our Service;\n" +
                    "To provide the Service on our behalf; \n" +
                    "To perform Service -related services; \n" +
                    "or \n" +
                    "To assist us in analyzing how our Service is used.\n" +
                    "\n" +
                    "We want to inform our Service users that these third parties have access to your Personal Information. The reason is to perform the tasks assigned to them on our behalf. However, they are obligated not to disclose or use the information for any other purpose.\n" +
                    "\n" +
                    "Security\n" +
                    "\n" +
                    "We value your trust in providing us your Personal Information, thus we are striving to use commercially acceptable means of protecting it. But remember that no method of transmission over the internet, or method of electronic storage is 100% secure and reliable, and we cannot guarantee its absolute security.\n" +
                    "\n" +
                    "Links to Other Sites\n" +
                    "\n" +
                    "Our Service may contain links to other sites. If you click on a third-party link, you will be directed to that site. Note that these external sites are not operated by us. Therefore, we strongly advise you to review the Privacy Policy of these websites. We have no control over, and assume no responsibility for the content, privacy policies, or practices of any third-party sites or services.\n" +
                    "\n" +
                    "Children’s Privacy\n" +
                    "\n" +
                    "Our Services do not address anyone under the age of 6. We do not knowingly collect personal identifiable information from children under 6. In the case we discover that a child under 6 has provided us with personal information, we immediately delete this from our servers. If you are a parent or guardian and you are aware that your child has provided us with personal information, please contact us so that we will be able to do necessary actions.\n" +
                    "\n" +
                    "Changes to This Privacy Policy\n" +
                    "\n" +
                    "We may update our Privacy Policy from time to time. Thus, we advise you to review this page periodically for any changes. We will notify you of any changes by posting the new Privacy Policy on this page. These changes are effective immediately, after they are posted on this page.\n" +
                    "\n" +
                    "Contact Us\n" +
                    "\n" +
                    "If you have any questions or suggestions about our Privacy Policy, do not hesitate to contact us at zaka7024@gmail.com.")
            dialog.show()
            dialog.setPositiveButton("موافق",DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            })
        }

        send_user_note_btn.setOnClickListener {

            if(user_note_textView.text.trim().isEmpty()){
                Toasty.error(context!!,"نص فارغ",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var data = FirebaseDatabase.getInstance().getReference("user_notes")
            progressbar_add_note_layout.visibility = View.VISIBLE
            var note_id = data.push().key
            var new_note = user_note(note_id!!,user_note_textView.text.toString())

            data.child(note_id).setValue(new_note).addOnCompleteListener {
                progressbar_add_note_layout.visibility = View.INVISIBLE
                Toasty.custom(context!!, "تم إرسال حالتك", R.drawable.ic_action_check, context!!.resources.getColor(R.color.purble), 1000, true,
                        true).show();
            }
        }
    }
}