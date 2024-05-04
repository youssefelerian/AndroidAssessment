package com.youssef.details.di

import androidx.lifecycle.ViewModel
import com.youssef.core.presentation.viewmodel.AssessmentViewModelKey
import com.youssef.details.presentation.viewmodel.UniversityDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 * Created by Youssef Ebrahim Elerian on on 3/5/24.
 * youssef.elerian@gmail.com
 */


@Module
abstract class UniversityDetailsViewModule {

    @UniversityDetailsScope
    @Binds
    @IntoMap
    @AssessmentViewModelKey(UniversityDetailsViewModel::class)
    internal abstract fun universityDetailsViewModel(viewModel: UniversityDetailsViewModel): ViewModel

}