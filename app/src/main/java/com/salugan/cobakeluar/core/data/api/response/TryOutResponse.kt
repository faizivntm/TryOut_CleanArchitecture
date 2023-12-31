package com.salugan.cobakeluar.core.data.api.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize

data class TryOutResponse(

    @field:SerializedName("code")
    val code: Int? = null,

    @field:SerializedName("data")
    val data: List<DataItemResponse>,

    @field:SerializedName("message")
    val message: String? = null
) : Parcelable













