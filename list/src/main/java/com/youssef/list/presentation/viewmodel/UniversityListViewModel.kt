package com.youssef.list.presentation.viewmodel

import com.youssef.core.presentation.uimodel.MutableStateLiveData
import com.youssef.core.presentation.uimodel.ViewState
import com.youssef.core.presentation.viewmodel.BaseViewModel
import com.youssef.list.domain.entity.UniversityEntity
import com.youssef.list.domain.interactor.GetUniversityListUseCase
import javax.inject.Inject


class UniversityListViewModel @Inject constructor(
    private val getUniversityListUseCase: GetUniversityListUseCase
) : BaseViewModel() {

    val getUniversityLiveData = MutableStateLiveData<List<UniversityEntity>>()
    fun getUniversityList(searchName: String = "United Arab Emirates") {
        getUniversityLiveData.postValue(ViewState.loading())
        execute {
            getUniversityListUseCase.execute(searchName, success = {
                getUniversityLiveData.postValue(ViewState.success(it))
            }, error = {
                getUniversityLiveData.postValue(ViewState.error(it.throwable.message ?: "", ""))
            }, empty = {
                getUniversityLiveData.postValue(ViewState.empty())
            })
        }
    }

}