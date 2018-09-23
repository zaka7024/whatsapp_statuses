package whatsapp_situation.lemonlab.com.whatsapp_situation

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import kotlinx.android.synthetic.main.item_layout.view.*
import whatsapp_situation.lemonlab.com.whatsapp_situation.data.DB_SQL_LITE
import whatsapp_situation.lemonlab.com.whatsapp_situation.data.note
import whatsapp_situation.lemonlab.com.whatsapp_situation.data.user_note

/**
 * Created by HP on 10/09/2018.
 */
class userAdapter(var context: Context, var dataList:ArrayList<user_note>): RecyclerView.Adapter<userAdapter.viewHolder>(){

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.getData(dataList[position].text,dataList[position],position)
        YoYo.with(Techniques.FadeIn).playOn(holder.itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return viewHolder(view)
    }

    inner class viewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var cuurentNote: user_note? = null
        var cuurentPosition = 0
        init{
            itemView.like_image.visibility = View.INVISIBLE

            itemView.setOnClickListener {
                Toast.makeText(context, cuurentPosition.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        fun getData(stateText:String, Note: user_note, pos:Int){
            cuurentNote = Note
            itemView.state_text.text = Note.text
            cuurentPosition = pos
        }
    }
}