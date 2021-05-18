package org.sopt.week4.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import org.sopt.week4.api.ServiceCreator
import org.sopt.week4.data.RepositoryListInfo
import org.sopt.week4.databinding.ActivityHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val logTag = "log"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inputRepositoryListData()
        moreButtonOnClickListener()
    }

    private fun inputRepositoryListData() {
        val call: Call<List<RepositoryListInfo>> =
            ServiceCreator.githubService.getRepositoryListInfo()
        call.enqueue(object : Callback<List<RepositoryListInfo>> {
            override fun onResponse(
                call: Call<List<RepositoryListInfo>>,
                response: Response<List<RepositoryListInfo>>
            ) {
                response.body()?.let {
                    setRepositoryView(it)
                }
            }

            override fun onFailure(call: Call<List<RepositoryListInfo>>, t: Throwable) {
                Log.e(logTag, t.toString())
            }
        })
    }

    private fun setRepositoryView(repoList: List<RepositoryListInfo>) {
        val repositoryListAdapter = RepositoryListAdapter()
        val repositoryListView = binding.rvRepositoryList
        repositoryListAdapter.setRepositoryList(repoList)
        repositoryListAdapter.notifyDataSetChanged()
        with(repositoryListView) {
            adapter = repositoryListAdapter
        }
    }

    private fun moreButtonOnClickListener() {
        binding.btnMore.setOnClickListener {
            val intent = Intent(this@HomeActivity, UserInfoActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(logTag, "HomeActivity - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(logTag, "HomeActivity - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(logTag, "HomeActivity - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(logTag, "HomeActivity - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(logTag, "HomeActivity - onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(logTag, "HomeActivity - onRestart")
    }
}