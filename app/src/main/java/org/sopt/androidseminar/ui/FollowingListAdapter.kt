package org.sopt.androidseminar.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.androidseminar.data.FollowingUserInfo
import org.sopt.androidseminar.databinding.ItemFollowUserBinding

class FollowingListAdapter : RecyclerView.Adapter<FollowingListAdapter.FollowingListViewHolder>() {

    private val userList = mutableListOf<FollowingUserInfo>()

    fun setUserList(newList: List<FollowingUserInfo>) {
        userList.addAll(newList)
    }

    class FollowingListViewHolder(
        private val binding: ItemFollowUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(followingUserInfo: FollowingUserInfo, context: Context) {
            binding.followUserName.text = followingUserInfo.userName
            Glide.with(context).load(followingUserInfo.userImgSrc).into(binding.followUserImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingListViewHolder {
        val binding = ItemFollowUserBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return FollowingListViewHolder(binding)
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: FollowingListViewHolder, position: Int) {
        holder.onBind(userList[position], holder.itemView.context)
    }
}