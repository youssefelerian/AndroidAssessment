package com.youssef.details.presentation.viewmodel

import com.youssef.core.presentation.uimodel.MutableStateLiveData
import com.youssef.core.presentation.uimodel.ViewState
import com.youssef.core.presentation.viewmodel.BaseViewModel
import com.youssef.details.domain.entity.UniversityDetailsEntity
import com.youssef.details.domain.interactor.GetUniversityDetailsUseCase
import javax.inject.Inject


class UniversityDetailsViewModel @Inject constructor(
    private val getUniversityDetailsUseCase: GetUniversityDetailsUseCase
) : BaseViewModel() {

    val getUniversityLiveData = MutableStateLiveData<UniversityDetailsEntity>()

    fun getUniversityDetails(name: String) {
        getUniversityLiveData.postValue(ViewState.loading())
        execute {
            getUniversityDetailsUseCase.execute(name, success = {
                getUniversityLiveData.postValue(ViewState.success(it))
            }, error = {
                getUniversityLiveData.postValue(ViewState.error(it.throwable.message ?: "", ""))
            })
        }
    }

}