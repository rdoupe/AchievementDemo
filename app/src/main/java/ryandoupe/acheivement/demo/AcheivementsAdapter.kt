package ryandoupe.acheivement.demo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AcheivementsAdapter : RecyclerView.Adapter<GroupViewHolder>() {
    private var groups: ArrayList<AcheivmentGroup> = ArrayList() //intialize empty for getItemCount

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        //get an inflater
        val inflater = LayoutInflater.from(parent.context)
        //create and return viewholder
        return GroupViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        holder.bind(groups.get(position), holder.itemView.context)
    }

    override fun getItemCount(): Int {
        return groups.size
    }

    fun setData(acheivements: ArrayList<AcheivmentGroup>) {
        this.groups = acheivements
    }


}

class GroupViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.acheivement_group, parent, false)) {
    private var title: TextView? = null
    private var completed: TextView? = null
    private var recyclerView: RecyclerView? = null

    //initialize view properties for use in bind function
    init {
        title = itemView.findViewById(R.id.groupTitle)
        completed = itemView.findViewById(R.id.completed)
        recyclerView = itemView.findViewById(R.id.groupRecyclerView)
    }


    fun bind(group: AcheivmentGroup, context: Context) {
        //set text for the header
        title?.text = group.title
        completed?.text = completedText(group.records, context)


        /*

        To add a activity specific Listview which is not a grid, but a series of text,
        something like this would work:

        if(group.type is "iconGrid") {
            setupAchievementIconAdapter()
            }
        if(group.type is "activitySpecific") {
            setupAchievmentTextAdapter()
         }
         */
        //create grid adapter for badges and text
        val adapter = AchievementIconAdapter()
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = GridLayoutManager(context, 2)

        //populate the data and notify
        adapter.setData(group.records)
        adapter.notifyDataSetChanged()
    }

    private fun completedText(group: List<IconAcheivment>, context: Context): CharSequence? {
        //count Acheivements with the completed flag
        val completed = group.count { it -> it.completed }
        //size of the total list
        val total = group.count()

        //format and return display string
        return context.getString(R.string.completed, completed, total)
    }
}
