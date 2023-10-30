package com.salugan.cobakeluar.core.data.firebase.entities

data class HasilEntity(
    var id: String? = "",
    val userId: String? = "",
    val nilai: String? = "",
    val tanggal: String? = "",
    val waktu: String? = "",
    val benar: Int? = 0,
    val salah: Int? = 0,
    val kosong: Int? = 0
)
