package org.sopt.week4.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.week4.data.RepositoryListInfo
import org.sopt.week4.databinding.ItemRepositoryListBinding

class RepositoryListAdapter :
    RecyclerView.Adapter<RepositoryListAdapter.RepositoryListViewHolder>() {

    private val repositoryList = mutableListOf<RepositoryListInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryListViewHolder {
        val binding = ItemRepositoryListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return RepositoryListViewHolder(binding)
    }

    override fun getItemCount(): Int = repositoryList.size

    override fun onBindViewHolder(holder: RepositoryListViewHolder, position: Int) {
        holder.onBind(repositoryList[position])
    }

    fun setRepositoryList(newList: List<RepositoryListInfo>) {
        repositoryList.addAll(newList)
        notifyDataSetChanged()
    }

    class RepositoryListViewHolder(private val binding: ItemRepositoryListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(repositoryListInfo: RepositoryListInfo) {
            binding.apply {
                tvRepoName.text = repositoryListInfo.repoName
                tvRepoDesc.text = repositoryListInfo.repoDesc
                tvRepoLang.text = repositoryListInfo.repoLang
            }
        }
    }
}