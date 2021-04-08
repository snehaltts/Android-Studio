package com.ltts.fragmentact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*bluebutton.setOnClickListener {
            var bluefrag =BlueFragment()
            var myManager =supportFragmentManager
            var myTransactions = myManager.beginTransaction()
            myTransactions.replace(R.id.fragmentgreen, bluefrag)
            myTransactions.commit()
        }

        redbutton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentgreen, RedFragment()).commit()
        }*/
    }
}