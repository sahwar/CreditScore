package com.dvdb.creditscore.domain.model.usecase.base

interface UseCase<out T> {
    suspend fun execute(): T
}