package com.youssef.list.domain.interactor


import com.youssef.core.domain.entity.Outcome
import com.youssef.core.domain.interactor.AsyncUseCase
import com.youssef.list.domain.entity.UniversityEntity
import com.youssef.list.domain.repository.UniversityListRepository
import javax.inject.Inject

class GetUniversityListUseCase @Inject constructor(private val universityListRepository: UniversityListRepository) :
    AsyncUseCase<String, List<UniversityEntity>>() {

    override suspend fun run(input: String): Outcome<List<UniversityEntity>> {
        return universityListRepository.getUniversityList(input)
    }
}