package android.local.fortunesoft

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MovieViewModel: ViewModel() {
    private var movieLiveData= MutableLiveData<List<Movy>>()
    fun getPopularMovies(){
        RetrofitInstance.api.getPopularMovies("d6822b7b-48bb-4b78-ad5e-9ba04c517ec8").enqueue(object :retrofit2.Callback<Movies>{
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                if (response.body()!=null){
                    movieLiveData.value=response.body()!!.movies
                }else{
                    return
                }
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
               Log.d("TAG",t.message.toString())
            }

        })

    }
    fun observeMovieLiveData():LiveData<List<Movy>>{
        return movieLiveData
    }

}




