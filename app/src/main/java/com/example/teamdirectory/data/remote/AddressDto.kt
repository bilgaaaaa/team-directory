package com.example.teamdirectory.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddressDto(
    @SerialName("street")
    val street: String? = null,
    @SerialName("suite")
    val suite: String? = null,
    @SerialName("city")
    val city: String? = null,
    @SerialName("zipcode")
    val zipcode: String? = null,
    @SerialName("geo")
    val geo: GeoDto? = null,
)
