package com.umbo.di.network

import com.umbo.data.NetworkService
import com.umbo.network.RetrofitService
import com.umbo.network.RetrofitService.Companion.BASE_URL
import com.umbo.network.RetrofitServiceImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
object RetrofitModule {

    @Singleton
    @Provides
    @JvmStatic
    fun provideRetrofitRepo(): NetworkService {
        val service = Retrofit.Builder()
            .client(
                OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build())
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(RetrofitService::class.java)

        return RetrofitServiceImpl(service)
    }
}