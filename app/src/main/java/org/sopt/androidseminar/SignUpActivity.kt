package org.sopt.androidseminar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import org.sopt.androidseminar.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignUpBinding
    private val logTag = "logTag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        singUpButtonClickEvent()
    }

    override fun onStart() {
        super.onStart()
        Log.d(logTag, "SignUpActivity - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(logTag, "SignUpActivity - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(logTag, "SignUpActivity - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(logTag, "SignUpActivity - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(logTag, "SignUpActivity - onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(logTag, "SignUpActivity - onRestart")
    }

    private fun singUpButtonClickEvent() {
        binding.btnSignUp.setOnClickListener {
            val userName = binding.etName.text
            val usergithubId = binding.etGithubId.text
            val userPwd = binding.etSignupPwd.text
            if (userName.isNullOrBlank() || usergithubId.isNullOrBlank() || userPwd.isNullOrBlank()) {
                Toast.makeText(this@SignUpActivity, "빈칸이 있는지 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@SignUpActivity, HomeActivity::class.java)
                val bundle = Bundle();
                bundle.putString("userName", userName.toString())
                bundle.putString("userPwd", userPwd.toString())
                bundle.putString("usergithubId", usergithubId.toString())
                intent.putExtras(bundle)
                startActivity(intent)

            }
        }
    }
}