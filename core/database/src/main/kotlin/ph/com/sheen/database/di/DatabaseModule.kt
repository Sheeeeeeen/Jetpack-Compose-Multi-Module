package ph.com.sheen.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ph.com.sheen.database.AppDatabase
import ph.com.sheen.database.dao.ClassroomDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = AppDatabase::class.java,
            name = AppDatabase.DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideClassroomDao(appDatabase: AppDatabase): ClassroomDao {
        return appDatabase.classroomDao()
    }
}