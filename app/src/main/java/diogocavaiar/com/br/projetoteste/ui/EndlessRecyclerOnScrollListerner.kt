package diogocavaiar.com.br.projetoteste.ui

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

abstract class EndlessRecyclerOnScrollListerner(val linearLayoutManager: LinearLayoutManager) : RecyclerView.OnScrollListener() {

    private var mPreviousTotal = 0
    private var mLoading = true
    private val mVisibleThreshold = 5
    private var mFirstVisibleItem: Int = 0
    private var mVisibleItemCount:Int = 0
    private var mTotalItemCount:Int = 0
    private var mCurrentPage = 1

    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        mVisibleItemCount = recyclerView!!.childCount
        mTotalItemCount = linearLayoutManager.itemCount
        mFirstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition()

        if (mLoading) {
            if (mTotalItemCount > mPreviousTotal) {
                mLoading = false
                mPreviousTotal = mTotalItemCount
            }
        }
        if (!mLoading && mTotalItemCount - mVisibleItemCount <= mFirstVisibleItem + mVisibleThreshold) {
            mCurrentPage++
            onLoadMore(mCurrentPage)
            mLoading = true
        }
    }

    abstract fun onLoadMore(current_page: Int)
}