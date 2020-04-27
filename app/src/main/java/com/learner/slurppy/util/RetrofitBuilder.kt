package com.learner.slurppy.util

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitBuilder {

    val baseURL ="https://jsonplaceholder.typicode.com/"
    private var retrofit : Retrofit? = null

    fun getClient(): Retrofit? {

        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
        }
        return retrofit
    }


}