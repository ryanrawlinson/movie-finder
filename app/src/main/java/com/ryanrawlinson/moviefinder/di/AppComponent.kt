package com.ryanrawlinson.moviefinder.di

import com.ryanrawlinson.moviefinder.MovieFinderApp
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ActivityModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        ServiceModule::class,
        AndroidSupportInjectionModule::class
    ]
)
interface AppComponent : AndroidInjector<MovieFinderApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MovieFinderApp>()
}