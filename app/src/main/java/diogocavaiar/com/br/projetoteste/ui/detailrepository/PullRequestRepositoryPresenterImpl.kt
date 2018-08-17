package diogocavaiar.com.br.projetoteste.ui.detailrepository

import diogocavaiar.com.br.projetoteste.data.remote.repository.GitDataRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PullRequestRepositoryPresenterImpl(val mView: PullRequestRepositoryView) : PullRequestRepositoryPresenter {

    private val mRepository = GitDataRepository()

    override fun getPullRequestRepository() {
        mView.showProgress()
        addDisposable(mRepository.getPullRequestRepository(mView.getOwner(), mView.getRepository())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mView.hideProgress()
                    mView.loadItems(it)
                }, {
                    mView.hideProgress()
                    mView.showMessage(it.message!!)
                })
        )
    }
}