package whatsapp_situation.lemonlab.com.whatsapp_situation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(MainFragment())

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home ->{
                    replaceFragment(MainFragment())
                    true
                }
                R.id.liked ->{
                    replaceFragment(favFragment())
                    true
                }
                else -> {
                    replaceFragment(AddNoteFragment())
                    /*var manager = supportFragmentManager.beginTransaction()
                    manager.remove((favFragment()));*/
                    true
                }
            }
        }
    }

    fun replaceFragment(fragment:Fragment){
        var manager = supportFragmentManager.beginTransaction()
        manager.replace(R.id.fragmentContainer,fragment)
        manager.commit()
    }
}
