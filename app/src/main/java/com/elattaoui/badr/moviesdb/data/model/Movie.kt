package com.elattaoui.badr.moviesdb.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    var id: Int,
    @SerialName("vote_average") var voteAverage: Double?,
    @SerialName("vote_count") var voteCount: Int?,
    @SerialName("poster_path") var posterPath: String?,
    @SerialName("release_date") var releaseDate: String?,
    var title: String?,
    var overview: String?,

    )
