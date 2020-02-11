package com.umbo.skeleton.pages

import com.agoda.kakao.screen.Screen.Companion.onScreen

class ListPage {

    fun shouldSeeLoading() {
        onListScreen {
            loading {
                isVisible()
            }
        }
    }

    fun shouldSeeListResults() {
        onListScreen {
            recyclerList {
                isVisible()
            }
        }
    }

    fun tapOnElement(position: Int) {
        onListScreen {
            recyclerList {
                childAt<ListPageScreen.ListItem>(position) {
                    click()
                }
            }
        }
    }

    companion object {
        fun whileOnListScreen(receiver: ListPage.() -> Unit) {
            ListPage().apply(receiver)
        }

        private fun onListScreen(receiver: ListPageScreen.() -> Unit) {
            onScreen<ListPageScreen> {
                receiver(this)
            }
        }
    }
}