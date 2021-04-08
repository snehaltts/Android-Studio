package com.ltts.fragmentact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class PassingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passing)
        //We will make this activity as a launcher

        supportFragmentManager.beginTransaction().add(R.id.activity_passing,BlueFragment()).commit()
    }
}