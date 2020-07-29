package com.sample.demolibpage3.di

import com.sample.data.repository.GithubRepositoryImpl
import com.sample.domain.repository.GithubRepository
import org.koin.dsl.module

val appModule = module {
    single { GithubRepositoryImpl(get()) as GithubRepository }
}
