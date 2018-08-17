package diogocavaiar.com.br.projetoteste.data.remote.repository

import diogocavaiar.com.br.projetoteste.data.model.GitHubResponse
import diogocavaiar.com.br.projetoteste.data.model.PullRequest
import io.reactivex.Observable
import okhttp3.ResponseBody

interface Repository {

    fun getJavaRepository(page: Int) : Observable<GitHubResponse>

    fun getPullRequestRepository(owner: String, repository: String) : Observable<List<PullRequest>>

}