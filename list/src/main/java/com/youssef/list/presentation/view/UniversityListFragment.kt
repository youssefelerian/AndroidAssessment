package com.youssef.list.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.youssef.core.extension.createErrorAlert
import com.youssef.core.navigation.DeeplinkHandler
import com.youssef.core.navigation.model.DetailsNavigation
import com.youssef.core.presentation.uimodel.ViewState
import com.youssef.core.presentation.view.BaseFragment
import com.youssef.core.presentation.viewmodel.AssessmentViewModelFactory
import com.youssef.list.R
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

    @Inject
    lateinit var deeplinkHandler: DeeplinkHandler

    private val adapter = UniversityAdapter {
        deeplinkHandler.process(
            DetailsNavigation().build(requireContext(), it.name),
            findNavController()
        )
    }

    override fun bindView(layoutInflater: LayoutInflater) =
        FragmentUniversityListBinding.inflate(layoutInflater)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        observations()

    }

    private fun initRecycler() {
        binding.universityListRV.layoutManager = LinearLayoutManager(requireContext())
        binding.universityListRV.adapter = adapter
    }

    private fun observations() {
        viewModel.getUniversityLiveData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ViewState.SuccessState -> {
                    hideProgress()
                    adapter.university = state.data
                }

                is ViewState.LoadingState -> {
                    binding.universityListLoading.visibility = View.VISIBLE
                }

                is ViewState.EmptyState -> {
                    getUniversityListEmpty()
                }

                is ViewState.ErrorState -> {
                    getUniversityListError()
                }
            }
        }

    }

    private fun getUniversityListEmpty() {
        hideProgress()
        val dialog = AlertDialog.Builder(requireContext())
        dialog.createErrorAlert(getString(R.string.no_university_found_message))
    }

    private fun getUniversityListError() {
        hideProgress()
        val dialog = AlertDialog.Builder(requireContext())
        dialog.createErrorAlert()
    }

    private fun hideProgress() {
        binding.universityListLoading.visibility = View.GONE
    }

}