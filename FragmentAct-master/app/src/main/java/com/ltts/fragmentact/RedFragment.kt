package com.ltts.fragmentact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.red_frag.view.*

class RedFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var v =inflater.inflate(R.layout.red_frag, container, false)
        var data = arguments!!.getString("key")
        v.textViewRed.setText(data)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}