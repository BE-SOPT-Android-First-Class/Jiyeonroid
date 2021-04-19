package org.sopt.androidseminar_week2.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.sopt.androidseminar_week2.data.RepositoryListInfo
import org.sopt.androidseminar_week2.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    private val logTag = "logTag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inputRepoData()
        moreButtonOnClickListener()
    }

    private fun inputRepoData() {
        val repositoryListAdapter = RepositoryListAdapter()
        binding.rvRepositoryList.adapter = repositoryListAdapter

        repositoryListAdapter.setRepositoryList(
                listOf(RepositoryListInfo(
                repoName = "이ㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣ름",
                repoDesc = "설ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ명",
                repoLang = "언ㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴ어"))
        )
        for (i in 1 .. 10) {
            repositoryListAdapter.setRepositoryList(
                    listOf(RepositoryListInfo(
                            "Repository Name".plus(i),
                            "Repository Description".plus(i),
                            "Repository Language".plus(i))))
        }
        repositoryListAdapter.notifyDataSetChanged()
    }

    private fun moreButtonOnClickListener () {
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