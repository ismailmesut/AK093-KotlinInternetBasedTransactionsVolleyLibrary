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

        // this result was taken from here: https://kasimadalan.pe.hu/kisiler/delete_kisiler.php

        deletePerson()
    }

    fun deletePerson() {
        val url = "https://kasimadalan.pe.hu/kisiler/delete_kisiler.php"

        val request = object : StringRequest(Method.POST, url, Response.Listener { answer->
            Log.e("Delete Process Answer", answer)
        }, Response.ErrorListener { e -> e.printStackTrace() }) {
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String, String>()
                params["kisi_id"] = "380"
                return params
            }
        }
        Volley.newRequestQueue(this@MainActivity).add(request)
    }
}