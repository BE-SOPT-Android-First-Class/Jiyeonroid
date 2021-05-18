package org.sopt.week4.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import org.sopt.week4.databinding.ActivityMainBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val logTag = "logTag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginButtonOnClickEvent()
        signUpButtonOnClickListener()
    }

    override fun onStart() {
        super.onStart()
        Log.d(logTag, "SignInActivity - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(logTag, "SignInActivity - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(logTag, "SignInActivity - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(logTag, "SignInActivity - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(logTag, "SignInActivity - onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(logTag, "SignInActivity - onRestart")
    }

    private fun loginButtonOnClickEvent() {
        binding.btnLogin.setOnClickListener {
            val userId = binding.etId.text
            val userPwd = binding.etPwd.text
            if (userId.isNullOrBlank() || userPwd.isNullOrBlank()) {
                Toast.makeText(this@SignInActivity, "아이디 / 비밀번호를 확인해주세요!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@SignInActivity, "로그인 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@SignInActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun signUpButtonOnClickListener() {
        binding.btnSignIn.setOnClickListener {
            val intent = Intent(this@SignInActivity, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}