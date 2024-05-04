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

    val liveData = MutableStateLiveData<List<UniversityEntity>>()
    fun getUniversityList(searchName: String = "United Arab Emirates") {
        execute {
            getUniversityListUseCase.execute(searchName, success = {
                liveData.postValue(ViewState.success(it))
            }, error = {
                liveData.postValue(ViewState.error(it.throwable.message ?: "", ""))
            }, empty = {
                liveData.postValue(ViewState.empty())
            })
        }
    }

}