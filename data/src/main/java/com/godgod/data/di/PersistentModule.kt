package com.godgod.data.di

import android.content.Context
import com.godgod.data.local.db.DemoDatabase
import com.godgod.data.local.db.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PersistentModule {

    @Provides
    fun providerDatabase(@ApplicationContext context: Context): DemoDatabase {
        return DemoDatabase.create(context)
    }

    @Provides
    fun provideMovieDao(database: DemoDatabase): MovieDao =
        database.movieDao()
}