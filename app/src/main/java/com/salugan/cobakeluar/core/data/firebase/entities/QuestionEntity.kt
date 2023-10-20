package com.salugan.cobakeluar.core.data.firebase.entities

import com.salugan.cobakeluar.core.data.api.response.DiscussionItemResponse
import com.salugan.cobakeluar.core.data.api.response.SelectionAnswerItemResponse
import com.salugan.cobakeluar.core.data.api.response.ShortAnswerItemResponse

data class QuestionEntity(
    val id: Int?,
    val tryoutId: Int?,
    val questionId: Int?,
    val qtId: Int?,
    val essayAnswer: String?,
    val questionText: String?,
    val selections: List<SelectionEntity>?,
    val selectionAnswer: List<SelectionAnswerItemResponse?>?,
    val keyword: List<String?>?,
    val shortAnswer: List<ShortAnswerItemResponse?>?,
    val discussion: List<DiscussionItemResponse?>?,
    val statementQuestion: List<String?>?,
    val isEssay: Boolean,
    val isMultipleChoice: Boolean,
    val isMultipleCorrectChoice: Boolean,
    var hasSelected: Boolean,
)