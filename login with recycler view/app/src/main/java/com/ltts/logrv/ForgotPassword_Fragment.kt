package com.ltts.logrv

import android.content.res.ColorStateList
import android.content.res.XmlResourceParser
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.regex.Pattern


class ForgotPassword_Fragment : Fragment() {
    var view: View? = null

    var emailId: EditText? = null
    var submit: TextView? = null, private  var back:TextView? = null

    fun ForgotPassword_Fragment() {}

    fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                     savedInstanceState: Bundle?): View? {
        view = inflater.inflate(R.layout.forgotpassword_layout, container,
                false)
        initViews()
        setListeners()
        return view
    }

    // Initialize the views
    open fun initViews() {
        emailId = view!!.findViewById<View>(R.id.registered_emailid) as EditText
        submit = view!!.findViewById<View>(R.id.forgot_button) as TextView
        back = view!!.findViewById<View>(R.id.backToLoginBtn) as TextView

        // Setting text selector over textviews
        val xrp: XmlResourceParser = getResources().getXml(R.drawable.text_selector)
        try {
            val csl = ColorStateList.createFromXml(getResources(),
                    xrp)
            back.setTextColor(csl)
            submit!!.setTextColor(csl)
        } catch (e: Exception) {
        }
    }

    // Set Listeners over buttons
    open fun setListeners() {
        back.setOnClickListener(this)
        submit!!.setOnClickListener(this)
    }

    fun onClick(v: View) {
        when (v.id) {
            R.id.backToLoginBtn ->
                // Replace Login Fragment on Back Presses
                MainActivity().replaceLoginFragment()
            R.id.forgot_button ->
                // Call Submit button task
                submitButtonTask()
        }
    }

    open fun submitButtonTask() {
        val getEmailId = emailId!!.text.toString()

        // Pattern for email id validation
        val p = Pattern.compile(Utils.regEx)

        // Match the pattern
        val m = p.matcher(getEmailId)

        // First check if email id is not null else show error toast
        if (getEmailId == "" || getEmailId.length == 0) CustomToast().Show_Toast(getActivity(), view!!,
                "Please enter your Email Id.") else if (!m.find()) CustomToast().Show_Toast(getActivity(), view!!,
                "Your Email Id is Invalid.") else Toast.makeText(getActivity(), "Get Forgot Password.",
                Toast.LENGTH_SHORT).show()
    }
