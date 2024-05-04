package com.youssef.details.di


import com.youssef.details.presentation.view.UniversityDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class UniversityDetailsFragmentModule {
    @UniversityDetailsScope
    @ContributesAndroidInjector(modules = [UniversityDetailsModule::class, UniversityDetailsViewModule::class])
    abstract fun bindUniversityDetailsFragment(): UniversityDetailsFragment

}