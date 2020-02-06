package io.legado.app.ui.book.arrange

import android.content.Context
import io.legado.app.R
import io.legado.app.base.adapter.ItemViewHolder
import io.legado.app.base.adapter.SimpleRecyclerAdapter
import io.legado.app.data.entities.Book
import io.legado.app.data.entities.BookGroup
import kotlinx.android.synthetic.main.item_arrange_book.view.*


class ArrangeBookAdapter(context: Context, val callBack: CallBack) :
    SimpleRecyclerAdapter<Book>(context, R.layout.item_arrange_book) {


    override fun convert(holder: ItemViewHolder, item: Book, payloads: MutableList<Any>) {
        with(holder.itemView) {
            tv_name.text = item.name
            tv_author.text = context.getString(R.string.author_show, item.author)
            tv_group.text = getGroupName(item.group)
        }
    }

    private fun getGroupName(groupId: Int): String {
        callBack.groupList.forEach {
            if (it.groupId == groupId) {
                return it.groupName
            }
        }
        return context.getString(R.string.group)
    }

    interface CallBack {
        val groupList: List<BookGroup>
    }
}