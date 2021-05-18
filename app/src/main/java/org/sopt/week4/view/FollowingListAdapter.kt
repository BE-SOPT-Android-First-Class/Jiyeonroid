package org.sopt.week4.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.week4.data.FollowingUserInfo
import org.sopt.week4.databinding.ItemFollowingUserBinding

class FollowingListAdapter : RecyclerView.Adapter<FollowingListAdapter.FollowingUserViewHolder>() {

    private var userList = mutableListOf<FollowingUserInfo>()

    fun setUserList(newList: List<FollowingUserInfo>) {
        userList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingUserViewHolder {
        val binding = ItemFollowingUserBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return FollowingUserViewHolder(binding)
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: FollowingUserViewHolder, position: Int) {
        holder.onBind(userList[position])
    }

    class FollowingUserViewHolder(private val binding: ItemFollowingUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(followingListUserInfo: FollowingUserInfo) {
            binding.followUserName.text = followingListUserInfo.userName
            Glide.with(binding.followUserImage.context)
                .load(followingListUserInfo.userImgUrl)
                .into(binding.followUserImage)
        }
    }
}