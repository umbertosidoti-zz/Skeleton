package com.umbo.skeleton.di

import androidx.appcompat.app.AppCompatActivity
import com.umbo.skeleton.MainActivity
import com.umbo.skeleton.list.ListFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {
    @Binds
    fun bindAppCompatActivity(mainActivity: MainActivity): AppCompatActivity

    @ContributesAndroidInjector
    fun contributeWeatherFragment(): ListFragment

}
