package br.com.desafiocsix.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.desafiocsix.R
import br.com.desafiocsix.request.GitRepository
import kotlinx.android.synthetic.main.item_git_repository.view.*

class GitRepoRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<GitRepository> = ArrayList()
    var onItemClick: ((GitRepository) -> Unit)? = null

    fun submitList(gitRepoList: List<GitRepository>){
        items = gitRepoList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_git_repository, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val repo = items[position]
        when(holder){
            is RepositoryViewHolder -> {
                holder.bind(repo)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class RepositoryViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView){

        private val repoName: TextView = itemView.tv_item_name

        fun bind(gitRepo: GitRepository){
            repoName.text = gitRepo.name
            itemView.setOnClickListener {
                onItemClick?.invoke(items[adapterPosition])
            }
        }
    }
}