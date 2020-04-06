package com.umbo.skeleton.pages

import com.agoda.kakao.image.KImageView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import com.umbo.skeleton.R

class DetailPageScreen : Screen<DetailPageScreen>() {
    val description = KTextView { withId(R.id.detailDescription) }
    val url = KTextView { withId(R.id.detailUrl) }
    val album = KTextView { withId(R.id.detailSize) }
    val image = KImageView {withId(R.id.detailImage)}

}