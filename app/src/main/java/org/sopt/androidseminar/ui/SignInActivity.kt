package org.sopt.androidseminar.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import org.sopt.androidseminar.api.ServiceCreator
import org.sopt.androidseminar.data.request.RequestLoginData
import org.sopt.androidseminar.data.response.ResponseLoginData
import org.sopt.androidseminar.databinding.ActivitySignInBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private val tag = "SignInActivity"

    private val loginActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        Log.d("로그", "Came from userInfo Activity")
    }

    private val signUpActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        Log.d("로그", "Came from userInfo Activity")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginButtonClickEvent()
        signUpButtonClickEvent()
    }

    private fun requestLogin()
    {
        val requestLoginData = RequestLoginData(
            email = binding.etSignInId.text.toString(),
            password = binding.etSignInPwd.text.toString()
        )

        val call: Call<ResponseLoginData> = ServiceCreator.soptService
            .postLogin(requestLoginData)

        call.enqueue(object : Callback<ResponseLoginData> {
            override fun onResponse(
                call: Call<ResponseLoginData>,
                response: Response<ResponseLoginData>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data
                    Toast.makeText(this@SignInActivity, data?.user_nickName, Toast.LENGTH_SHORT)
                        .show()
                    Log.d("success", "success")
                    startHomeActivity()
                }
            }

            override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                Log.d("NetworkTest", "error:$t")
            }
        })
    }

    private fun startHomeActivity() {
        Log.d("error", "error")
        startActivity(
            Intent(this, MainActivity::class.java).apply {
                putExtra("id", "idddd")
            }
        )
    }

    private fun loginButtonClickEvent() {
        binding.btnSignInLogin.setOnClickListener {
            if (isEmptyBlank()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()
//                val intent = Intent(this, MainActivity::class.java)
//                loginActivityLauncher.launch(intent)
                requestLogin()
            }
        }
    }

    private fun signUpButtonClickEvent() {
        binding.btnSignInSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            signUpActivityLauncher.launch(intent)
        }
    }

    private fun isEmptyBlank(): Boolean {
        return binding.etSignInId.text.isNullOrBlank() || binding.etSignInPwd.text.isNullOrBlank()
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