package com.dvdb.creditscore.domain.usecase

interface UseCase<out T> {
    suspend fun execute(): T
}

interface UseCaseFactory<out T> {
    fun create(): UseCase<T>
}