package com.ryanrawlinson.moviefinder.di

import com.ryanrawlinson.moviefinder.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun provideMainActivity(): MainActivity
}