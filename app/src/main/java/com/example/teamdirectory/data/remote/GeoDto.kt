package com.example.teamdirectory.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GeoDto(
    @SerialName("lat")
    val lat: String? = null,
    @SerialName("lng")
    val lng: String? = null,
)
