package com.geka.radchenko.ebookdatatesttask.di

import android.app.Application
import androidx.room.Room
import com.geka.radchenko.ebookdatatesttask.db.DATABASE_NAME
import com.geka.radchenko.ebookdatatesttask.db.DataBase
import com.geka.radchenko.ebookdatatesttask.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoriesModule {

    @Provides
    @Singleton
    fun provideRepository(

        dataBase: DataBase,

    ): Repository {
        return Repository(dataBase)
    }

    @Provides
    @Singleton
    fun provideDatabase(application: Application): DataBase {
        return Room.databaseBuilder(application, DataBase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration().build()
    }
}