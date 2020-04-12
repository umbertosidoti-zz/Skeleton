package com.umbo.skeleton.di

import com.umbo.network.RetrofitEndPoint
import com.umbo.network.RetrofitEndPoint.Companion.BASE_URL
import com.umbo.network.RetrofitNetworkServiceImpl
import com.umbo.network_interface.NetworkService
import com.umbo.skeleton.BuildConfig
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
    fun provideRetrofitRepo(httpClient: OkHttpClient): NetworkService {
        val service = Retrofit.Builder()
            .client(httpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(RetrofitEndPoint::class.java)

        return RetrofitNetworkServiceImpl(service, BuildConfig.unsplashKey)
    }
}