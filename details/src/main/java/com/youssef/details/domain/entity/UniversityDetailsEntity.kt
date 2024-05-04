package com.youssef.details.domain.entity

data class UniversityDetailsEntity(
    val alphaTwoCode: String,
    val name: String,
    val country: String,
    val domains: List<String>,
    val webPages: List<String>,
    val stateProvince: String
)