package diogocavaiar.com.br.projetoteste.data.remote

import diogocavaiar.com.br.projetoteste.data.model.GitHubResponse
import diogocavaiar.com.br.projetoteste.data.model.PullRequest
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubAPI {

    @GET("search/repositories?q=language:Java&sort=stars")
    fun getJavaRepository(@Query("page") page: Int) : Observable<GitHubResponse>

    @GET("repos/{owner}/{repository}/pulls")
    fun getPullRequestRepository(@Path("owner") owner: String, @Path("repository") repository: String) : Observable<List<PullRequest>>

}