package com.salugan.cobakeluar.core.domain.models

import android.os.Parcelable
import com.salugan.cobakeluar.core.data.api.response.DiscussionItemResponse
import com.salugan.cobakeluar.core.data.api.response.SelectionAnswerItemResponse
import com.salugan.cobakeluar.core.data.api.response.ShortAnswerItemResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class QuestionModel(
    val id: Int?,
    val tryoutId: Int?,
    val questionId: Int?,
    val qtId: Int?,
    val essayAnswer: String?,
    val questionText: String?,
    val selections: List<SelectionModel>?,
    val selectionAnswer: List<SelectionAnswerItemResponse?>?,
    val keyword: List<String?>?,
    val shortAnswer: List<ShortAnswerItemResponse?>?,
    val discussion: List<DiscussionItemResponse?>?,
    val statementQuestion: List<String?>?,
    val isEssay: Boolean,
    val isMultipleChoice: Boolean,
    val isMultipleCorrectChoice: Boolean,
    var hasSelected: Boolean,
) : Parcelable