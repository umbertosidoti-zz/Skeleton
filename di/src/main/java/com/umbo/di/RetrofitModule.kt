package com.umbo.di

import com.umbo.data.NetworkRepo
import com.umbo.network.RetrofitRepoImpl
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
    fun provideRetrofitRepo(): NetworkRepo {
        val service = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(RetrofitService::class.java)

        return RetrofitRepoImpl(service)
    }
}