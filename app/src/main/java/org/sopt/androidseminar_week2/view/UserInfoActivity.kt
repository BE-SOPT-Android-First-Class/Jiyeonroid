package org.sopt.androidseminar_week2.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.androidseminar_week2.R
import org.sopt.androidseminar_week2.databinding.ActivityUserInfoBinding

class UserInfoActivity : AppCompatActivity() {  //LifecycleLoggingActivity

    private lateinit var binding : ActivityUserInfoBinding

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