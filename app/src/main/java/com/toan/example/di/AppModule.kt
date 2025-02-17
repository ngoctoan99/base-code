package com.toan.example.di
import android.content.Context
import android.content.SharedPreferences
import com.toan.example.data.api.ApiService
import com.toan.example.data.local.AppDatabase
import com.toan.example.data.local.UserDatabaseRepository
import com.toan.example.data.local.dao.UserDao
import com.toan.example.data.repository.UserRepositoryImpl
import com.toan.example.domain.repository.UserRepository
import com.toan.example.domain.usecase.GetUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(apiService: ApiService): UserRepository {
        return UserRepositoryImpl(apiService)
    }

    @Provides
    fun provideGetUserUseCase(userRepository: UserRepository): GetUserUseCase {
        return GetUserUseCase(userRepository)
    }

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase{
        return AppDatabase.getDatabase(context)
    }

    @Provides
    fun provideUserDao(database: AppDatabase):UserDao{
        return database.userDao()
    }

    @Provides
    @Singleton
    fun provideUserDatabaseRepository(userDao: UserDao): UserDatabaseRepository {
        return UserDatabaseRepository(userDao)
    }

    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("BASE_PREFS_LOCAL", Context.MODE_PRIVATE)
    }
}