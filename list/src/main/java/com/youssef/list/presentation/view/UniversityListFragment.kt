package com.youssef.list.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.youssef.core.presentation.uimodel.ViewState
import com.youssef.core.presentation.view.BaseFragment
import com.youssef.core.presentation.viewmodel.AssessmentViewModelFactory
import com.youssef.list.databinding.FragmentUniversityListBinding
import com.youssef.list.presentation.adapter.UniversityAdapter
import com.youssef.list.presentation.viewmodel.UniversityListViewModel
import javax.inject.Inject


class UniversityListFragment : BaseFragment<FragmentUniversityListBinding>() {

    @Inject
    lateinit var viewModelFactory: AssessmentViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[UniversityListViewModel::class.java]
    }
    private val adapter = UniversityAdapter {

    }

    override fun bindView(layoutInflater: LayoutInflater) =
        FragmentUniversityListBinding.inflate(layoutInflater)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        observations()
        viewModel.getUniversityList()
    }

    private fun initRecycler() {
        binding.universityListRV.layoutManager = LinearLayoutManager(requireContext())
        binding.universityListRV.adapter = adapter
    }

    private fun observations() {
        viewModel.getUniversityLiveData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ViewState.SuccessState -> {
                    adapter.university = state.data
                }

                is ViewState.LoadingState -> {

                }

                is ViewState.EmptyState -> {

                }

                is ViewState.ErrorState -> {

                }
            }
        }

    }


}