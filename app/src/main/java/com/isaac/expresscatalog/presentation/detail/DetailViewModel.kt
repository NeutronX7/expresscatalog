package com.isaac.expresscatalog.presentation.detail

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

class DetailViewModel(
    private val repository: CatalogRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<Item>>(UiState.Loading)
    val uiState: StateFlow<UiState<Item>> = _uiState.asStateFlow()

    fun getItem(id: Int) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading

            repository.getItemById(id)
                .onSuccess { item ->
                    _uiState.value = UiState.Success(item)
                }
                .onFailure { error ->
                    _uiState.value = UiState.Error(
                        error.message ?: "Ocurrió un error al cargar detalle"
                    )
                }
        }
    }
}

class DetailViewModelFactory(
    private val repository: CatalogRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(repository) as T
    }
}