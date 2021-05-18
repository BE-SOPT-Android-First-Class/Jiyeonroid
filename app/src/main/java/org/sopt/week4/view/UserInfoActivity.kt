package org.sopt.week4.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.week4.R
import org.sopt.week4.databinding.ActivityUserInfoBinding
import org.sopt.week4.view.FollowingListFragment

class UserInfoActivity : AppCompatActivity() {  //LifecycleLoggingActivity

    private lateinit var binding: ActivityUserInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val followingListFragment = FollowingListFragment()
        val transaction = supportFragmentManager.beginTransaction()

        transaction.add(R.id.user_info_fragment, followingListFragment)
        transaction.commit()
    }
}