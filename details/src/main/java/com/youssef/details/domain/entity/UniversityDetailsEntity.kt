package com.youssef.details.domain.entity

data class UniversityDetailsEntity(
    val alphaTwoCode: String,
    val name: String,
    val country: String,
    val domains: List<String>,
    val webPages: List<String>,
    val stateProvince: String
) {

    fun getDomainsString(): String {
        var domainsText = ""
        domains.forEach { domainsText += "$it \n" }
        return domainsText
    }

    fun getWebPagesString(): String {
        var webPagesText = ""
        webPages.forEach { webPagesText += "$it \n" }
        return webPagesText
    }
}