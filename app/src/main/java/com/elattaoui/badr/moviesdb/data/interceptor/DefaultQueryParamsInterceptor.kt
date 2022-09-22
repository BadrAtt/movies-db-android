package com.elattaoui.badr.moviesdb.data.interceptor

import javax.inject.Inject
import javax.inject.Singleton
import okhttp3.Interceptor
import okhttp3.Response

@Singleton
class DefaultQueryParamsInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter("api_key", "c9856d0cb57c3f14bf75bdc6c063b8f3")
            .addQueryParameter("sort_by", "popularity.desc")
            .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}
