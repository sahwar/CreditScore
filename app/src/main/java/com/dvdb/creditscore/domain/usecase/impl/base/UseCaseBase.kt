package com.dvdb.creditscore.domain.usecase.impl.base

import com.dvdb.creditscore.domain.usecase.UseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class UseCaseBase<out T> : UseCase<T> {
    override suspend fun execute(): T = withContext(Dispatchers.IO) {
        doWork()
    }

    protected abstract suspend fun doWork(): T
}