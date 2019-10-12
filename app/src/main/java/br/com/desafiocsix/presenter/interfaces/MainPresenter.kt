package br.com.desafiocsix.presenter.interfaces

interface MainPresenter {

    fun onResume()

    fun onItemClicked(position: Int)

    fun onDestroy()

    fun onItemLongClick(position: Int)
}
