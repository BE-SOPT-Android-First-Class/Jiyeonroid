package org.sopt.androidseminar.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidseminar.data.FollowingUserInfo
import org.sopt.androidseminar.databinding.ItemFollowUserBinding

class FollowingListAdapter : RecyclerView.Adapter<FollowingListAdapter.FollowingListViewHolder>() {

    private val userList = mutableListOf<FollowingUserInfo>()

    class FollowingListViewHolder(
        private val binding: ItemFollowUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(followingUserInfo: FollowingUserInfo, context: Context) {
            binding.tvFollowUserName.text = followingUserInfo.userName
        }
    }

    fun setUserList(newList : List<FollowingUserInfo>) {
        userList.addAll(newList)
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
//////////////
    }
}