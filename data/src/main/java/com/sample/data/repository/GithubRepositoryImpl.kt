package com.sample.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.sample.data.datasource.GithubPagingSource
import com.sample.data.network.ApiService
import com.sample.domain.model.Repository
import com.sample.domain.repository.GithubRepository
import kotlinx.coroutines.flow.Flow

class GithubRepositoryImpl(private val apiService: ApiService) : GithubRepository {

    override fun getSearchResult(query: String): Flow<PagingData<Repository>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { GithubPagingSource(apiService, query) }
        ).flow
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 50
    }
}