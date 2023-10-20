package com.salugan.cobakeluar.core.data.firebase.entities

data class HasilEntity(
    var id: String? = null,
    val userId: String? = null,
    val nilai: String? = null,
    val tanggal: String? = null,
    val waktu: String? = null,
    val benar: Int? = null,
    val salah: Int? = null,
    val kosong: Int? = null
)
