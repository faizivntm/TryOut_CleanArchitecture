package com.salugan.cobakeluar.core.data.api.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize

data class QuestionItemResponse(

    @field:SerializedName("statement_question")
    val statementQuestion: List<String?>? = null,

    @field:SerializedName("selection")
    val selection: List<SelectionItemResponse?>? = null,

    @field:SerializedName("selection_answer")
    val selectionAnswer: List<SelectionAnswerItemResponse?>? = null,

    @field:SerializedName("essay_answer")
    val essayAnswer: String? = null,

    @field:SerializedName("question_text")
    val questionText: String? = null,

    @field:SerializedName("short_answer")
    val shortAnswer: List<ShortAnswerItemResponse?>? = null,

    @field:SerializedName("qt_id")
    val qtId: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("discussion")
    val discussion: List<DiscussionItemResponse?>? = null,

    @field:SerializedName("tryout_id")
    val tryoutId: Int? = null,

    @field:SerializedName("keyword")
    val keyword: List<String?>? = null,

    @field:SerializedName("question_id")
    val questionId: Int? = null
) : Parcelable