package com.dvdb.creditscore.domain.model.response

import com.dvdb.creditscore.domain.model.EntityOverview
import com.dvdb.creditscore.domain.model.response.base.EntityResponse

data class EntityResponseOverview(
    val overview: EntityOverview
) : EntityResponse()