package com.salugan.cobakeluar.core.data.api.service

import com.salugan.cobakeluar.core.data.api.response.TryOutResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("mocks/8587320d-4d93-41e7-a2d4-23d4ebc2ceae/tryout/numeration")
    suspend fun getTryOut(): Response<TryOutResponse>
}