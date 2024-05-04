package com.youssef.details.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.youssef.core.extension.createErrorAlert
import com.youssef.core.presentation.uimodel.ViewState
import com.youssef.core.presentation.view.BaseFragment
import com.youssef.core.presentation.viewmodel.AssessmentViewModelFactory
import com.youssef.details.R
import com.youssef.details.databinding.FragmentUniversityDetailsBinding
import com.youssef.details.presentation.viewmodel.UniversityDetailsViewModel
import javax.inject.Inject


class UniversityDetailsFragment : BaseFragment<FragmentUniversityDetailsBinding>() {

    @Inject
    lateinit var viewModelFactory: AssessmentViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[UniversityDetailsViewModel::class.java]
    }

    override fun bindView(layoutInflater: LayoutInflater) =
        FragmentUniversityDetailsBinding.inflate(layoutInflater)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observations()

    }

    private fun observations() {
        viewModel.getUniversityLiveData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ViewState.SuccessState -> {
                    hideProgress()

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

    private fun getUniversityDetailsError() {
        hideProgress()
        val dialog = AlertDialog.Builder(requireContext())
        dialog.createErrorAlert(getString(R.string.no_local_data_found_message))
    }

    private fun hideProgress() {
        binding.universityDetailsLoading.visibility = View.GONE
    }

}