package com.godgod.data.di

import com.godgod.data.local.MovieLocalSource
import com.godgod.data.local.MovieLocalSourceImpl
import com.godgod.data.network.MovieDataSource
import com.godgod.data.network.MovieDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindMovieDataSource(movieDataSourceImpl: MovieDataSourceImpl): MovieDataSource

    @Binds
    abstract fun bindMovieLocalSource(movieLocalSourceImpl: MovieLocalSourceImpl): MovieLocalSource
}