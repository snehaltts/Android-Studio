package com.ltts.fragmentact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.blue_frag.view.*

class BlueFragment :Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var v = inflater.inflate(R.layout.blue_frag,container,false)
        //no isntance stare hence false
        v.buttonpassdata.setOnClickListener {
            var redFrag = RedFragment()
            var myName ="Kay"
            var b = Bundle()
            b.putString("key", myName)
            //give this vale to fragment

            redFrag.arguments =b
            fragmentManager!!.beginTransaction().replace(R.id.activity_passing,redFrag).commit()
        }

            return v
    }
}