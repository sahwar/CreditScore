package com.dvdb.creditscore.domain.usecase.base

import kotlinx.coroutines.runBlocking
import org.junit.Test

class UseCaseTest {

    @Test
    fun execute_doWorkInvoked() = runBlocking {
        var hasPerformedWork = false

        object : UseCase<Unit>() {
            override suspend fun doWork() {
                hasPerformedWork = true
            }
        }.execute()

        if (!hasPerformedWork) {
            error("Method doWork() was not called")
        }
    }
}