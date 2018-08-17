package diogocavaiar.com.br.projetoteste.ui.repositorygit

import diogocavaiar.com.br.projetoteste.data.remote.repository.GitDataRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RepositoryGitPresenterImpl(val mView: RepositoryGitView) : RepositoryGitPresenter {

    private val mRepository = GitDataRepository()

    override fun getJavaRepository(page: Int) {
        mView.showProgress()
        addDisposable(mRepository.getJavaRepository(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mView.hideProgress()
                    mView.loadItems(it.items!!)
                }, {
                    mView.hideProgress()
                    mView.showMessage(it.message!!)
                })
        )
    }
}