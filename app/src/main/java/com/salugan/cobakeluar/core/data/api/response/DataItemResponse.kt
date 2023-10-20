package com.salugan.cobakeluar.core.data.api.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataItemResponse(

    @field:SerializedName("tryout")
    val tryout: List<TryoutItemResponse>,

    @field:SerializedName("subject_name")
    val subjectName: String? = null,

    @field:SerializedName("id_subject")
    val idSubject: Int? = null
) : Parcelable