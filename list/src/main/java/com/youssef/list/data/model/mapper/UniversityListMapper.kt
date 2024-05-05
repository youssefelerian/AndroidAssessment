package com.youssef.list.data.model.mapper

import com.youssef.core.data.database.model.UniversitiesDto
import com.youssef.list.data.model.UniversityResponse
import com.youssef.list.domain.entity.UniversityEntity


fun UniversityResponse.toEntity() = UniversityEntity(
    alphaTwoCode = alphaTwoCode.orEmpty(),
    name = name.orEmpty(),
    country = country.orEmpty(),
    domains = domains.orEmpty(),
    webPages = webPages.orEmpty(),
    stateProvince = stateProvince.orEmpty()
)

fun UniversitiesDto.toEntity() = UniversityEntity(
    alphaTwoCode = alphaTwoCode,
    name = name,
    country = country,
    domains = domains,
    webPages = webPages,
    stateProvince = stateProvince
)

fun UniversityEntity.toDto(searchName: String) = UniversitiesDto(
    alphaTwoCode = alphaTwoCode,
    name = name,
    country = country,
    domains = domains,
    webPages = webPages,
    stateProvince = stateProvince,
    searchName = searchName
)