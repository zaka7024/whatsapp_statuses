package whatsapp_situation.lemonlab.com.whatsapp_situation

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Intent
import android.support.v7.widget.CardView
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
import whatsapp_situation.lemonlab.com.whatsapp_situation.data.favourites
import whatsapp_situation.lemonlab.com.whatsapp_situation.data.note

/**
 * Created by HP on 10/09/2018.
 */
class Adapter(var context:Context, var dataList:ArrayList<note>, var type:Char):RecyclerView.Adapter<Adapter.viewHolder>(){
    var db = DB_SQL_LITE(context)
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.getData(dataList[position].text,dataList[position])
        Log.i("note",db.loadDataFromDB(type)[position].liked.toString())
        if(db.loadDataFromDB(type)[position].liked == 0){
            holder.itemView.like_image.setImageResource(R.drawable.ic_action_like)
            //db.loadDataFromDB()[position].liked = 1
        }else{
            holder.itemView.like_image.setImageResource(R.drawable.ic_action_like_selected)
            //db.loadDataFromDB()[position].liked = 1
        }
        YoYo.with(Techniques.FadeInUp).playOn(holder.itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return viewHolder(view)
    }

    inner class viewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        var cuurentNote:note? = null

        init{
            itemView.like_image.setOnClickListener {
                if(cuurentNote!!.liked == 1){
                    Toast.makeText(context,"تم الحذف من المفضلة",Toast.LENGTH_SHORT).show()
                    itemView.like_image.setImageResource(R.drawable.ic_action_like)
                    cuurentNote!!.liked = 0
                    db.deleteData(cuurentNote!!.id)
                    db.updateData(cuurentNote!!.id,0)
                }else{
                    Toast.makeText(context,"تم الاضافة الى المفضلة",Toast.LENGTH_SHORT).show()
                    itemView.like_image.setImageResource(R.drawable.ic_action_like_selected)
                    db.insertDataFavourites(cuurentNote!!.id,cuurentNote!!.text,1)
                    db.updateData(cuurentNote!!.id,1)
                    cuurentNote!!.liked = 1
                }
            }

            itemView.share_iamgeView.setOnClickListener {
                var intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT,cuurentNote!!.text)
                context.startActivity(Intent.createChooser(intent,"مشاركة الى:"))
            }

            itemView.copy_imageView.setOnClickListener {
                var myClip = ClipData.newPlainText("text", cuurentNote!!.text);
                var myClipboard:ClipboardManager = (context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?)!!;
                myClipboard?.setPrimaryClip(myClip)
                Toast.makeText(context,"تم النسخ",Toast.LENGTH_SHORT).show()
            }

            itemView.setOnClickListener {
                Toast.makeText(context,cuurentNote!!.id,Toast.LENGTH_SHORT).show()
            }
        }

        fun getData(stateText:String, Note:note){
            cuurentNote = Note
            itemView.state_text.text = Note.text
        }
    }
}