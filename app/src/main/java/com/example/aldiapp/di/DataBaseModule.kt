package com.example.aldiapp.di

import android.content.Context
import androidx.room.Room
import com.example.aldiapp.db.Database
import com.example.aldiapp.db.ItemDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DataBaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): Database {
        return Room.databaseBuilder(
            appContext,
            Database::class.java,
            "ItemsDB"
        ).build()
    }

    @Provides
    fun provideItemDAO(database: Database): ItemDAO {
        return database.getItemDAO()
    }
}