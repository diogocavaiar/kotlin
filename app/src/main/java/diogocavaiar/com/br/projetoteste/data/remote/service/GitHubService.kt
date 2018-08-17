package diogocavaiar.com.br.projetoteste.data.remote.service

import diogocavaiar.com.br.projetoteste.data.remote.ApiClient
import diogocavaiar.com.br.projetoteste.data.remote.GitHubAPI

class GitHubService {
    fun getService(): GitHubAPI {
        return ApiClient.getClient()
    }
}