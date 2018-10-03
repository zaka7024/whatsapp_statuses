package whatsapp_situation.lemonlab.com.whatsapp_situation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    replaceFragment(MainFragment())

    // INTI THE ADVIEW

      var request = AdRequest.Builder().build()
      MainadView.loadAd(request)

      lateinit var mInterstitialAd: InterstitialAd
      mInterstitialAd = InterstitialAd(this@MainActivity)
      mInterstitialAd.adUnitId = "ca-app-pub-9769401692194876/7456298633"
      mInterstitialAd.loadAd(AdRequest.Builder().build())
    bottomNavigationView.setOnNavigationItemSelectedListener {
      when(it.itemId){
        R.id.home ->{
          if (mInterstitialAd.isLoaded) {
            mInterstitialAd.show()
          }
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