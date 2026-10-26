package com.example.teamdirectory.ui.detail

import com.example.teamdirectory.data.remote.UserDto

sealed interface UserDetailUiState {
    data object Loading : UserDetailUiState
    data class Success(val user: UserDto) : UserDetailUiState
    data class Error(val message: String) : UserDetailUiState
}
