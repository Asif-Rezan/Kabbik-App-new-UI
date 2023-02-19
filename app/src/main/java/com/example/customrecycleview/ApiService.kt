package com.example.customrecycleview

interface ApiService {
    @POST("")
    suspend fun postData(@Body requestData: RequestData): ApiResponse

}