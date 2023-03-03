package android.local.fortunesoft

import android.local.fortunesoft.databinding.MovieLayoutBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private var movieList=ArrayList<Movy>()
    fun setMoviList(movieList: List<Movy>){
        this.movieList=movieList as ArrayList<Movy>
        notifyDataSetChanged()
    }
    class ViewHolder(val binding: MovieLayoutBinding) :RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(
           MovieLayoutBinding.inflate(
               LayoutInflater.from(
                   parent.context
               )
           )
       )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load("https://wookie.codesubmit.io/static/posters/a9d94d6e-4cab-44a9-8eec-d44ad6332b6d.jpg"+movieList[position].poster)
            .into(holder.binding.imageView)
        holder.binding.movieTittle.text=movieList[position].title
        holder.binding.description.text=movieList[position].overview
        holder.binding.director.text=movieList[position].director
       // holder.binding.rating.text= movieList[position].imdb_rating.toString()
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}