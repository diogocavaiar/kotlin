package diogocavaiar.com.br.projetoteste.ui.repositorygit

import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ProgressBar
import diogocavaiar.com.br.projetoteste.R
import diogocavaiar.com.br.projetoteste.data.model.Item
import diogocavaiar.com.br.projetoteste.ui.EndlessRecyclerOnScrollListerner
import diogocavaiar.com.br.projetoteste.ui.ListPaddingDecoration
import diogocavaiar.com.br.projetoteste.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import diogocavaiar.com.br.projetoteste.ui.detailrepository.PullRequestRepositoryActivity
import diogocavaiar.com.br.projetoteste.util.Constants


class RepositoryGitActivity : BaseActivity(), RepositoryGitView, OnClickCard {

    lateinit var mPresenter: RepositoryGitPresenter

    lateinit var mAdapter: RepositoryGitAdapter

    val mLayoutManager = LinearLayoutManager(this)

    private lateinit var mOnScrollListener: RecyclerView.OnScrollListener

    override fun onPause() {
        super.onPause()

        mPresenter.unsubscribe()
    }

    override fun getResId(): Int {
        return R.layout.activity_main
    }

    override fun initAdapter() {
        mAdapter = RepositoryGitAdapter(this)
    }

    override fun initUI() {
        activity_main_recyclerView.layoutManager = mLayoutManager
        activity_main_recyclerView.addItemDecoration(ListPaddingDecoration(
                this,
                 40,
                0
        ))
        activity_main_recyclerView.adapter = mAdapter
    }

    override fun initListener() {
        mOnScrollListener = object : EndlessRecyclerOnScrollListerner(mLayoutManager) {
            override fun onLoadMore(current_page: Int) {
                mPresenter.getJavaRepository(current_page)
            }
        }
        activity_main_recyclerView.addOnScrollListener(mOnScrollListener)
    }

    override fun initPresenter() {
        mPresenter = RepositoryGitPresenterImpl(this)
        mPresenter.getJavaRepository(1)
    }

    override fun loadItems(items: List<Item>) {
        mAdapter.setItems(items)
    }

    override fun showProgress() {
        activity_main_progressBar.visibility = ProgressBar.VISIBLE
    }

    override fun hideProgress() {
        activity_main_progressBar.visibility = ProgressBar.GONE
    }

    override fun showMessage(message: String) {
        Snackbar.make(activity_main_root, message, Snackbar.LENGTH_LONG).show();
    }

    override fun onClickCard(owner: String?, repository: String?) {
        val intent = Intent(this, PullRequestRepositoryActivity::class.java)
        intent.putExtra(Constants.OWNER, owner)
        intent.putExtra(Constants.REPOSITORY, repository)
        startActivity(intent)
    }
}
