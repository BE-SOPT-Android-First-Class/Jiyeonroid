package org.sopt.week4.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.week4.api.ServiceCreator
import org.sopt.week4.data.FollowingUserInfo
import org.sopt.week4.databinding.FragmentFollowingListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowingListFragment : Fragment() {
    private lateinit var binding: FragmentFollowingListBinding
    private val logTag = "log"

    private fun setFollowingListView(followerList: List<FollowingUserInfo>) {
        val followingListAdapter = FollowingListAdapter()
        val followingListView = binding.userList

        followingListView.adapter = followingListAdapter
        followingListAdapter.setUserList(followerList)
    }

    private fun setFollowingList() {
        val call: Call<List<FollowingUserInfo>> =
            ServiceCreator.githubService.getFollowingUserInfo()
        call.enqueue(object : Callback<List<FollowingUserInfo>> {
            override fun onResponse(
                call: Call<List<FollowingUserInfo>>,
                response: Response<List<FollowingUserInfo>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        setFollowingListView(it)
                    }
                } else {
                    Log.e(logTag, "fail - set following list")
                }
            }

            override fun onFailure(call: Call<List<FollowingUserInfo>>, t: Throwable) {
                Log.e(logTag, t.toString())
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowingListBinding.inflate(inflater, container, false)
        setFollowingList()

        return binding.root
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}