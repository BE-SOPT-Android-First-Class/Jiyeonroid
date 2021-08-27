package org.sopt.androidseminar.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import org.sopt.androidseminar.api.ServiceCreator
import org.sopt.androidseminar.data.RepoListInfo
import org.sopt.androidseminar.databinding.ActivityHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val tag = "HomeActivity"
//    private val resultCode = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        moreButtonClickEvent()
        requestRepoList()
    }

    private val followingListActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        Log.d("로그", "Came from userInfo Activity")
//        if (resultCode == Activity.RESULT_OK) {}
    }

    private fun moreButtonClickEvent() {
        binding.btnHomeMore.setOnClickListener {
            val intent = Intent(this, UserInfoActivity::class.java)
//          startActivity(intent)
            followingListActivityLauncher.launch(intent)
        }
    }

    private fun setRepoList() {
        val repoListAdapter = RepoListAdapter()
        binding.rvHomeRepoList.adapter = repoListAdapter

//        repoListAdapter.setRepositoryList(
//            listOf(
//                RepoListInfo("레포이름", "레포설명", "레포언어"),
//                RepoListInfo("레포이름", "레포설명", "레포언어"),
//                RepoListInfo("레포이름", "레포설명", "레포언어"),
//                RepoListInfo("레포이름", "레포설명", "레포언어"),
//                RepoListInfo(
//                    "이ㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣ름",
//                    "설ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ명",
//                    "언ㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴ어"
//                )
//            )
//        )
//
//        for (i in 1..10) {
//            repoListAdapter.setRepositoryList(
//                listOf(
//                    RepoListInfo(
//                        "레포이름".plus(i),
//                        "레포설명".plus(i),
//                        "레포언어".plus(i)
//                    )
//                )
//            )
//        }
//
        repoListAdapter.notifyDataSetChanged()
    }

    private fun requestRepoList() {
        val call: Call<List<RepoListInfo>> = ServiceCreator.githubService
            .getRepositories("todayiswindy")

        call.enqueue(object : Callback<List<RepoListInfo>> {
            override fun onResponse(
                call: Call<List<RepoListInfo>>,
                response: Response<List<RepoListInfo>>
            ) {
                if (response.isSuccessful) {
                    setRepoList()
                }
            }

            override fun onFailure(call: Call<List<RepoListInfo>>, t: Throwable) {
                Log.d("log", "error:$t")
            }
        })
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