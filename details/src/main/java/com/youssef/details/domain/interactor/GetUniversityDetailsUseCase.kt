package com.youssef.details.domain.interactor


import com.youssef.core.domain.entity.Outcome
import com.youssef.core.domain.interactor.AsyncUseCase
import com.youssef.details.domain.repository.UniversityDetailsRepository
import com.youssef.details.domain.entity.UniversityDetailsEntity
import javax.inject.Inject

class GetUniversityDetailsUseCase @Inject constructor(private val universityDetailsRepository: UniversityDetailsRepository) :
    AsyncUseCase<String, UniversityDetailsEntity>() {

    override suspend fun run(input: String): Outcome<UniversityDetailsEntity> {
        return universityDetailsRepository.getUniversityDetails(input)
    }
}