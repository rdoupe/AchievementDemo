package ryandoupe.acheivement.demo

import androidx.lifecycle.ViewModel

class AcheivementsViewModel : ViewModel() {

    fun getAcheivementGroups(): ArrayList<AcheivmentGroup> {
        /*Mocked up data
        Real implementation would use a new thread/coroutine to make a call to repository who would ensure
        data is updated from network/cache and update via live data or other framework
         */

        val returnList = ArrayList<AcheivmentGroup>()

        val personalRecords = ArrayList<IconAcheivment>()
        personalRecords.add(IconAcheivment("Longest Run", R.drawable.acheivement_placeholder, "00:00",true))
        personalRecords.add(IconAcheivment("Highest Elevation", R.drawable.acheivement_placeholder, "2095 ft",true))
        personalRecords.add(IconAcheivment("Fastest 5k", R.drawable.acheivement_placeholder, "00:00",true))
        personalRecords.add(IconAcheivment("10K", R.drawable.acheivement_placeholder, "00:00:00",true))
        personalRecords.add(IconAcheivment("Half Marathon", R.drawable.acheivement_placeholder, "0:00:00",true))
        personalRecords.add(IconAcheivment("Marathon", R.drawable.acheivement_placeholder, "Not Yet")) //using kotlin default parameters for false

        val personalRecordGroup = AcheivmentGroup("Personal Records",personalRecords)
        returnList.add(personalRecordGroup)

        val virtualRaces = ArrayList<IconAcheivment>()
        virtualRaces.add(IconAcheivment("Virtual Half Marathon Race", R.drawable.acheivement_placeholder, "00:00",true))
        virtualRaces.add(IconAcheivment("Tokyo-Hakone Ekiden 2020", R.drawable.acheivement_placeholder, "2095 ft",true))
        virtualRaces.add(IconAcheivment("Virtual 10K Race", R.drawable.acheivement_placeholder, "00:00",true))
        virtualRaces.add(IconAcheivment("Hakone Ekiden", R.drawable.acheivement_placeholder, "00:00:00",true))
        virtualRaces.add(IconAcheivment("Mizuno Singapore Ekiden 2015", R.drawable.acheivement_placeholder, "0:00:00",true))
        virtualRaces.add(IconAcheivment("Virtual 5K Race", R.drawable.acheivement_placeholder, "23:07",true))

        val virtualRacesGroup = AcheivmentGroup("Virtual Races",virtualRaces)
        returnList.add(virtualRacesGroup)
        return returnList
    }

}
