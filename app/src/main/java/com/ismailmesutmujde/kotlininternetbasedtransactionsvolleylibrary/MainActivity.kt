package com.ismailmesutmujde.kotlininternetbasedtransactionsvolleylibrary

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // this result was taken from here: http://kasimadalan.pe.hu/kisiler/tum_kisiler.php

        //deletePerson()
        //insertPerson()
        updatePerson()
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
}