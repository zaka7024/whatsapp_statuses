package whatsapp_situation.lemonlab.com.whatsapp_situation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.ads.AdRequest
import kotlinx.android.synthetic.main.layout_01.*
import whatsapp_situation.lemonlab.com.whatsapp_situation.data.DB_SQL_LITE
import whatsapp_situation.lemonlab.com.whatsapp_situation.data.dataModel_01
import com.google.android.gms.ads.InterstitialAd;


/**
 * Created by HP on 10/09/2018.
 */
class Fragment01() :Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_01,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {



        var db = DB_SQL_LITE(context!!)


        super.onActivityCreated(savedInstanceState)
        var layoutMnager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        var adapter = Adapter(context!!,db.loadDataFromDB('A'),'A')
        recyclerView_01.layoutManager = layoutMnager
        recyclerView_01.adapter = adapter

    }

}