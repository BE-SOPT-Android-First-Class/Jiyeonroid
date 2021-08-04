package org.sopt.androidseminar

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.sopt.androidseminar.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private val tag = "SignUpActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        signUpButtonClickEvent()
    }

    private fun signUpButtonClickEvent() {
        binding.btnSignUp.setOnClickListener {
            val userName = binding.etName.text
            val userGithubId = binding.etGithubId.text
            val userPwd = binding.etSignupPwd.text

            if (isEmptyBlank()) {
                Toast.makeText(this, "빈 칸이 있는지 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SignUpActivity::class.java)
//
//                intent.putExtra("githubId", binding.etGithubId.text.toString())
//                intent.putExtra("pwd", binding.etSignupPwd.text.toString())
//                intent.putExtra("name", binding.etName.text.toString())
//                setResult(Activity.RESULT_OK, intent)

                val bundle = Bundle();
                bundle.putString("userName", userName.toString())
                bundle.putString("userPwd", userPwd.toString())
                bundle.putString("userGithubId", userGithubId.toString())
                intent.putExtras(bundle)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }

    private fun isEmptyBlank(): Boolean {
        return binding.etGithubId.text.isNullOrBlank() || binding.etSignupPwd.text.isNullOrBlank() || binding.etName.text.isNullOrBlank()
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "onRestart")
    }
}