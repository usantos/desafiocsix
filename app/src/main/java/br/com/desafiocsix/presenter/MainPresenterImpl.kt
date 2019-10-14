package br.com.desafiocsix.presenter

import br.com.desafiocsix.interactor.interfaces.LoadItemsInteractor
import br.com.desafiocsix.presenter.interfaces.MainPresenter
import br.com.desafiocsix.request.GitRepository
import br.com.desafiocsix.view.interfaces.MainView

class MainPresenterImpl(mainView: MainView, private val findItemsInteractor: LoadItemsInteractor, page: Int) : MainPresenter, LoadItemsInteractor.OnFinishedListener {

    private var mainView: MainView? = null
    private var page = 1;

    override fun onItemLongClick(position: Int) {
        if (mainView != null) {
            mainView!!.showMessage("Posição " + (position + 1) + " clicada")
        }
    }

    init {
        this.mainView = mainView
        this.page = page
    }

    override fun onResume() {
        if (mainView != null) {
            mainView!!.showProgress()
        }
        findItemsInteractor.getRepositoryList(this, page)
    }

    override fun onItemClicked(position: Int) {
        if (mainView != null) {
            mainView!!.showMessage("Posição " + (position + 1) + " clicada")
        }
    }

    override fun onDestroy() {
        mainView = null
    }

    override fun onFinished(items: List<GitRepository>) {
        if (mainView != null) {
            mainView!!.populateRecyclerGitRepo(items)
            mainView!!.hideProgress()
        }
    }

    override fun onFailure(t: Throwable) {
        if (mainView != null) {
            mainView!!.hideProgress()
        }
    }
}
