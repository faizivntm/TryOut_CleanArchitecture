package com.salugan.cobakeluar.core.utils

import com.salugan.cobakeluar.core.data.api.response.QuestionItemResponse
import com.salugan.cobakeluar.core.data.api.response.SelectionItemResponse
import com.salugan.cobakeluar.core.data.firebase.entities.HasilEntity
import com.salugan.cobakeluar.core.data.firebase.entities.UserEntity
import com.salugan.cobakeluar.core.domain.models.HasilModel
import com.salugan.cobakeluar.core.domain.models.QuestionModel
import com.salugan.cobakeluar.core.domain.models.SelectionModel
import com.salugan.cobakeluar.core.domain.models.UserModel

object DataMapper {
    fun QuestionItemResponse.toModel(): QuestionModel =
        QuestionModel(
            id = this.id,
            tryoutId = this.tryoutId,
            questionId = this.questionId,
            qtId = this.qtId,
            essayAnswer = this.essayAnswer,
            questionText = this.questionText,
            selections = this.selection?.map {
                it.toModel()
            },
            selectionAnswer = this.selectionAnswer,
            keyword = this.keyword,
            shortAnswer = this.shortAnswer,
            discussion = this.discussion,
            statementQuestion = this.statementQuestion,
            isEssay = !this.shortAnswer.isNullOrEmpty(),
            isMultipleChoice = this.selectionAnswer?.size == 1,
            isMultipleCorrectChoice = this.selectionAnswer?.size!! > 1,
            hasSelected = false,
        )

    fun SelectionItemResponse?.toModel(): SelectionModel =
        SelectionModel(
            id = this?.idSelection,
            text = this?.selectionText,
            questionId = this?.questionId,
            image = this?.image,
            isSelected = false
        )

    fun UserEntity.toModel(): UserModel =
        UserModel(
            id = this.id,
            userId = this.userId,
            nama = this.nama,
            email = this.email,
            noHp = this.noHp
        )

    fun UserModel.toEntity(): UserEntity =
        UserEntity(
            id = this.id,
            userId = this.userId,
            nama = this.nama,
            email = this.email,
            noHp = this.noHp
        )

    fun HasilModel.toEntity(): HasilEntity =
        HasilEntity(
            id = this.id,
            userId = this.userId,
            nilai = this.nilai,
            tanggal = this.tanggal,
            waktu = this.waktu,
            benar = this.benar,
            salah = this.salah,
            kosong = this.kosong
        )

    fun HasilEntity.toModel(): HasilModel =
        HasilModel(
            id = this.id,
            userId = this.userId,
            nilai = this.nilai,
            tanggal = this.tanggal,
            waktu = this.waktu,
            benar = this.benar,
            salah = this.salah,
            kosong = this.kosong
        )

    fun mapQuestionItemToModel(input: List<QuestionItemResponse>): List<QuestionModel> {
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

    private fun mapSelectionItemToModel(input: List<SelectionItemResponse?>?): List<SelectionModel>? {
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