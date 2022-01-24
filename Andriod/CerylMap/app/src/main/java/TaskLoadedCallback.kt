import com.google.android.gms.maps.model.PolylineOptions


interface TaskLoadedCallback {
    fun onTaskDone(vararg values: PolylineOptions?)
}
