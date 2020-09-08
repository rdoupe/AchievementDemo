package ryandoupe.acheivement.demo

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/*
General things to I would add/consider for this implementation:
    - Change back arrow graphic
    - integrating into existing navigation, for now just using single activity
    - Localization and different configurations (XHDPI, Landscape, Tablet etc)
    - Tie into Settings for Metric vs Imperial units, depending on Existing Architecture
    - Themes -> to be tied in with existing application theme,  current color/font/spacing is basic
    as a proof of concept
    - Dagger, Koin or similar to fit in with existing Application Architecture
    - Actual ViewModel tied into cache/network layer with LiveData or similar libraries
    - potential for reuse on the Achievements Preview on the "Me" page of the Production App
    - Data Validation in the ViewModel or Repository
    - Unit tests for handing of Data
    - Second Type of Adapter along with AchievementIcons for Activity Specific Achievements, which
     is text rows instead of Grid with Icons
 */


class MainActivity : AppCompatActivity() {

    //properties not needed for this example, but good practice.
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewIconAdapter: AchievementIconAdapter
    private lateinit var acheivementsAdapter: AcheivementsAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set action bar to use support lib
        setSupportActionBar(findViewById(R.id.my_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        //create our sub adapter for Icon Achievements
        viewIconAdapter = AchievementIconAdapter()
        acheivementsAdapter = AcheivementsAdapter()

        //viewManager = GridLayoutManager(this, 2)
        viewManager = LinearLayoutManager(this)


        //create our recyclerview and set layoutmanager and adapter
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            setHasFixedSize(false)
            layoutManager = viewManager
            adapter = acheivementsAdapter
        }


        //initiate viewmodel, locally as we are only using it once, using kotlin fragment
        val model: AcheivementsViewModel by viewModels()

        /*in a production app, using live data/observe to update and notify
        model.getAchievements().observe(this, Observer<List<Achievement>>{
            viewAdapter.setData(it)
            viewAdapter.notifyDataSetChanged()
        }
         */
        acheivementsAdapter.setData(model.getAcheivementGroups())
        acheivementsAdapter.notifyDataSetChanged()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }
}