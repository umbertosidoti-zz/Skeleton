package com.umbo.skeleton.di

import com.umbo.data.DetailPayload
import com.umbo.data.Empty
import com.umbo.data.NavigationPayload
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.modules.SerializersModule
import javax.inject.Singleton

@Module
class JsonModule {

    @Singleton
    @Provides
    fun provideJson(): Json {
        val messageModule = SerializersModule {
            polymorphic(NavigationPayload::class) {
                Empty::class with Empty.serializer()
                DetailPayload::class with DetailPayload.serializer()
            }
        }
        return Json(context = messageModule)
    }
}