package com.salugan.cobakeluar.core.domain.models

data class HasilModel(
    var id: String? = null,
    val userId: String? = null,
    val nilai: String? = null,
    val tanggal: String? = null,
    val waktu: String? = null,
    val benar: Int? = null,
    val salah: Int? = null,
    val kosong: Int? = null
)
