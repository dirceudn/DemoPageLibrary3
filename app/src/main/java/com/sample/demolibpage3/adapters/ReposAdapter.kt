package com.sample.demolibpage3.adapters

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sample.domain.model.Repository

/**
 * Adapter for the list of repositories.
 */
class ReposAdapter : PagingDataAdapter<Repository, ViewHolder>(REPO_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return RepoViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repoItem = getItem(position)
        if (repoItem != null) {
            (holder as RepoViewHolder).bind(repoItem)
        }
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<Repository>() {
            override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean =
                    oldItem.fullName == newItem.fullName

            override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean =
                    oldItem == newItem
        }
    }
}
