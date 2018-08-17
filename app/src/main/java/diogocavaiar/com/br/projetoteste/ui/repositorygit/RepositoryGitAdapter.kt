package diogocavaiar.com.br.projetoteste.ui.repositorygit

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import diogocavaiar.com.br.projetoteste.R
import diogocavaiar.com.br.projetoteste.data.model.Item

class RepositoryGitAdapter(val mListener: OnClickCard, var mItems: MutableList<Item> = mutableListOf()) : RecyclerView.Adapter<RepositoryGitViewHolder>() {

    private val VIEW_TYPE_EMPTY_STATE = 0
    private val VIEW_TYPE_DADOS = 1

    override fun getItemViewType(position: Int): Int {
        return if (mItems.isEmpty()) VIEW_TYPE_EMPTY_STATE else VIEW_TYPE_DADOS
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryGitViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val view: View
        if (viewType == VIEW_TYPE_DADOS)
            view = inflater.inflate(R.layout.row_activity_main, parent, false)
        else
            view = inflater.inflate(R.layout.row_empty_state, parent, false)

        return RepositoryGitViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepositoryGitViewHolder, position: Int) {
        if(holder.itemViewType == VIEW_TYPE_DADOS)
        holder.bind(mItems[position], mListener)
    }

    fun setItems(items: List<Item>) {
        if(items != null)
            for(item: Item in items) {
                if(mItems.contains(item))
                    continue
                mItems.add(item)
            }
        notifyDataSetChanged()
    }
}