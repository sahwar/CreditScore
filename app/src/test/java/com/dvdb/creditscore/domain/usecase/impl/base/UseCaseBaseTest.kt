package com.dvdb.creditscore.domain.usecase.impl.base

import kotlinx.coroutines.runBlocking
import org.junit.Test

class UseCaseBaseTest {

    @Test
    fun execute_doWorkInvoked() = runBlocking {
        var hasPerformedWork = false

        object : UseCaseBase<Unit>() {
            override suspend fun doWork() {
                hasPerformedWork = true
            }
        }.execute()

        if (!hasPerformedWork) {
            error("Method doWork() was not called")
        }
    }
}