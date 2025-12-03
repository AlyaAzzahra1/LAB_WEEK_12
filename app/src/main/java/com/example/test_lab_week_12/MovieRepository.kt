package com.example.test_lab_week_12

import com.example.test_lab_week_12.api.MovieService
import com.example.test_lab_week_12.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MovieRepository(private val movieService: MovieService) {

    private val apiKey = "2aec3bef9e2a1144b21f1e5aa2ce4357"

    // fetch movies from the API
    // this function returns a Flow of Movie objects
    // a Flow is a type of coroutine that can emit multiple values
    fun fetchMovies(): Flow<List<Movie>> {
        return flow {
            // emit the list of popular movies from the API
            emit(movieService.getPopularMovies(apiKey).results)
        }.flowOn(Dispatchers.IO) // run on IO thread
    }
}
