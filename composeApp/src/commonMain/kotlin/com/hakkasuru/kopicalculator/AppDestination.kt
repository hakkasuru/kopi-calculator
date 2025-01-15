package com.hakkasuru.kopicalculator

object DestinationArgs {
    val ARG_ID = "id"
}

enum class AppDestination(val route: String) {
    HOME("home"),
    DRINK_OPTIONS("drink-options/{${DestinationArgs.ARG_ID}}")
}