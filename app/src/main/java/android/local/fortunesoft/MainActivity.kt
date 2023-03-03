package android.local.fortunesoft

import android.local.fortunesoft.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var movieAdapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        prepareRecyclerView()
        viewModel=ViewModelProvider(this)[MovieViewModel::class.java]
        viewModel.getPopularMovies()
        viewModel.observeMovieLiveData().observe(this, Observer { moviList ->
            movieAdapter.setMoviList(moviList)
        })
    }

    private fun prepareRecyclerView() {
        movieAdapter= MovieAdapter()
//        binding.rvMovies.apply {
//            layoutManager= LinearLayoutManager(this@MainActivity)
//            adapter= movieAdapter
//        }
        val recyclerview = findViewById<RecyclerView>(R.id.rv_movies)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = movieAdapter
    }
}