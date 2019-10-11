package br.com.desafiocsix.view.interfaces


import br.com.desafiocsix.request.GitRepository

interface MainView {

    fun showProgress()

    fun hideProgress()

    fun setRepositoryItems(items: List<GitRepository>)

    fun showMessage(message: String)
}
