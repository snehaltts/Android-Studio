package com.example.genbroadcast

import android.content.Context
import android.content.IntentFilter
import android.content.SharedPreferences
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var sp : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sp = getSharedPreferences("myfile", Context.MODE_PRIVATE)

       /* var myrec = MyReceiver()
        var myIntentfilter = IntentFilter("android.intent.action.AIRPLANE_MODE")
        registerReceiver(myrec,myIntentfilter)


        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.RECEIVE_SMS)
                == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "PERMISSION GRANTED", Toast.LENGTH_LONG).show()
        }

        else
        {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.RECEIVE_SMS), 123)
        }*/
        editTextTextPersonName.setText(sp.getString("un",""))

        buttonSAve.setOnClickListener {
            var username = editTextTextPersonName.text.toString()
            var editor = sp.edit()
            editor.putString("un",username)
            editor.commit()
        }
    }
}