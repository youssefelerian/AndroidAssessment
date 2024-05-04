package com.youssef.list.di

import com.youssef.list.presentation.view.UniversityListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class UniversityListFragmentModule {
    @UniversityListScope
    @ContributesAndroidInjector(modules = [UniversityListModule::class, UniversityListViewModule::class])
    abstract fun bindUniversityListFragment(): UniversityListFragment

}