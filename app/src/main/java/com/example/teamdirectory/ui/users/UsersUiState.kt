package com.example.teamdirectory.ui.users

import com.example.teamdirectory.data.remote.UserDto

sealed interface UsersUiState {
    data object Loading : UsersUiState
    data class Success(val users: List<UserDto>) : UsersUiState
    data class Error(val message: String) : UsersUiState
}
