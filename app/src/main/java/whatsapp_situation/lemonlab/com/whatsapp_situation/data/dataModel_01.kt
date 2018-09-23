package whatsapp_situation.lemonlab.com.whatsapp_situation.data

/**
 * Created by HP on 10/09/2018.
 */

data class note(var id:String = "",val text:String, var liked:Int)
class dataModel_01 {
    companion object {
        var data = ArrayList<note>().apply {
            add(note("A-1","0", 0))
            add(note("A-2","1", 0))
            add(note("A-3","2", 0))
        }
    }
}