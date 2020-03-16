package com.cerylmap

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cerylmap.adapter.SearchAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.UnsupportedEncodingException
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder


class MainActivity : AppCompatActivity() {

    companion object{
        var map =  ArrayList<HashMap<String, String>>()
        var hashMap =  HashMap<String, String>()
        lateinit var locality:String
        var jObject: JSONObject? = null
        var postalCode: String? = null
        var city: String? = null
        var state: String? = null
        var STREETNAME = ""
        var list = ArrayList<String>()
        var linearLayoutManager:LinearLayoutManager?=null
        //var searchAdapter:SearchAdapter?=null
        var context:Context?=null
        lateinit var rvSearch:RecyclerView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etSearch.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(string: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(string: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var placesTask = PlacesTask()
                val toPass = arrayOfNulls<String>(2)
                toPass[0] = string.toString()
                placesTask.execute(*toPass)
            }

        })

    }

   class PlacesTask : AsyncTask<String,Void,String>(){

        override fun doInBackground(vararg place: String?): String {
            var data=""
            val key = "key=AIzaSyBcFpWT7vu4mLXbEPmkr5GJDG5jWBI67x0"
            var input = ""

            try {
                input = "input=" + URLEncoder.encode(place.get(0), "utf-8")
            } catch (e1: UnsupportedEncodingException) {
                e1.printStackTrace()
            }

            val parameters = "$input&$key&components=country:usa"
            // Output format +gpsTracker.getLatitude() + "," + gpsTracker.getLongitude() + "&radius=20000
            // Output format +gpsTracker.getLatitude() + "," + gpsTracker.getLongitude() + "&radius=20000
            val output = "json"

            // Building the url to the web service
            // Building the url to the web service
            //https://maps.googleapis.com/maps/api/place/autocomplete/json?input=1600+Amphitheatre&key=AIzaSyBcFpWT7vu4mLXbEPmkr5GJDG5jWBI67x0&components=country:usa
            val url = "https://maps.googleapis.com/maps/api/place/autocomplete/$output?$parameters"
            try { // Fetching the data from we service
                data = downloadUrl(url)
                //SearchViewModelActivity
            } catch (e: Exception) {
                Log.d("Background Task", e.toString())
            }
            return data
        }



       override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            // Creating ParserTask
            var parserTask = ParserTask()
            val strData = arrayOfNulls<String>(2)
            strData[0] = result
            parserTask.execute(*strData)
        }

       private fun downloadUrl(strUrl: String): String {
           var data=""
           var iStream: InputStream? = null
           var urlConnection: HttpURLConnection? = null
           try {
               val url = URL(strUrl)
               // Creating an http connection to communicate with url
               urlConnection = url.openConnection() as HttpURLConnection
               // Connecting to url
               urlConnection.connect()
               // Reading data from url
               iStream = urlConnection.getInputStream()
               val br = BufferedReader(InputStreamReader(iStream))
               val sb = StringBuilder()
               var line: String? = ""
               while (br.readLine().also({ line = it }) != null) {
                   sb.append(line)
               }
               data = sb.toString()
               br.close()
           } catch (e: java.lang.Exception) {
           } finally {
               iStream?.close()
               urlConnection?.disconnect()
           }
           return data
       }
    }

    class ParserTask : AsyncTask<String,Int,List<HashMap<String,String>>>(){

        lateinit var JSONObject : JSONObject
        override fun doInBackground(vararg json: String?): List<HashMap<String, String>>? {
            var places: List<HashMap<String, String>>? = null
            var placeJsonParser = PlaceJSONParser()

            try {
                JSONObject = JSONObject(json.get(0))
                // Getting the parsed data as a List construct
                places = placeJsonParser.parse(JSONObject) as List<HashMap<String, String>>?
            } catch (e: java.lang.Exception) {
                Log.d("Exception", e.toString())
            }

            return places
        }

        override fun onPostExecute(result: List<HashMap<String, String>>?) {
            var list = ArrayList<Any>()
            val from = arrayOf("description")
            val to = intArrayOf(android.R.id.text1)

            for (i in 0 until result!!.size) {
                result[i]["description"]?.let { list.add(it) }
                result[i]["reference"]?.let { hashMap.put("reference", it) }
                map.add(hashMap)
            }


            var searchAdapter : SearchAdapter = SearchAdapter(context as Activity,list){ position:Int, view:View ->
                locality = map.get(position).get("reference").toString()
                STREETNAME = list.get(position) as String;
                var localityTask = GEtLocalityTask()
                localityTask.execute(locality);
                var url = " https://maps.googleapis.com/maps/apin/place/details/jso?key=AIzaSyBcFpWT7vu4mLXbEPmkr5GJDG5jWBI67x0&placeid="+locality
            }


            rvSearch = (context as Activity).findViewById(R.id.rvSearchResult)
            linearLayoutManager = LinearLayoutManager(context as Activity,LinearLayoutManager.VERTICAL,false)
            rvSearch.layoutManager = linearLayoutManager
            rvSearch.adapter = searchAdapter

            //activity.getBinding().rvSearch.setAdapter(adapter);
            //activity.getBinding().rvSearch.setLayoutManager(new LinearLayoutManager(activity));
            //activity.getBinding().rvSearch.setAdapter(adapter);

        }
    }

    class GEtLocalityTask : AsyncTask<String, Void, String>() {

        override fun doInBackground(vararg place: String?): String {
            // For storing data from web service
            // For storing data from web service
            var data: String? = ""
            val url = "https://maps.googleapis.com/maps/api/place/details/json?key=AIzaSyBcFpWT7vu4mLXbEPmkr5GJDG5jWBI67x0&placeid=$locality"
            try { // Fetching the data from we service
                data = secondUrl(url)
            } catch (e: java.lang.Exception) {
                Log.d("Background Task", e.toString())
            }
            return data!!
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            // Creating ParserTask
            // Starting Parsing the JSON string returned by Web Service
            var localityParserTAsk = LocalityParserTAsk()
            localityParserTAsk.execute(result)
        }

        private fun secondUrl(strUrl: String): String? {
            var data = ""
            var iStream: InputStream? = null
            var urlConnection: HttpURLConnection? = null
            try {
                val url = URL(strUrl)
                // Creating an http connection to communicate with url
                urlConnection = url.openConnection() as HttpURLConnection
                // Connecting to url
                urlConnection.connect()
                // Reading data from url
                iStream = urlConnection!!.inputStream
                val br = BufferedReader(InputStreamReader(iStream))
                val sb = java.lang.StringBuilder()
                var line: String? = ""
                while (br.readLine().also { line = it } != null) {
                    sb.append(line)
                }
                data = sb.toString()
                br.close()
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            } finally {
                iStream!!.close()
                urlConnection!!.disconnect()
            }
            return data
        }

    }

    class LocalityParserTAsk : AsyncTask<String, Int, HashMap<String, String>>(){

        override fun doInBackground(vararg jsonData: String?): HashMap<String, String> {

            try {
                jObject = JSONObject(jsonData[0])
                val addressComponents =
                    jObject!!.getJSONObject("result").getJSONArray("address_components")
                for (i in 0 until addressComponents.length()) {
                    val typesArray =
                        addressComponents.getJSONObject(i).getJSONArray("types")
                    for (j in 0 until typesArray.length()) {
                        if (typesArray[j].toString().equals("postal_code", ignoreCase = true)) {
                            postalCode = addressComponents.getJSONObject(i).getString("long_name")
                            hashMap["postal_code"] = postalCode.toString()
                        }
                        if (typesArray[j].toString().equals("locality", ignoreCase = true)) {
                            city = addressComponents.getJSONObject(i).getString("long_name")
                            hashMap["locality"] = city.toString()
                        }
                        if (typesArray[j].toString().equals(
                                "administrative_area_level_1",
                                ignoreCase = true
                            )
                        ) {
                            state = addressComponents.getJSONObject(i).getString("long_name")
                            hashMap["administrative_area_level_1"] = state.toString()
                        }
                        city?.let { list.add(it) }
                    }
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            return hashMap
        }

        override fun onPostExecute(result: HashMap<String, String>?) {
            super.onPostExecute(result)
            var list = ArrayList<Any>()
            var intent: Intent?=null
            if (hashMap.containsKey("postal_code")) {
                intent?.putExtra("postal_code", hashMap.get("postal_code"))
            }
            if (hashMap.containsKey("locality")) {
                intent?.putExtra("locality", hashMap.get("locality"))
            }
            if (hashMap.containsKey("administrative_area_level_1")) {
                intent?.putExtra("state", hashMap.get("administrative_area_level_1"))
            }
            intent?.putExtra("street_name", STREETNAME);
        }
    }

}