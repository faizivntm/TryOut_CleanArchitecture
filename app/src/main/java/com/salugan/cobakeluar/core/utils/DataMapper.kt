package com.salugan.cobakeluar.core.utils

import com.salugan.cobakeluar.core.data.api.response.QuestionItem
import com.salugan.cobakeluar.core.data.api.response.SelectionItem
import com.salugan.cobakeluar.core.domain.models.QuestionModel
import com.salugan.cobakeluar.core.domain.models.SelectionModel

object DataMapper {
    fun mapQuestionItemToModel(input: List<QuestionItem>): List<QuestionModel> {
        val questionList = input.map {
            QuestionModel(
                id = it.id,
                tryoutId = it.tryoutId,
                questionId = it.questionId,
                qtId = it.qtId,
                essayAnswer = it.essayAnswer,
                questionText = it.questionText,
                selections = mapSelectionItemToModel(it.selection),
                selectionAnswer = it.selectionAnswer,
                keyword = it.keyword,
                shortAnswer = it.shortAnswer,
                discussion = it.discussion,
                statementQuestion = it.statementQuestion,
                isEssay = !it.shortAnswer.isNullOrEmpty(),
                isMultipleChoice = it.selectionAnswer?.size == 1,
                isMultipleCorrectChoice = it.selectionAnswer?.size!! > 1,
                hasSelected = false,
            )
        }
        return questionList
    }

    private fun mapSelectionItemToModel(input: List<SelectionItem?>?): List<SelectionModel>? {
        val selectionList = input?.map {
            SelectionModel(
                id = it?.idSelection,
                text = it?.selectionText,
                questionId = it?.questionId,
                image = it?.image,
                isSelected = false
            )
        }
        return selectionList
    }
}