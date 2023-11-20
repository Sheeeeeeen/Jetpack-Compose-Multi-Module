package ph.com.sheen.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ph.com.sheen.data.ClassroomRepository
import ph.com.sheen.data.DefaultClassroomRepository
import ph.com.sheen.database.dao.ClassroomDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideClassroomRepository(classroomDao: ClassroomDao): ClassroomRepository {
        return DefaultClassroomRepository(dao = classroomDao)
    }
}