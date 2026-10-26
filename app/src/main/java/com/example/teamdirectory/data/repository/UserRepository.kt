package com.example.teamdirectory.data.repository

import com.example.teamdirectory.data.remote.UserApi
import com.example.teamdirectory.data.remote.UserDto

class UserRepository(
    private val userApi: UserApi,
) {
    suspend fun getUsers(): List<UserDto> {
        return userApi.getUsers()
    }

    suspend fun getUser(id: Int): UserDto {
        return userApi.getUser(id)
    }
}
