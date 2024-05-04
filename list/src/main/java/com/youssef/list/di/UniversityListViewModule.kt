package com.youssef.list.di

import androidx.lifecycle.ViewModel
import com.youssef.core.presentation.viewmodel.AssessmentViewModelKey
import com.youssef.list.presentation.viewmodel.UniversityListViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 * Created by Youssef Ebrahim Elerian on on 3/5/24.
 * youssef.elerian@gmail.com
 */


@Module
abstract class UniversityListViewModule {

    @UniversityListScope
    @Binds
    @IntoMap
    @AssessmentViewModelKey(UniversityListViewModel::class)
    internal abstract fun universityListViewModel(viewModel: UniversityListViewModel): ViewModel

}