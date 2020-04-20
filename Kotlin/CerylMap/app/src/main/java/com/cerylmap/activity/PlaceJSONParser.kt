package com.cerylmap.activity

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class PlaceJSONParser {

    fun parse(jObject: JSONObject): List<HashMap<String, String>?>? {
        var jPlaces: JSONArray? = null
        try {
            /** Retrieves all the elements in the 'places' array  */
            jPlaces = jObject.getJSONArray("predictions")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        /** Invoking getPlaces with the array of json object
         * where each json object represent a place
         */
        return jPlaces?.let { getPlaces(it) }
    }

    private fun getPlaces(jPlaces: JSONArray): List<HashMap<String, String>?>? {
        val placesCount = jPlaces.length()
        val placesList: MutableList<HashMap<String, String>?> =
            ArrayList()
        var place: HashMap<String, String>? = null
        /** Taking each place, parses and adds to list object  */
        for (i in 0 until placesCount) {
            try {
                /** Call getPlace with place JSON object to parse the place  */
                place = getPlace(jPlaces[i] as JSONObject)
                placesList.add(place)
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }
        return placesList
    }


    private fun getPlace(jPlace: JSONObject): HashMap<String, String>? {
        val place = HashMap<String, String>()
        var id = ""
        var reference = ""
        var description = ""
        try {
            description = jPlace.getString("description")
            id = jPlace.getString("id")
            reference = jPlace.getString("reference")
            place["description"] = description
            place["_id"] = id
            place["reference"] = reference
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return place
    }

}