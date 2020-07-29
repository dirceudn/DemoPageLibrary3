package com.sample.domain.model

data class GitHubRepository(
    val total: Int = 0,
    val items: List<Repository> = emptyList()
)