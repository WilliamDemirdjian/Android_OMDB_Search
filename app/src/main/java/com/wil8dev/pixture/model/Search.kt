package com.wil8dev.pixture.model

import com.google.gson.annotations.SerializedName

data class Search(
    @SerializedName("Search")
    val resultSearch: List<Movie>?
)