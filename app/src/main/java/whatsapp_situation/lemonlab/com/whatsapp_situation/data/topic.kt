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
            add("امثال شعبية")
            add("حالات الصباح")
            add("حالات دعاء")
            add("حالات دينية")
            add("حالات ضحك")
            add("حالات حكم")
            add("حالات رمضان")
            add("منشورات العيد")
            add("منشورات مسائية")

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
           add(R.drawable.quotes) // quotes
           add(R.drawable.dooa) // Doa'a
           add(R.drawable.allah) // islamic
           add(R.drawable.joke) /// joke
           add(R.drawable.image3) // ramadan
           add(R.drawable.eid) // eid
        }
    }
}