package com.soluone.com.maishameds.data

import com.soluone.com.maishameds.BuildConfig
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object NetworkClient {

    private val dispatcher = Dispatcher()
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    /**
     * Create okHttpClient
     */
    val client: OkHttpClient
        get() {
            dispatcher.maxRequests = 2

            // we using this OkHttp, you can add authenticator, interceptors, dispatchers,
            // logging stuff etc. easily for all your requests just editing this OkHttp
            val builder = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .addInterceptor { chain ->
                    val original = chain.request()

                    val request = original.newBuilder().apply {
                        addHeader("Accept", "application/json; version=1")
                        addHeader("App", "AgentApp")
                    }
                        .build()

                    chain.proceed(request)
                }
                .dispatcher(dispatcher)
                .cache(null)

            //only show okHttp logs if app is in debug mode
            if (BuildConfig.DEBUG) {
                builder.addInterceptor(loggingInterceptor)
            }
            return builder.build()
        }
}
