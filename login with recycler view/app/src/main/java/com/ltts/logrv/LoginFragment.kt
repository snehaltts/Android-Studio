package com.ltts.logrv

import android.content.res.ColorStateList
import android.content.res.XmlResourceParser
import android.os.Bundle
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.fragment.app.Fragment
import java.util.regex.Pattern


class LoginFragment : Fragment(), View.OnClickListener {
    fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                     savedInstanceState: Bundle?): View? {
        var v = inflater.inflate(R.layout.login_layout, container, false)
        initViews()
        setListeners()
        return view
    }

    // Initiate Views
    private fun initViews() {
        fragmentManager = getActivity().getSupportFragmentManager()
        emailid = view!!.findViewById<View>(R.id.login_emailid) as EditText
        password = view!!.findViewById<View>(R.id.login_password) as EditText
        loginButton = view!!.findViewById<View>(R.id.loginBtn) as Button
        forgotPassword = view!!.findViewById<View>(R.id.forgot_password) as TextView
        signUp = view!!.findViewById<View>(R.id.createAccount) as TextView
        show_hide_password = view
                .findViewById<View>(R.id.show_hide_password) as CheckBox
        loginLayout = view!!.findViewById<View>(R.id.login_layout) as LinearLayout

        // Load ShakeAnimation
        shakeAnimation = AnimationUtils.loadAnimation(getActivity(),
                R.anim.shake)

        // Setting text selector over textviews
        val xrp: XmlResourceParser = getResources().getXml(R.drawable.text_selector)
        try {
            val csl = ColorStateList.createFromXml(getResources(),
                    xrp)
            forgotPassword!!.setTextColor(csl)
            show_hide_password!!.setTextColor(csl)
            signUp!!.setTextColor(csl)
        } catch (e: Exception) {
        }
    }

    // Set Listeners
    private fun setListeners() {
        loginButton!!.setOnClickListener(this)
        forgotPassword!!.setOnClickListener(this)
        signUp!!.setOnClickListener(this)

        // Set check listener over checkbox for showing and hiding password
        show_hide_password
                .setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { button, isChecked ->
                    // If it is checkec then show password else hide
                    // password
                    if (isChecked) {
                        show_hide_password.setText(R.string.hide_pwd) // change
                        // checkbox
                        // text
                        password!!.inputType = InputType.TYPE_CLASS_TEXT
                        password!!.transformationMethod = HideReturnsTransformationMethod
                                .getInstance() // show password
                    } else {
                        show_hide_password.setText(R.string.show_pwd) // change
                        // checkbox
                        // text
                        password!!.inputType = (InputType.TYPE_CLASS_TEXT
                                or InputType.TYPE_TEXT_VARIATION_PASSWORD)
                        password!!.transformationMethod = PasswordTransformationMethod
                                .getInstance() // hide password
                    }
                })
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.loginBtn -> checkValidation()
            R.id.forgot_password ->
                // Replace forgot password fragment with animation
                fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
                        .replace(R.id.frameContainer,
                                ForgotPassword_Fragment(),
                                Utils.ForgotPassword_Fragment).commit()
            R.id.createAccount ->
                // Replace signup frgament with animation
                fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
                        .replace(R.id.frameContainer, SignUp_Fragment(),
                                Utils.SignUp_Fragment).commit()
        }
    }

    // Check Validation before login
    private fun checkValidation() {
        // Get email id and password
        val getEmailId = emailid!!.text.toString()
        val getPassword = password!!.text.toString()

        // Check patter for email id
        val p = Pattern.compile(Utils.regEx)
        val m = p.matcher(getEmailId)

        // Check for both field is empty or not
        if (getEmailId == "" || getEmailId.length == 0 || getPassword == "" || getPassword.length == 0) {
            loginLayout!!.startAnimation(shakeAnimation)
            CustomToast().Show_Toast(getActivity(), view!!,
                    "Enter both credentials.")
        } else if (!m.find()) CustomToast().Show_Toast(getActivity(), view!!,
                "Your Email Id is Invalid.") else Toast.makeText(getActivity(), "Do Login.", Toast.LENGTH_SHORT)
                .show()
    }

    companion object {
        private var view: View? = null
        private var emailid: EditText? = null
        private var password: EditText? = null
        private var loginButton: Button? = null
        private var forgotPassword: TextView? = null
        private var signUp: TextView? = null
        private var show_hide_password: CheckBox? = null
        private var loginLayout: LinearLayout? = null
        private var shakeAnimation: Animation? = null
        private var fragmentManager: FragmentManager? = null
    }
}
