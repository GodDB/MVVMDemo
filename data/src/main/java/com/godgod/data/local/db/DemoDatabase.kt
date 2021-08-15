package com.godgod.data.local.db

import android.content.Context
import androidx.room.*

import com.godgod.data.local.GenreConverters
import com.godgod.data.local.model.MovieEntity
import kotlinx.coroutines.flow.Flow

@Database(entities = [MovieEntity::class], version = 1)
@TypeConverters(GenreConverters::class)
abstract class DemoDatabase : RoomDatabase() {

    companion object {
        fun create(context: Context): DemoDatabase =
            Room.databaseBuilder(
                context,
                DemoDatabase::class.java,
                "app.sqlite3"
            ).build()

    }

    abstract fun movieDao(): MovieDao
}

@Dao
interface MovieDao {

    @Query("SELECT * FROM PopularMovie ORDER BY popularity DESC")
    suspend fun getPopularMovies(): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularMovies(movies: List<MovieEntity>)

    @Delete
    suspend fun deletePopularMovie(movie: MovieEntity)

    @Delete
    suspend fun deletePopularMovies(movies: List<MovieEntity>)
}