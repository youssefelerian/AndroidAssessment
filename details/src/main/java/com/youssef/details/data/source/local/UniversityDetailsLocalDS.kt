package com.youssef.details.data.source.local

import com.youssef.details.domain.entity.UniversityDetailsEntity

interface UniversityDetailsLocalDS {

    suspend fun getUniversityDetails(name: String): UniversityDetailsEntity

}