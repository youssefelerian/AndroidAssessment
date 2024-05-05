package com.youssef.details.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.youssef.core.extension.createErrorAlert
import com.youssef.core.navigation.model.DetailsNavigation
import com.youssef.core.navigation.model.ListNavigation
import com.youssef.core.presentation.uimodel.ViewState
import com.youssef.core.presentation.view.BaseFragment
import com.youssef.core.presentation.viewmodel.AssessmentViewModelFactory
import com.youssef.details.R
import com.youssef.details.databinding.FragmentUniversityDetailsBinding
import com.youssef.details.domain.entity.UniversityDetailsEntity
import com.youssef.details.presentation.viewmodel.UniversityDetailsViewModel
import javax.inject.Inject


class UniversityDetailsFragment : BaseFragment<FragmentUniversityDetailsBinding>() {

    @Inject
    lateinit var viewModelFactory: AssessmentViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[UniversityDetailsViewModel::class.java]
    }

    private val navController by lazy { findNavController() }

    override fun bindView(layoutInflater: LayoutInflater) =
        FragmentUniversityDetailsBinding.inflate(layoutInflater)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observations()
        actions()
        arguments?.getString(DetailsNavigation().paramName)?.let {
            viewModel.getUniversityDetails(it)
        }
    }

    private fun actions() {
        binding.closeWithRefresh.setOnClickListener {
            navController.previousBackStackEntry?.savedStateHandle?.set(
                ListNavigation().paramName,
                true
            )
            navController.popBackStack()
        }
    }

    private fun observations() {
        viewModel.getUniversityLiveData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ViewState.SuccessState -> {
                    getUniversityDetailsSuccess(state.data)
                }

                is ViewState.LoadingState -> {
                    binding.universityDetailsLoading.visibility = View.VISIBLE
                }

                is ViewState.EmptyState -> {}
                is ViewState.ErrorState -> {
                    getUniversityDetailsError()
                }
            }
        }

    }

    private fun getUniversityDetailsSuccess(entity: UniversityDetailsEntity) {
        hideProgress()
        binding.universityNameTv.text = entity.name
        binding.universityDescTv.text = entity.country
        binding.universityDomainsTv.text = entity.getDomainsString()
        binding.universityWebPagesTv.text = entity.getWebPagesString()
    }

    private fun getUniversityDetailsError() {
        hideProgress()
        val dialog = AlertDialog.Builder(requireContext())
        dialog.createErrorAlert(getString(R.string.no_local_data_found_message))
    }

    private fun hideProgress() {
        binding.universityDetailsLoading.visibility = View.GONE
    }

}