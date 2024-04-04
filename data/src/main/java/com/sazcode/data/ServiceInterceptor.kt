package com.sazcode.data

import okhttp3.Interceptor
import okhttp3.Response

class ServiceInterceptor : Interceptor {
    
    override fun intercept(chain: Interceptor.Chain): Response {
        val token =
            "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwNTc3ZWZjYTE4OWRkYzhlZWE0NjRkMGIyMWQ4ZGI1OSIsInN1YiI6IjY1ZjNjNWYzNmU5MzhhMDE2M2NjNzlhYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.h9CjTN2V1CGSWIhCCXmq76VzCzehn2lPBrqcCqb4m4A"
        var request = chain.request()
        if (request.header("No-Authentication") == null) {
            //val token = getTokenFromSharedPreference();
            //or use Token Function
            if (!token.isNullOrEmpty()) {
                val finalToken = "Bearer " + token
                request = request.newBuilder()
                    .addHeader("Authorization", finalToken)
                    .build()
            }

        }
        return chain.proceed(request)
    }
}