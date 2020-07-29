package com.sample.data.datasource

import androidx.paging.PagingSource
import com.sample.data.model.GithubRepository
import com.sample.data.network.ApiService
import com.sample.data.network.ApiService.Companion.IN_QUALIFIER
import com.sample.domain.model.Repository
import retrofit2.HttpException
import java.io.IOException

class GithubPagingSource(private val apiService: ApiService, private val query: String) :
    PagingSource<Int, Repository>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Repository> {
        val position = params.key ?: GITHUB_STARTING_PAGE_INDEX
        val apiQuery = query + IN_QUALIFIER
        return try {
            val response = apiService.searchRepository(apiQuery, position, params.loadSize)
            val repos = response.items.toRepository()
            LoadResult.Page(
                data = repos,
                prevKey = if (position == GITHUB_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (repos.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    companion object {
        private const val GITHUB_STARTING_PAGE_INDEX = 1

    }

}

private fun List<GithubRepository>.toRepository(): List<Repository> {
    return this.map {
        Repository(
            id = it.id,
            description = it.description,
            forks = it.forks,
            fullName = it.fullName,
            language = it.language,
            name = it.name,
            stars = it.stars,
            url = it.url
        )
    } .filter { it.id != null  }
}
