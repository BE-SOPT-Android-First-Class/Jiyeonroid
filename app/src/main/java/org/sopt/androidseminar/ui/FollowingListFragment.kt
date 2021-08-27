package org.sopt.androidseminar.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sopt.androidseminar.api.ServiceCreator
import org.sopt.androidseminar.data.FollowingListInfo
import org.sopt.androidseminar.databinding.FragmentFollowingListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowingListFragment : Fragment() {

//    private var _binding: FragmentFollowingListBinding?= null
//    private val binding get() = _binding ?: error("View 를 참조하기 위해 binding 이 초기화되지 않았습니다")

    lateinit var binding: FragmentFollowingListBinding

    private fun setFollowingList() {
        val followingListAdapter = FollowingListAdapter()
        binding.rvFollowingList.adapter = followingListAdapter

//        followingListAdapter.setUserList(
//            listOf(
//                FollowingListInfo(
//                    userName = "todayiswindy"
//                ),
//                FollowingListInfo(
//                    userName = "SeojinSeojin"
//                ),
//                FollowingListInfo(
//                    userName = "12hyunwoo"
//                ),
//                FollowingListInfo(
//                    userName = "WonJoongLee"
//                )
//            )
//        )
//        followingListAdapter.notifyDataSetChanged()
    }

    private fun requestFollower() {
        val call: Call<List<FollowingListInfo>> =
            ServiceCreator.githubService.getFollowerInfo("todayiswindy")

        call.enqueue(object : Callback<List<FollowingListInfo>> {
            override fun onResponse(
                call: Call<List<FollowingListInfo>>,
                response: Response<List<FollowingListInfo>>
            ) {
                if (response.isSuccessful) {
                    setFollowingList()
                }
            }

            override fun onFailure(call: Call<List<FollowingListInfo>>, t: Throwable) {
                Log.d("로", "error:$t")
            }
        })
    }

    fun activityLogger(activityName: String, methodName: String) {
        Log.d("log", "$activityName : $methodName called")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityLogger(this.javaClass.name, "onViewCreated")
        requestFollower()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        _binding = FragmentFollowingListBinding.inflate(inflater, container, false)
        binding = FragmentFollowingListBinding.inflate(inflater, container, false)

        return binding.root
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}