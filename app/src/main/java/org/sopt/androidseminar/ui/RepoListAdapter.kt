package org.sopt.androidseminar.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidseminar.data.RepoListInfo
import org.sopt.androidseminar.databinding.ItemRepoInfoBinding

class RepoListAdapter : RecyclerView.Adapter<RepoListAdapter.RepoListViewHolder>() {

    private val repoList = mutableListOf<RepoListInfo>()

    class RepoListViewHolder(
        private val binding: ItemRepoInfoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(repoListInfo: RepoListInfo) {
            binding.apply {
                tvRepoName.text = repoListInfo.repoName
                tvRepoDesc.text = repoListInfo.repoDesc
                tvRepoLang.text = repoListInfo.repoLang
            }
        }
    }

    fun setRepositoryList(newList:List<RepoListInfo>) {
        repoList.addAll(newList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoListViewHolder {
        val binding = ItemRepoInfoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return RepoListViewHolder(binding)
    }

    override fun getItemCount(): Int = repoList.size

    override fun onBindViewHolder(holder: RepoListViewHolder, position: Int) {
        holder.onBind(repoList[position])
    }
}