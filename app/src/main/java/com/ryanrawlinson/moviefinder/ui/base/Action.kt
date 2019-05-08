package com.ryanrawlinson.moviefinder.ui.base

inline class Action<T>(private val f: T.() -> T) {
    operator fun invoke(t: T) = t.f()
}