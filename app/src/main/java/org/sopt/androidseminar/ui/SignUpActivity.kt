package org.sopt.androidseminar.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import org.sopt.androidseminar.api.ServiceCreator
import org.sopt.androidseminar.data.request.RequestLoginData
import org.sopt.androidseminar.data.request.RequestSignUpData
import org.sopt.androidseminar.data.response.ResponseLoginData
import org.sopt.androidseminar.data.response.ResponseSignUpData
import org.sopt.androidseminar.databinding.ActivitySignUpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private val tag = "SignUpActivity"

    private val signUpActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        Log.d("로그", "Came from userInfo Activity")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        signUpButtonClickEvent()
    }

    private fun signUpRequest() {
        val requestSignUpData: RequestSignUpData = RequestSignUpData(
            name = binding.etSignUpName.toString(),
            email = binding.etSignUpGithubId.toString(),
            password = binding.etSignUpPwd.toString()
        )

        val call: Call<ResponseSignUpData> = ServiceCreator.soptService
            .postSignUp(requestSignUpData)

        call.enqueue(object : Callback<ResponseSignUpData> {
            override fun onResponse(
                call: Call<ResponseSignUpData>,
                response: Response<ResponseSignUpData>
            ) {
                if (response.isSuccessful) {
                    val intent = Intent(this@SignUpActivity, MainActivity::class.java)
                    signUpActivityLauncher.launch(intent)

                    Log.d("로그", "${response}, ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ResponseSignUpData>, t: Throwable) {
                Log.d("NetworkTest", "error:$t")
            }
        })
    }

    private fun signUpButtonClickEvent() {
        binding.btnSignUp.setOnClickListener {
            if (isEmptyBlank()) {
                Toast.makeText(this, "빈 칸이 있는지 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
//                val intent = Intent(this, SignUpActivity::class.java)
//
//                intent.putExtra("githubId", binding.etGithubId.text.toString())
//                intent.putExtra("pwd", binding.etSignupPwd.text.toString())
//                intent.putExtra("name", binding.etName.text.toString())
//                setResult(Activity.RESULT_OK, intent)
//                finish()

//                val bundle = Bundle();
//                bundle.putString("userName", userName.toString())
//                bundle.putString("userPwd", userPwd.toString())
//                bundle.putString("userGithubId", userGithubId.toString())
//                intent.putExtras(bundle)
//                setResult(Activity.RESULT_OK, intent)
//                finish()

                signUpRequest()
            }
        }
    }

    private fun isEmptyBlank(): Boolean {
        return binding.etSignUpGithubId.text.isNullOrBlank() || binding.etSignUpPwd.text.isNullOrBlank() || binding.etSignUpName.text.isNullOrBlank()
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