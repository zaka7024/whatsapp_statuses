package whatsapp_situation.lemonlab.com.whatsapp_situation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_01.*
import whatsapp_situation.lemonlab.com.whatsapp_situation.data.DB_SQL_LITE

/**
 * Created by HP on 10/09/2018.
 */
class Fragment07() : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_01,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        var db = DB_SQL_LITE(context!!)
        //db.insertData("A-1","بحبك ❤",0)
        //db.insertData("A-2","صباح الخير يا تافه",0)
        //db.insertData("B-1","بكرهك 🤦",0)
        //db.insertData("B-2","تبًا لكم جميعًا",0)

        super.onActivityCreated(savedInstanceState)
        var layoutMnager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        var adapter = Adapter(context!!, db.loadDataFromDB('G'), 'G')

        recyclerView_01.layoutManager = layoutMnager
        recyclerView_01.adapter = adapter
    }
}