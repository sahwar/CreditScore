package com.dvdb.creditscore.shared.extension

/**
 * This extension property can be used to make a 'when' statement
 * exhaustive, such that all cases must be handled at compile time.
 */
val <T> T.exhaustive: T
    get() = this