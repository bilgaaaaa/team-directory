package com.example.teamdirectory.navigation

import kotlinx.serialization.Serializable

@Serializable
object UsersRoute

@Serializable
data class UserDetailRoute(val id: Int)
