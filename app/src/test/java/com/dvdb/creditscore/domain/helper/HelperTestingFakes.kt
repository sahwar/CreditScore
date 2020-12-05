package com.dvdb.creditscore.domain.helper

import com.dvdb.creditscore.api.model.response.DTOResponseOverview
import com.dvdb.creditscore.api.repository.RepositoryOverview
import com.dvdb.creditscore.presentation.util.HelperResourceResolver

class FakeOverviewRepository(
    private val response: DTOResponseOverview
) : RepositoryOverview {
    override suspend fun getOverview(): DTOResponseOverview = response
}

class FakeHelperResourceResolver(
    private val getStringValue: String? = null,
    private val getColor: Int? = null,
    private val getDimension: Float? = null,
    private val getDimensionPixelSize: Int? = null,
    private val getResourceIdFromAttribute: Int? = null
) : HelperResourceResolver {

    override fun getString(stringRes: Int, vararg formatArg: Any): String? = getStringValue

    override fun getColor(colorRes: Int): Int? = getColor

    override fun getDimension(dimenRes: Int): Float? = getDimension

    override fun getDimensionPixelSize(dimenRes: Int): Int? = getDimensionPixelSize

    override fun getResourceIdFromAttribute(attrRes: Int): Int? = getResourceIdFromAttribute
}