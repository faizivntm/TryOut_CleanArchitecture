package com.salugan.cobakeluar.core.data.firebase.entities

data class SelectionEntity(
    val id: Int?,
    val questionId: Int?,
    val text: String?,
    val image: String?,
    var isSelected: Boolean,
)