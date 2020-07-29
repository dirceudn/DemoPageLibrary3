package com.sample.domain.usecase

import androidx.paging.PagingData
import com.sample.domain.UseCase
import com.sample.domain.model.Repository
import com.sample.domain.repository.GithubRepository
import kotlinx.coroutines.flow.Flow

class GetRepositoriesUseCase(private val gitHubRepository: GithubRepository) :
    UseCase<Flow<PagingData<Repository>>, GetRepositoriesUseCase.Params> {
    override suspend fun execute(params: Params): Flow<PagingData<Repository>> {
        return gitHubRepository.getSearchResult(params.query)
    }

    data class Params(val query: String)

}