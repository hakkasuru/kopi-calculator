package com.hakkasuru.kopicalculator

object DestinationArgs {
    val ARG_ID = "id"
    val ARG_OPTIONS = "options"
}

enum class AppDestination(val route: String) {
    HOME("home"),
    DRINK_OPTIONS("drink-options/{${DestinationArgs.ARG_ID}}"),
    DRINK_RESULT("drink-result?${DestinationArgs.ARG_OPTIONS}={${DestinationArgs.ARG_OPTIONS}}")
}