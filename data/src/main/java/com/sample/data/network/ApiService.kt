package com.sample.data.network

import com.sample.data.model.GithubRepositoryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search/repositories?sort=stars")
    suspend fun searchRepository(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") itemsPerPage: Int
    ): GithubRepositoryResponse


    companion object {
        const val IN_QUALIFIER = "in:name,description"
    }
}