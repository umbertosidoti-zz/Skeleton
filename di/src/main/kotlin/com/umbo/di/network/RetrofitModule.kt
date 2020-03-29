package com.umbo.di.network

import com.umbo.network.RetrofitEndPoint
import com.umbo.network.RetrofitEndPoint.Companion.BASE_URL
import com.umbo.network.RetrofitNetworkServiceImpl
import com.umbo.network_interface.NetworkService
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
            .build().create(RetrofitEndPoint::class.java)

        return RetrofitNetworkServiceImpl(service)
    }
}