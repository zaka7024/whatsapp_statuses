package whatsapp_situation.lemonlab.com.whatsapp_situation

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import whatsapp_situation.lemonlab.com.whatsapp_situation.data.DB_SQL_LITE
import whatsapp_situation.lemonlab.com.whatsapp_situation.data.TopicAdapter
import whatsapp_situation.lemonlab.com.whatsapp_situation.data.topic

/**
 * Created by HP on 10/09/2018.
 */
class MainFragment() : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var layoutmanager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        var adapter = TopicAdapter(context!!, topic.topic_data, topic.topic_images,activity!!.supportFragmentManager!!)

        mainFragementRecylerView.layoutManager = layoutmanager
        mainFragementRecylerView.adapter = adapter
    }
}