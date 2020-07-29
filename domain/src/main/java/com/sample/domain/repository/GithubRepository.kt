package com.sample.domain.repository

import androidx.paging.PagingData
import com.sample.domain.model.Repository
import kotlinx.coroutines.flow.Flow

interface GithubRepository {

    fun getSearchResult(query: String): Flow<PagingData<Repository>>

}