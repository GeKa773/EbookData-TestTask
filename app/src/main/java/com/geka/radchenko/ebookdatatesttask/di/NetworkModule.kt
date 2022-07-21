package com.geka.radchenko.ebookdatatesttask.di

import com.geka.radchenko.ebookdatatesttask.BuildConfig
import com.geka.radchenko.ebookdatatesttask.api.Api
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://my-json-server.typicode.com/stellardiver/ebookdata/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val moshi = Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

    }

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }
}