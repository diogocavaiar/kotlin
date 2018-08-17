package diogocavaiar.com.br.projetoteste.ui.repositorygit

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import diogocavaiar.com.br.projetoteste.data.model.Item
import kotlinx.android.synthetic.main.row_activity_main.view.*

class RepositoryGitViewHolder (view: View) : RecyclerView.ViewHolder(view){

    private var mView: View = view

    fun bind(item: Item, listener: OnClickCard) {
        mView._row_activity_main_tvRepositoryName.text = item.name
        mView._row_activity_main_tvRepositoryDescription.text = item.description
        mView._row_activity_main_tvForkQuantity.text = item.forks_count.toString()
        mView._row_activity_main_tvStarQuantity.text = item.stargazers_count.toString()
        mView._row_activity_main_tvUsername.text = item.owner!!.login
        mView._row_activity_main_tvNameLastName.text = item.fullName
        Glide.with(mView._row_activity_main_ciUser.context)
                .load(item.owner?.avatar_url)
                .into(mView._row_activity_main_ciUser)

        mView._row_activity_main_card.setOnClickListener() {listener.onClickCard(item.owner!!.login, item.name!!)}
    }
}