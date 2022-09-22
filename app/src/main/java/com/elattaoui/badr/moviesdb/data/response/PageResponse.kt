package com.elattaoui.badr.moviesdb.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PageResponse<T>(
    @SerialName("page") val page: Int,
    @SerialName("total_results") var totalResults: Int,
    @SerialName("total_pages") var totalPages: Int,
    @SerialName("results") var results: T
)
