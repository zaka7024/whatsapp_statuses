package whatsapp_situation.lemonlab.com.whatsapp_situation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_02.*
import whatsapp_situation.lemonlab.com.whatsapp_situation.data.DB_SQL_LITE
import whatsapp_situation.lemonlab.com.whatsapp_situation.data.dataModel_01
import whatsapp_situation.lemonlab.com.whatsapp_situation.data.favourites

/**
 * Created by HP on 10/09/2018.
 */
class favFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_02,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var db = DB_SQL_LITE(context!!)

        var layoutMnager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        var adapter = favAdapter(context!!, db.loadDataFromFavourites())

        favRecyclerView.layoutManager = layoutMnager
        favRecyclerView.adapter = adapter
    }
}