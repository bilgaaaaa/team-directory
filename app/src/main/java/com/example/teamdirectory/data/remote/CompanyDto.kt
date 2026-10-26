package com.example.teamdirectory.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CompanyDto(
    @SerialName("name")
    val name: String? = null,
    @SerialName("catchPhrase")
    val catchPhrase: String? = null,
    @SerialName("bs")
    val bs: String? = null,
)
