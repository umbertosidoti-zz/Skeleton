package com.umbo.di.network

import com.umbo.data.NetworkRepository
import com.umbo.network.RetrofitRepositoryImpl
import com.umbo.network.RetrofitService
import com.umbo.network.RetrofitService.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
object RetrofitModule {

    @Singleton
    @Provides
    @JvmStatic
    fun provideRetrofitRepo(): NetworkRepository {
        val service = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(RetrofitService::class.java)

        return RetrofitRepositoryImpl(service)
    }
}