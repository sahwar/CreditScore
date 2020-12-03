package com.dvdb.creditscore.domain.usecase.base

interface UseCase<out T> {
    suspend fun execute(): T
}