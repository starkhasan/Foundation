package com.ali.covid_case.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.ali.covid_case.R
import com.ali.covid_case.app.ConnectivityReceiver
import com.ali.covid_case.app.RegisterAbstractActivity
import com.ali.covid_case.network.ApiCallService
import com.ali.covid_case.network.response.CountryResponse
import com.ali.covid_case.network.response.History.HistoryResponse
import com.ali.covid_case.util.AppUser
import com.ali.covid_case.util.Cv
import com.ali.covid_case.util.LocalRepositories
import com.ali.covid_case.util.Preferences
import kotlinx.android.synthetic.main.activity_home.*
import org.greenrobot.eventbus.Subscribe
import java.util.ArrayList

class HomePageActivity : RegisterAbstractActivity() {

    var countryList = ArrayList<String>()
    var appUser : AppUser? = null
    var isFirst = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        appUser = LocalRepositories.getAppUser(applicationContext)
        apiGetCountries()

        spnrCountry.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if(isFirst)
                    isFirst = false
                else{
                    Preferences.country = countryList.get(position).toLowerCase()
                    Preferences.day = "2020-06-02"
                    ApiCallService.action(applicationContext,Cv.ACTION_GET_HISTORY)
                }
            }
        }

    }

    override fun layoutId(): Int {
        return R.layout.activity_home
    }

    override fun onResume() {
        super.onResume()
        apiGetCountries()
    }

    fun apiGetCountries(){
        if(ConnectivityReceiver().isConnected()){
            rotateloading.start()
            ApiCallService.action(applicationContext, Cv.ACTION_GET_COUNTRY)
        }else{
            Toast.makeText(applicationContext,"No Internet Connection",Toast.LENGTH_SHORT).show()
        }
    }

    @Subscribe
    fun get_History(response: HistoryResponse){
        Toast.makeText(applicationContext,response.get,Toast.LENGTH_SHORT).show()
    }

    @Subscribe
    fun get_country(response: CountryResponse){
        if(rotateloading.isStart){
            rotateloading.stop()
        }
        if(response.results == 220){
            countryList = response.response as ArrayList<String>
            val adapter = ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,countryList)
            spnrCountry.adapter = adapter
        }else{
            Toast.makeText(applicationContext,"not Working",Toast.LENGTH_SHORT).show()
        }
    }

    @Subscribe
    fun timeout(msg:String){
        if(rotateloading.isStart){
            rotateloading.stop()
        }
        Toast.makeText(applicationContext,msg,Toast.LENGTH_SHORT).show()
    }
}