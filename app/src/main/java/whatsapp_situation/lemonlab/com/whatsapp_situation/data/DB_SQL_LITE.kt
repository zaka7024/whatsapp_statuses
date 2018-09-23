package whatsapp_situation.lemonlab.com.whatsapp_situation.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.ArrayAdapter

/**
 * Created by HP on 11/09/2018.
 */
class DB_SQL_LITE(context:Context):SQLiteOpenHelper(context,"data.db",null, 1){

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("create table fav_table ( id TEXT, text TEXT , liked INTEGER)")
        db!!.execSQL("create table dataModel_01 ( id TEXT, text TEXT , liked INTEGER)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS fav_table")
        db!!.execSQL("DROP TABLE IF EXISTS dataModel_01")
        onCreate(db)
    }

    fun insertData(id:String,text:String,liked:Int):Boolean{
        var db = this.writableDatabase
        var content = ContentValues()
        content.put("id",id)
        content.put("text",text)
        content.put("liked",liked)
        var done = db.insert("dataModel_01",null,content)

        return done == -1.toLong()
    }

    fun loadDataFromDB(type:Char):ArrayList<note>{
        var db = this.readableDatabase
        var res = db.rawQuery("select * from dataModel_01",null)
        res.moveToFirst()

        var data:ArrayList<note> = ArrayList<note>()

        while(res.isAfterLast == false){
            var id = res.getString(0)
            if(id[0]== type){
                var text = res.getString(1)
                var liked = res.getInt(2)
                data.add(note(id,text,liked))
            }
            res.moveToNext()
        }
        return data
    }

    fun updateData(id:String,liked: Int){
        var db = writableDatabase
        var content = ContentValues()
        content.put("liked",liked)
        db.update("dataModel_01",content,"id= ?", Array<String>(1){id})
    }

    fun deleteData(id:String){
        var db = writableDatabase
        db.delete("fav_table","id= ?", Array<String>(1){id})
    }

    fun loadDataFromFavourites():ArrayList<note>{
        var db = this.readableDatabase
        var res = db.rawQuery("select * from fav_table", null)
        res.moveToFirst()

        var data:ArrayList<note> = ArrayList<note>()

        while(res.isAfterLast == false){
            var id = res.getString(0)
            var text = res.getString(1)
            var liked = res.getInt(2)
            data.add(note(id,text,liked))
            res.moveToNext()
        }
        return data
    }

    fun insertDataFavourites(id:String,text:String,liked:Int):Boolean{
        var db = this.writableDatabase
        var content = ContentValues()
        content.put("id",id)
        content.put("text",text)
        content.put("liked",liked)
        var done = db.insert("fav_table",null,content)

        return done == -1.toLong()
    }

}
