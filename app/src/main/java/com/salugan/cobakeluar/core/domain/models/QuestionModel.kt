package com.salugan.cobakeluar.core.domain.models

import android.os.Parcelable
import com.salugan.cobakeluar.core.data.api.response.DiscussionItem
import com.salugan.cobakeluar.core.data.api.response.SelectionAnswerItem
import com.salugan.cobakeluar.core.data.api.response.ShortAnswerItem
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
    val selectionAnswer: List<SelectionAnswerItem?>?,
    val keyword: List<String?>?,
    val shortAnswer: List<ShortAnswerItem?>?,
    val discussion: List<DiscussionItem?>?,
    val statementQuestion: List<String?>?,
    val isEssay: Boolean,
    val isMultipleChoice: Boolean,
    val isMultipleCorrectChoice: Boolean,
    var hasSelected: Boolean,
) : Parcelable