package ryandoupe.acheivement.demo

import androidx.annotation.DrawableRes

data class IconAcheivment(val title: String, @DrawableRes val icon: Int, val dataPoint: String, val completed : Boolean = false) {

}
