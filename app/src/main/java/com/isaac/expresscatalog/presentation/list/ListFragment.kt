package com.isaac.expresscatalog.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.isaac.expresscatalog.core.network.ServiceLocator
import com.isaac.expresscatalog.R

class ListFragment : Fragment() {

    private val viewModel: ListViewModel by viewModels {
        ListViewModelFactory(ServiceLocator.catalogRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ListScreen(
                    viewModel = viewModel,
                    onItemClick = { itemId ->
                        val bundle = Bundle().apply {
                            putInt("itemId", itemId)
                        }

                        findNavController().navigate(
                            R.id.action_listFragment_to_detailFragment,
                            bundle
                        )
                    }
                )
            }
        }
    }
}