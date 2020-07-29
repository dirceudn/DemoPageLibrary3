package com.sample.domain

interface UseCase<T, Params> {
    suspend fun execute(params: Params): T
}