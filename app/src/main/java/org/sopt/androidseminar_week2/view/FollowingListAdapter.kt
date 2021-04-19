package org.sopt.androidseminar_week2.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidseminar_week2.data.FollowingUserInfo
import org.sopt.androidseminar_week2.databinding.ItemFollowingUserBinding

class FollowingListAdapter : RecyclerView.Adapter<FollowingListAdapter.FollowingUserViewHolder> (){

    private val userList = mutableListOf<FollowingUserInfo>()

    fun setUserList(newList : List<FollowingUserInfo>) {
        userList.addAll(newList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingUserViewHolder {
        val binding = ItemFollowingUserBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)

        return FollowingUserViewHolder(binding)
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: FollowingUserViewHolder, position: Int) {
        holder.onBind(userList[position], holder.itemView.getContext())
    }

    class FollowingUserViewHolder (
        private val binding : ItemFollowingUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(followingUserInfo: FollowingUserInfo, context: Context) {
            binding.followUserName.text = followingUserInfo.userName
        }
    }
}