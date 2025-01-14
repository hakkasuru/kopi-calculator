package com.hakkasuru.kopicalculator

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform