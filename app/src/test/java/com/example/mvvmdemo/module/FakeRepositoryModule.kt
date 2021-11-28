package com.example.mvvmdemo.module

import com.godgod.domain.fake.FakeMovieRepositoryImpl
import com.godgod.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [RepositoryModule::class]
)
abstract class FakeRepositoryModule {

    @Binds
    abstract fun bindMovieRepository(fakeMovieRepositoryImpl: FakeMovieRepositoryImpl): MovieRepository
}