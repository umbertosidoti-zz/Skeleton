package com.umbo.skeleton.pages

import com.agoda.kakao.screen.Screen.Companion.onScreen

class DetailPage {

    fun shouldSeeTitle() {
        onDetailScreen {
            description {
                isDisplayed()
            }
        }
    }

    fun shouldSeeImage() {
        onDetailScreen {
            image {
                isDisplayed()
            }
        }
    }

    fun shouldSeeUrl() {
        onDetailScreen {
            url {
                isDisplayed()
            }
        }
    }

    fun tapBack() {
        onDetailScreen {
            pressBack()
        }
    }

    fun shouldSeeAlbum() {
        onDetailScreen {
            album {
                isDisplayed()
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