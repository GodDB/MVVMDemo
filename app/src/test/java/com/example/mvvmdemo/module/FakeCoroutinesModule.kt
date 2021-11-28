package com.example.mvvmdemo.module

import com.godgod.shared.di.DefaultDispatcher
import com.godgod.shared.di.IoDispatcher
import com.godgod.shared.di.MainDispatcher
import com.godgod.shared.di.MainImmediateDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher

@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [CoroutinesModule::class]
)
@Module
@ExperimentalCoroutinesApi
object FakeCoroutinesModule {

    @DefaultDispatcher
    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher = TestCoroutineDispatcher()

    @IoDispatcher
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = TestCoroutineDispatcher()

    @MainDispatcher
    @Provides
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @MainImmediateDispatcher
    @Provides
    fun providesMAinImmediateDispatcher(): CoroutineDispatcher = Dispatchers.Main.immediate
}