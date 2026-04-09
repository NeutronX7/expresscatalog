package com.isaac.expresscatalog.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.isaac.expresscatalog.core.state.UiState
import com.isaac.expresscatalog.domain.model.Item
import com.isaac.expresscatalog.domain.repository.CatalogRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListViewModel(
    private val repository: CatalogRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<Item>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<Item>>> = _uiState.asStateFlow()

    init {
        getItems()
    }

    fun getItems() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading

            repository.getItems()
                .onSuccess { items ->
                    _uiState.value = UiState.Success(items)
                }
                .onFailure { error ->
                    _uiState.value = UiState.Error(
                        error.message ?: "Ocurrió un error al cargar items"
                    )
                }
        }
    }
}

class ListViewModelFactory(
    private val repository: CatalogRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ListViewModel(repository) as T
    }
}