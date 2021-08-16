package com.godgod.data.local.db

import android.content.Context
import androidx.room.*
import com.godgod.data.local.GenreConverters
import com.godgod.data.local.model.MovieDetailEntity
import com.godgod.data.local.model.MovieEntity

@Database(entities = [MovieEntity::class, MovieDetailEntity::class], version = 1)
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

    @Query("SELECT * FROM MovieDetail WHERE id == :id")
    suspend fun getMovieDetail(id: Int): MovieDetailEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieDetail(detail: MovieDetailEntity)
}