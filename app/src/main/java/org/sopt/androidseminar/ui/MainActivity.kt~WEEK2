package org.sopt.androidseminar.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.sopt.androidseminar.data.RepoListInfo
import org.sopt.androidseminar.databinding.ActivityHomeBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val tag = "HomeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        moreButtonClickEvent()
        initRecyclerView()
    }

    private fun moreButtonClickEvent() {
        binding.btnHomeMore.setOnClickListener {
            val intent = Intent(this, FollowingListFragment::class.java)
            startActivity(intent)
        }
    }

    private fun initRecyclerView() {
        val repositoryListAdapter = RepoListAdapter()
        binding.rvHomeRepoList.adapter = repositoryListAdapter
//        repoListAdapter.setRepositoryList(
//            listOf(
//                RepoListInfo("레포이름", "레포설명", "레포언어"),
//                RepoListInfo("레포이름", "레포설명", "레포언어"),
//                RepoListInfo("레포이름", "레포설명", "레포언어"),
//                RepoListInfo("레포이름", "레포설명", "레포언어"),
//                RepoListInfo(
//                    "레포이름름름름름름름",
//                    "레포설명명명명명명명명명명명명명명명명명명명명명명명명명명명명명명명명명명명명명",
//                    "레포언어언어언어언어"
//                )
//            )
//        )
        repositoryListAdapter.setRepositoryList(
            listOf(RepoListInfo(
                repoName = "이ㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣ름",
                repoDesc = "설ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ명",
                repoLang = "언ㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴ어"))
        )
        for (i in 1 .. 10) {
            repositoryListAdapter.setRepositoryList(
                listOf(RepoListInfo(
                    "Repository Name".plus(i),
                    "Repository Description".plus(i),
                    "Repository Language".plus(i))))
        }
        repositoryListAdapter.notifyDataSetChanged()
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