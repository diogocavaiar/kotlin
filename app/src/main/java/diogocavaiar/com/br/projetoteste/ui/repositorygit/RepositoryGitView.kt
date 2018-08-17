package diogocavaiar.com.br.projetoteste.ui.repositorygit

import diogocavaiar.com.br.projetoteste.data.model.Item

interface RepositoryGitView {
    fun loadItems(items: List<Item>)
    fun showProgress()
    fun hideProgress()
    fun showMessage(message: String)
}