package com.erikriosetiawan.virtualin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class VerificationActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etVerificationOne: EditText
    private lateinit var etVerificationTwo: EditText
    private lateinit var etVerificationThree: EditText
    private lateinit var etVerificationFour: EditText
    private lateinit var tvResend: TextView
    private lateinit var btnContinue: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

        initViews()
    }

    private fun initViews() {
        etVerificationOne = findViewById(R.id.et_verify_one)
        etVerificationTwo = findViewById(R.id.et_verify_two)
        etVerificationThree = findViewById(R.id.et_verify_three)
        etVerificationFour = findViewById(R.id.et_verify_four)
        tvResend = findViewById(R.id.tv_resend)
        btnContinue = findViewById(R.id.btn_continue)
        btnContinue.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_continue -> {
                Toast.makeText(this, "Button continue clicked!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun onResend(view: View) {
        Toast.makeText(this, "Resend clicked!", Toast.LENGTH_SHORT).show()
    }
}
