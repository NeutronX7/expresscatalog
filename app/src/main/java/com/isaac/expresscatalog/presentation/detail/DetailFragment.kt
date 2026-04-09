package com.isaac.expresscatalog.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.isaac.expresscatalog.core.network.ServiceLocator

class DetailFragment : Fragment() {

    private val viewModel: DetailViewModel by viewModels {
        DetailViewModelFactory(ServiceLocator.catalogRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val itemId = arguments?.getInt("itemId") ?: 0
        viewModel.getItem(itemId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                DetailScreen(
                    viewModel = viewModel,
                    onBackClick = { findNavController().navigateUp() }
                )
            }
        }
    }
}