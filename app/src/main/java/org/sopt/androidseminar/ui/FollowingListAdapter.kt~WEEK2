package org.sopt.androidseminar.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.androidseminar.data.FollowingListInfo
import org.sopt.androidseminar.databinding.ItemFollowUserBinding

class FollowingListAdapter : RecyclerView.Adapter<FollowingListAdapter.FollowingListViewHolder>() {

    private val userList = mutableListOf<FollowingListInfo>()

    class FollowingListViewHolder(
        private val binding: ItemFollowUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(followingListInfo: FollowingListInfo, context: Context) {
            binding.tvFollowUserName.text = followingListInfo.userName
            Glide.with(context).load(followingListInfo.userImgSrc).into(binding.ivFollowUserImage)
        }
    }

    fun setUserList(newList : List<FollowingListInfo>) {
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
    }
}