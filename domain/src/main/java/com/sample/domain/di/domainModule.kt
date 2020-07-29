package com.sample.domain.di

import com.sample.domain.usecase.GetRepositoriesUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetRepositoriesUseCase(gitHubRepository = get()) }
}