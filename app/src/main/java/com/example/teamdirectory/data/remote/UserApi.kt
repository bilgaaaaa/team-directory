package com.example.teamdirectory.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class UserApi(
    private val client: HttpClient,
) {
    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }

    suspend fun getUsers(): List<UserDto> {
        return client.get("$BASE_URL/users").body()
    }

    suspend fun getUser(id: Int): UserDto {
        return client.get("$BASE_URL/users/$id").body()
    }
}
