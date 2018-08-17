package diogocavaiar.com.br.projetoteste.data.remote.repository

import diogocavaiar.com.br.projetoteste.data.model.GitHubResponse
import diogocavaiar.com.br.projetoteste.data.model.PullRequest
import diogocavaiar.com.br.projetoteste.data.remote.service.GitHubService
import io.reactivex.Observable

class GitDataRepository : Repository {

    private val mService = GitHubService()

    override fun getJavaRepository(page: Int): Observable<GitHubResponse> {
        return mService.getService().getJavaRepository(page)
    }

    override fun getPullRequestRepository(owner: String, repository: String) : Observable<List<PullRequest>> {
        return mService.getService().getPullRequestRepository(owner, repository)
    }
}