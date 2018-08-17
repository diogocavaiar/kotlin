package diogocavaiar.com.br.projetoteste.ui.detailrepository

import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.widget.ProgressBar
import diogocavaiar.com.br.projetoteste.R
import diogocavaiar.com.br.projetoteste.data.model.PullRequest
import diogocavaiar.com.br.projetoteste.ui.ListPaddingDecoration
import diogocavaiar.com.br.projetoteste.ui.base.BaseActivity
import diogocavaiar.com.br.projetoteste.util.Constants
import kotlinx.android.synthetic.main.activity_detail_repository.*
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem


class PullRequestRepositoryActivity : BaseActivity(), PullRequestRepositoryView, OnClickCardDetail {

    lateinit var mPresenter: PullRequestRepositoryPresenter

    lateinit var mAdapter: PullRequestRepositoryAdapter

    val mLayoutManager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val actionBar = supportActionBar

        if(actionBar != null) {
            actionBar.title = getRepository()
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onPause() {
        super.onPause()

        mPresenter.unsubscribe()
    }

    override fun getResId(): Int {
        return R.layout.activity_detail_repository
    }

    override fun initAdapter() {
        mAdapter = PullRequestRepositoryAdapter(this)
    }

    override fun initUI() {
        activity_detail_recyclerView.layoutManager = mLayoutManager
        activity_detail_recyclerView.addItemDecoration(ListPaddingDecoration(
                this,
                40,
                0
        ))
        activity_detail_recyclerView.adapter = mAdapter
    }

    override fun initListener() {}

    override fun initPresenter() {
        mPresenter = PullRequestRepositoryPresenterImpl(this)
        mPresenter.getPullRequestRepository()
    }

    override fun loadItems(items: List<PullRequest>) {
        mAdapter.setItems(items)
    }

    override fun showMessage(message: String) {
        Snackbar.make(activity_detail_root, message, Snackbar.LENGTH_LONG).show();
    }

    override fun showProgress() {
        activity_detail_progressBar.visibility = ProgressBar.VISIBLE
    }

    override fun hideProgress() {
        activity_detail_progressBar.visibility = ProgressBar.GONE
    }

    override fun getOwner(): String {
        return intent.getStringExtra(Constants.OWNER)
    }

    override fun getRepository(): String {
        return intent.getStringExtra(Constants.REPOSITORY)
    }

    override fun openPullRequest(url: String) {
        val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(i)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}