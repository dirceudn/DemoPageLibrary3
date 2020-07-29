package com.sample.demolibpage3.di

import com.sample.data.repository.GithubRepositoryImpl
import com.sample.domain.model.GitHubRepository
import org.koin.dsl.module

val appModule = module {
    single { GithubRepositoryImpl(get()) as GitHubRepository }

}