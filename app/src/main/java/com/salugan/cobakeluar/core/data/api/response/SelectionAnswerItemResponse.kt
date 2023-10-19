package com.salugan.cobakeluar.core.data.api.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize

data class SelectionAnswerItemResponse(

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("id_answer")
    val idAnswer: Int? = null,

    @field:SerializedName("selection_id")
    val selectionId: Int? = null,

    @field:SerializedName("question_id")
    val questionId: Int? = null,

    @field:SerializedName("selection_text")
    val selectionText: String? = null
) : Parcelable