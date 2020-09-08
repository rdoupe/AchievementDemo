package ryandoupe.acheivement.demo

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class AchievementIconAdapter : RecyclerView.Adapter<AchievementIconAdapter.IconViewHolder>() {
    private var acheivemnts: List<IconAcheivment> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IconViewHolder {
        //get LayoutInflater
        val inflater = LayoutInflater.from(parent.context)
        //create and return ViewHolder for use in bind
        return IconViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return acheivemnts.size;
    }

    override fun onBindViewHolder(holder: IconViewHolder, position: Int) {
        //bind the viewholder with data for it's position
        holder.bind(acheivemnts.get(position))
    }

    fun setData(achievements: List<IconAcheivment>) {
        this.acheivemnts = achievements
    }

    class IconViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.achievement_icon_element, parent, false)) {
        private var title: TextView? = null
        private var dataPoint: TextView? = null
        private var icon: ImageView? = null

        init {
            title = itemView.findViewById(R.id.title)
            dataPoint = itemView.findViewById(R.id.dataPoint)
            icon = itemView.findViewById(R.id.icon)
        }


        fun bind(iconAcheivment: IconAcheivment) {
            icon?.setImageResource(iconAcheivment.icon)

            //If it's not completed, increase transparency
            //using if for clarity/more functionality later (such as onClick)
            if (iconAcheivment.completed) {
                icon?.alpha = 1.0F
            } else {
                icon?.alpha = 0.5F
            }

            //set the text for the title and data point associated 
            title?.text = iconAcheivment.title
            dataPoint?.text = iconAcheivment.dataPoint
        }
    }
}
