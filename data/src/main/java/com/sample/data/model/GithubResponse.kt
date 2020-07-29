package com.sample.data.model

import com.google.gson.annotations.SerializedName

data class GithubRepositoryResponse(
    @SerializedName("total_count") val total: Int = 0,
    @SerializedName("items") val items: List<GithubRepository> = emptyList(),
    val nextPage: Int? = null
)

data class GithubRepository(
    @field:SerializedName("id") val id: Long,
    @field:SerializedName("name") val name: String,
    @field:SerializedName("full_name") val fullName: String,
    @field:SerializedName("description") val description: String?,
    @field:SerializedName("html_url") val url: String,
    @field:SerializedName("stargazers_count") val stars: Int,
    @field:SerializedName("forks_count") val forks: Int,
    @field:SerializedName("language") val language: String?
)
