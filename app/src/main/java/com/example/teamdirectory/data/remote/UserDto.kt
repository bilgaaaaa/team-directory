package com.example.teamdirectory.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    @SerialName("id")
    val id: Int? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("username")
    val username: String? = null,
    @SerialName("email")
    val email: String? = null,
    @SerialName("address")
    val address: AddressDto? = null,
    @SerialName("phone")
    val phone: String? = null,
    @SerialName("website")
    val website: String? = null,
    @SerialName("company")
    val company: CompanyDto? = null,
)
