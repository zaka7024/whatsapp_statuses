package whatsapp_situation.lemonlab.com.whatsapp_situation.data

import whatsapp_situation.lemonlab.com.whatsapp_situation.R

/**
 * Created by HP on 12/09/2018.
 */
class topic {
    companion object {
        var topic_data:ArrayList<String> = ArrayList<String>().apply {
            add("حالات رومنسية")
            add("حالات حزن")
            add("حالات حب")
            add("حالات الاصدقاء")
            add("حالات منوعة")
            add("حالات حكم")
            add("حالات الى الام")
            add("حالات الصباح")
            add("امثال شعبية")
            add("منشورات مسائية")
            add("حالات دعاء")
            add("حالات دينية")
            add("حالات ضحك")
            add("حالات رمضان")
            add("منشورات العيد")
            add("منشورات المتابعين")

        }

        var topic_images:ArrayList<Int> = ArrayList<Int>().apply {
           add(R.drawable.image9) // romantic
           add(R.drawable.image8) // sad
           add(R.drawable.love) // love
           add(R.drawable.image4) // friends
           add(R.drawable.different) // different
           add(R.drawable.wisdom) // wisdom
           add(R.drawable.image2) // mother
            add(R.drawable.image7)  // morning
           add(R.drawable.arabic_calligraphy) // people
            add(R.drawable.image5) // night
           add(R.drawable.dooa) // Doa'a
           add(R.drawable.allah) // islamic
           add(R.drawable.joke) /// joke
           add(R.drawable.image3) // ramadan
           add(R.drawable.eid) // eid
           add(R.drawable.followers) // followers
        }
    }
}