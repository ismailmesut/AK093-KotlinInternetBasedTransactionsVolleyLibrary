package com.ismailmesutmujde.kotlininternetbasedtransactionsvolleylibrary

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // this result was taken from here: http://kasimadalan.pe.hu/kisiler/tum_kisiler.php

        //deletePerson()
        //insertPerson()
        //updatePerson()
        allPersons()
    }

    fun deletePerson() {
        val url = "http://kasimadalan.pe.hu/kisiler/delete_kisiler.php"

        val request = object : StringRequest(Method.POST, url, Response.Listener { answer->
            Log.e("Delete Process Answer", answer)
        }, Response.ErrorListener { e -> e.printStackTrace() }) {
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String, String>()
                params["kisi_id"] = "17722"
                return params
            }
        }
        Volley.newRequestQueue(this@MainActivity).add(request)
    }

    fun insertPerson() {
        val url = "http://kasimadalan.pe.hu/kisiler/insert_kisiler.php"
        val request = object : StringRequest(Method.POST, url, Response.Listener { answer->
            Log.e("Insert Process Answer", answer)
        },Response.ErrorListener { e -> e.printStackTrace() }) {
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String, String>()
                params["kisi_ad"] = "ismail2"
                params["kisi_tel"] = "222222"
                return params
            }
        }
        Volley.newRequestQueue(this@MainActivity).add(request)
    }

    fun updatePerson() {
        val url = "http://kasimadalan.pe.hu/kisiler/update_kisiler.php"
        val request = object : StringRequest(Method.POST, url, Response.Listener { answer->
            Log.e("Update Process Answer", answer)
        },Response.ErrorListener { e -> e.printStackTrace() }) {
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String, String>()
                params["kisi_id"] = "17721"
                params["kisi_ad"] = "ismail2"
                params["kisi_tel"] = "123123000"
                return params
            }
        }
        Volley.newRequestQueue(this@MainActivity).add(request)
    }

    fun allPersons() {
        val url = "http://kasimadalan.pe.hu/kisiler/tum_kisiler.php"
        val request = StringRequest(Request.Method.GET, url, Response.Listener { answer->
            Log.e("Data Reading Answer", answer)

            try {
                val jsonObject = JSONObject(answer)
                val personsList = jsonObject.getJSONArray("kisiler")

                for(i in 0 until personsList.length()) {
                    val p = personsList.getJSONObject(i)
                    val person_id = p.getInt("kisi_id")
                    val person_name = p.getString("kisi_ad")
                    val person_phone = p.getString("kisi_tel")

                    Log.e("person_id", person_id.toString())
                    Log.e("person_name",person_name)
                    Log.e("person_phone", person_phone)
                    Log.e("*********","*********")
                }
            }catch (e: JSONException) {
                e.printStackTrace()
            }
        },Response.ErrorListener { e -> e.printStackTrace() })
        Volley.newRequestQueue(this@MainActivity).add(request)
    }
}