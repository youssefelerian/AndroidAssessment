package com.youssef.core.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import dagger.android.support.DaggerFragment

abstract class BaseFragment<V : ViewBinding> : DaggerFragment() {

    protected var bindView: V? = null
    protected val binding get() = bindView!!

    abstract fun bindView(layoutInflater: LayoutInflater): V

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindView = bindView(layoutInflater)
        return binding.root
    }

    override fun onDestroyView() {
        bindView = null
        super.onDestroyView()
    }

}