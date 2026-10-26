package com.example.teamdirectory.ui.users

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

class UsersViewModel(
    private val repository: UserRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow<UsersUiState>(UsersUiState.Loading)
    val uiState: StateFlow<UsersUiState> = _uiState.asStateFlow()

    init {
        load()
    }

    fun load() {
        _uiState.value = UsersUiState.Loading
        viewModelScope.launch {
            try {
                val users = repository.getUsers()
                _uiState.value = UsersUiState.Success(users)
            } catch (e: ResponseException) {
                Timber.e(e, "HTTP error loading users")
                _uiState.value = UsersUiState.Error(e.message ?: "Server error")
            } catch (e: IOException) {
                Timber.e(e, "Network error loading users")
                _uiState.value = UsersUiState.Error("Network error. Please check your internet connection.")
            }
        }
    }
}
