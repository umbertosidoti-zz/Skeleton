package com.umbo.skeleton.pages

import android.view.View
import com.agoda.kakao.progress.KProgressBar
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import com.umbo.skeleton.R
import org.hamcrest.Matcher

class ListPageScreen : Screen<ListPageScreen>() {

    val loading = KProgressBar { withId(R.id.listLoading) }
    val recyclerList = KRecyclerView ({withId(R.id.listRecyclerView)}, itemTypeBuilder = {itemType(::ListItem)})

    class ListItem(parent: Matcher<View>): KRecyclerItem<ListItem>(parent) {
        val title = KTextView(parent) {withId(R.id.listItemTitle)}
    }
}