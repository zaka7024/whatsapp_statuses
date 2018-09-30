package whatsapp_situation.lemonlab.com.whatsapp_situation

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import kotlinx.android.synthetic.main.item_layout.view.*
import whatsapp_situation.lemonlab.com.whatsapp_situation.data.DB_SQL_LITE
import whatsapp_situation.lemonlab.com.whatsapp_situation.data.note

/**
 * Created by HP on 10/09/2018.
 */
class favAdapter(var context: Context, var dataList:ArrayList<note>): RecyclerView.Adapter<favAdapter.viewHolder>(){
    var db = DB_SQL_LITE(context)
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.getData(dataList[position].text,dataList[position],position)
        //Log.i("note", db.loadDataFromDB()[position].liked.toString())
        if(db.loadDataFromFavourites()[position].liked == 0){
            holder.itemView.like_image.setImageResource(R.drawable.ic_action_like)
            //db.loadDataFromDB()[position].liked = 1
        }else{
            holder.itemView.like_image.setImageResource(R.drawable.ic_action_like_selected)
            //db.loadDataFromDB()[position].liked = 1
        }
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

        var cuurentNote: note? = null
        var cuurentPosition = 0
        init{
            itemView.like_image.setOnClickListener {
                db.deleteData(cuurentNote!!.id)
                db.updateData(cuurentNote!!.id,0)
                dataList.removeAt(cuurentPosition)
                notifyItemRemoved(cuurentPosition)
                notifyDataSetChanged()
            }

            itemView.setOnClickListener {
                Toast.makeText(context, cuurentPosition.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        fun getData(stateText:String, Note: note, pos:Int){
            cuurentNote = Note
            itemView.state_text.text = Note.text
            cuurentPosition = pos
        }
    }
}