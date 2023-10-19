package com.mzulsept.zulrestapi.api

import com.mzulsept.zulrestapi.ResponseEvent
import com.mzulsept.zulrestapi.ResponseKategori
import com.mzulsept.zulrestapi.ResponsePosts
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    fun getPost(): Call<ResponsePosts>

    @GET("kategori")
    fun getKategori(): Call<ResponseKategori>

    @GET("event")
    fun getEvent(): Call<ResponseEvent>
}
