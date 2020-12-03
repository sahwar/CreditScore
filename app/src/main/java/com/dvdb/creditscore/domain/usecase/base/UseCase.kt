package com.dvdb.creditscore.domain.usecase.base

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class UseCase<out T> {
    suspend fun execute(): T = withContext(Dispatchers.IO) {
        doWork()
    }

    protected abstract suspend fun doWork(): T
}