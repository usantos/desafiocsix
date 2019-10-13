package br.com.desafiocsix.view

import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.desafiocsix.R
import br.com.desafiocsix.adapter.GitRepoRecyclerAdapter
import br.com.desafiocsix.interactor.LoadItemsInteractorImpl
import br.com.desafiocsix.presenter.MainPresenterImpl
import br.com.desafiocsix.presenter.interfaces.MainPresenter
import br.com.desafiocsix.request.GitRepository
import br.com.desafiocsix.view.interfaces.MainView
import butterknife.BindView
import butterknife.ButterKnife

class MainActivity : AppCompatActivity(), MainView, AdapterView.OnItemClickListener {

    private lateinit var presenter: MainPresenter
    private lateinit var gitRepoAdapter : GitRepoRecyclerAdapter

    @BindView(R.id.git_repo_list)
    lateinit var gitRepoRecyclerView: RecyclerView

    @BindView(R.id.progress)
    lateinit var progressBar: ProgressBar

    @BindView(R.id.nav_view)
    lateinit var navView: BottomNavigationView

    override fun onResume() {
        presenter.onResume()
        super.onResume()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
        gitRepoRecyclerView.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.INVISIBLE
        gitRepoRecyclerView.visibility = View.VISIBLE
    }

    override fun populateRecyclerGitRepo(items: List<GitRepository>) {

        gitRepoRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            gitRepoAdapter = GitRepoRecyclerAdapter()
            gitRepoAdapter.submitList(items)
            adapter = gitRepoAdapter
            gitRepoAdapter.onItemClick = { gitRepo ->
                Toast.makeText(this@MainActivity, gitRepo.name, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                //textMessage.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                textMessage.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                //textMessage.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        presenter = MainPresenterImpl(this, LoadItemsInteractorImpl())
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        presenter.onItemClicked(position)
    }
}
