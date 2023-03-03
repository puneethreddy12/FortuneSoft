package android.local.fortunesoft

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("Popular?")
    fun getPopularMovies(@Query("https://wookie.codesubmit.io/movies") api_key: String): Call<Movies>
}