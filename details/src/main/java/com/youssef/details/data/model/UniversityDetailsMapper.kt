package com.youssef.details.data.model

import com.youssef.core.data.database.model.UniversitiesDto
import com.youssef.details.domain.entity.UniversityDetailsEntity


fun UniversitiesDto.toEntity() = UniversityDetailsEntity(
    alphaTwoCode = alphaTwoCode,
    name = name,
    country = country,
    domains = domains,
    webPages = webPages,
    stateProvince = stateProvince
)