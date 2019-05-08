package com.ryanrawlinson.moviefinder.util

import com.ryanrawlinson.moviefinder.ui.base.Action
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ProducerScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce

fun <T> produceActions(f: suspend ProducerScope<Action<T>>.() -> Unit): ReceiveChannel<Action<T>> =
    GlobalScope.produce(block = f)

suspend fun <T> ProducerScope<Action<T>>.send(f: T.() -> T) = send(Action(f))