package com.webwerks.demokotlinapp.api

import com.google.gson.Gson
import com.webwerks.demokotlinapp.global.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class APIClient {

    companion object {

       var retrofit: Retrofit? = null

        fun getClient(): Retrofit {

            if (retrofit == null) {
                val gson = Gson()
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                val client = OkHttpClient.Builder()
                        .addInterceptor(loggingInterceptor)
                        .build()

                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(client)
                        .build()

            }
            return retrofit!!
        }
    }

}