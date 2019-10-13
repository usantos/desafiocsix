package br.com.desafiocsix.view.interfaces


import br.com.desafiocsix.request.GitRepository

interface MainView {

    fun showProgress()

    fun hideProgress()

    fun populateRecyclerGitRepo(items: List<GitRepository>)

    fun showMessage(message: String)
}
