package com.youssef.list.domain.entity

data class UniversityEntity(
    val alphaTwoCode: String,
    val name: String,
    val country: String,
    val domains: List<String>,
    val webPages: List<String>,
    val stateProvince: String
)