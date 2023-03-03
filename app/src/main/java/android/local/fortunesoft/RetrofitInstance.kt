package android.local.fortunesoft

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api : MovieApi by lazy{
        Retrofit.Builder()
            .baseUrl("https://wookie.codesubmit.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }
}