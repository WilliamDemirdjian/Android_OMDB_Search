package com.wil8dev.pixture.utils.RecyclerViewMainActivity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.wil8dev.pixture.R
import com.wil8dev.pixture.model.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

/*data class MovieAdapter(val movieToDisplay: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    var listener: GalleryImageClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ViewHolder(item)
    }

    override fun getItemCount(): Int = movieToDisplay.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movieToDisplay[position], listener)
    }

    class ViewHolder(val elementDeListe: View) : RecyclerView.ViewHolder(elementDeListe) {
        fun bind(Movie: Movie, listener: (Movie) -> Unit) = with(itemView) {
            Glide.with(context!!)
                .load(Movie.poster)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(itemView.poster_movie_item)
            itemView.title_movie_item.text = Movie.title
//            itemView.plot_movie_fragment.text = Movie.plot
//            itemView.portrait.setImageResource(Movie.portrait)
            setOnClickListener { listener(Movie) }
        }
    }
}*/

class MovieAdapter(private val itemList: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private var context: Context? = null
    var listener: GalleryImageClickListener? = null
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.movie_item, parent,
            false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind() {
            val movie = itemList[adapterPosition]

            Glide.with(context!!)
                .load(movie.poster)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(itemView.poster_movie_item)
            itemView.title_movie_item.text = movie.title
//            itemView.plot_movie_fragment.text = Movie.plot
//            itemView.portrait.setImageResource(Movie.portrait)
            itemView.setOnClickListener {
                listener?.onClick(adapterPosition)
            }
        }
    }
}