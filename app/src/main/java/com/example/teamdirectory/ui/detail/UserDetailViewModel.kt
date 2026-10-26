package com.example.teamdirectory.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teamdirectory.data.repository.UserRepository
import io.ktor.client.plugins.ResponseException
import java.io.IOException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class UserDetailViewModel(
    private val id: Int,
    private val repository: UserRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow<UserDetailUiState>(UserDetailUiState.Loading)
    val uiState: StateFlow<UserDetailUiState> = _uiState.asStateFlow()

    init {
        load()
    }

    fun load() {
        _uiState.value = UserDetailUiState.Loading
        viewModelScope.launch {
            try {
                val user = repository.getUser(id)
                _uiState.value = UserDetailUiState.Success(user)
            } catch (e: ResponseException) {
                Timber.e(e, "HTTP error loading user detail for id=$id")
                _uiState.value = UserDetailUiState.Error(e.message ?: "Server error")
            } catch (e: IOException) {
                Timber.e(e, "Network error loading user detail for id=$id")
                _uiState.value = UserDetailUiState.Error("Network error. Please check your internet connection.")
            }
        }
    }
}
