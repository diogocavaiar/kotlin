package diogocavaiar.com.br.projetoteste.ui.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

interface BasePresenter {

    private val mCompositeDisposable: CompositeDisposable
        get() = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        mCompositeDisposable.addAll(disposable)
    }

    fun unsubscribe() {
        mCompositeDisposable.clear()
    }
}