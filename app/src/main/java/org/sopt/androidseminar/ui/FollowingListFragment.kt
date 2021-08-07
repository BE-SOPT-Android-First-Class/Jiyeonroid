package org.sopt.androidseminar.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sopt.androidseminar.data.FollowingUserInfo
import org.sopt.androidseminar.databinding.FragmentFollowingListBinding

class FollowingListFragment : Fragment() {

//    private var _binding: FragmentFollowingListBinding?= null
//    private val binding get() = _binding ?: error("View 를 참조하기 위해 binding 이 초기화되지 않았습니다")

    private lateinit var binding: FragmentFollowingListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val followingListAdapter = FollowingListAdapter()

        binding.userList.adapter = followingListAdapter

        followingListAdapter.userList.addAll(
            listOf<FollowingUserInfo>(
                FollowingUserInfo(
                    userImage = "jiyeon",
                    userName = "jiyeon"
                ),
                FollowingUserInfo(
                    userImage = "jiyeon1",
                    userName = "jiyeon1"
                ),
                FollowingUserInfo(
                    userImage = "jiyeon2",
                    userName = "jiyeon2"
                ),
                FollowingUserInfo(
                    userImage = "jiyeon3",
                    userName = "jiyeon3"
                )
            )
        )
        followingListAdapter.notifyDataSetChanged()
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