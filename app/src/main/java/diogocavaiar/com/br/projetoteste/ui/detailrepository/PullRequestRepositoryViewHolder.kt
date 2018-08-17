package diogocavaiar.com.br.projetoteste.ui.detailrepository

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import diogocavaiar.com.br.projetoteste.data.model.PullRequest
import kotlinx.android.synthetic.main.row_activity_detail.view.*

class PullRequestRepositoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var mView: View = view

    fun bind(item: PullRequest, listener: OnClickCardDetail) {
        mView._row_activity_detail_tvPullRequestTitle.text = item.title
        mView._row_activity_detail_tvPullRequestBody.text = item.body
        mView._row_activity_detail_tvUsername.text = item.user!!.login
        mView._row_activity_detail_tvCreatedAt.text = item.created_at
        Glide.with( mView._row_activity_detail_ciUser.context)
                .load(item.user?.avatar_url)
                .into(mView._row_activity_detail_ciUser)
        mView._row_activity_detail_root.setOnClickListener(){listener.openPullRequest(item.html_url!!)}

    }

}