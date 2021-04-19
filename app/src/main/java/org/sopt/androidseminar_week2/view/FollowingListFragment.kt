package org.sopt.androidseminar_week2.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.androidseminar_week2.data.FollowingUserInfo
import org.sopt.androidseminar_week2.databinding.FragmentFollowingListBinding

class FollowingListFragment : Fragment() {
// 원래는 Fragment() 를 상속해야 하지만
// LifecycleLoggingFragment 를 이용해 세미나 생명주기 부분 출력으로 따로 상속

//    private var _binding : FragmentFollowingListBinding? = null
//    private val binding get()
//        = _binding?: error("View 를 참조하기 위해 binding 이 초기화되지 않았습니다")

    private lateinit var binding : FragmentFollowingListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val followingListAdapter =
            FollowingListAdapter()

        binding.userList.adapter = followingListAdapter

        followingListAdapter.setUserList(
            listOf(
                FollowingUserInfo(
                    userImage = "jiyeon",
                    userName = "jiyeon"
                ),
                FollowingUserInfo(
                    userImage = "seojin",
                    userName = "seojin"
                ),
                FollowingUserInfo(
                    userImage = "hyunwoo",
                    userName = "hyunwoo"
                ),
                FollowingUserInfo(
                    userImage = "wonjoong",
                    userName = "wonjoong"
                )
            )
        )
        followingListAdapter.notifyDataSetChanged()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowingListBinding.inflate(inflater, container, false)
        return binding.root
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}