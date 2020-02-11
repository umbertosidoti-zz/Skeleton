package com.umbo.skeleton.pages

import androidx.test.espresso.matcher.ViewMatchers.withText
import com.agoda.kakao.screen.Screen.Companion.onScreen

class DetailPage {

    fun shouldSeeTitle(text: String) {
        onDetailScreen {
            title {
                matches { withText(text) }
            }
        }
    }

    fun shouldSeeUrl(text: String) {
        onDetailScreen {
            url {
                matches { withText(text) }
            }
        }
    }

    fun tapBack() {
        onDetailScreen {
            pressBack()
        }
    }

    fun shouldSeeAlbum(text: String) {
        onDetailScreen {
            album {
                matches { withText(text) }
            }
        }
    }

    companion object {
        fun whileOnDetailScreen(receiver: DetailPage.() -> Unit) {
            DetailPage().apply(receiver)
        }

        private fun onDetailScreen(receiver: DetailPageScreen.() -> Unit) {
            onScreen<DetailPageScreen> {
                receiver(this)
            }
        }
    }
}