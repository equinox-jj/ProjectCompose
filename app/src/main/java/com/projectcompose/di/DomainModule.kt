package com.projectcompose.di

import com.projectcompose.domain.repository.Repository
import com.projectcompose.domain.usecase.CharacterInteractor
import com.projectcompose.domain.usecase.CharacterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Singleton
    @Provides
    fun providesUseCase(repository: Repository): CharacterUseCase = CharacterInteractor(repository)
}