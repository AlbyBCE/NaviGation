package com.example.navifationyt

const val DETAIL_ARGUMENT_KEY = "id"
const val DETAIL_ARGUMENT_KEY2 = "name"

sealed class Screen(var route: String) {
    object Home : Screen("home_Screen")
    object Detail : Screen("detail_Screen/{$DETAIL_ARGUMENT_KEY}/{$DETAIL_ARGUMENT_KEY2}") {
        //        fun passId(id:Int):String{
//            return this.route.replace(oldValue = "$DETAIL_ARGUMENT_KEY" , newValue = id.toString())
//        }
        fun passNameAndId(id: Int, name: String): String {
            return "detail_Screen/$id/$name"
        }
    }
}
