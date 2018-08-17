package diogocavaiar.com.br.projetoteste.ui.detailrepository

import diogocavaiar.com.br.projetoteste.data.model.PullRequest

interface PullRequestRepositoryView {
    fun loadItems(items: List<PullRequest>)
    fun showMessage(message: String)
    fun showProgress()
    fun hideProgress()
    fun getOwner(): String
    fun getRepository(): String
}