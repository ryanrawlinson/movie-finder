package com.ryanrawlinson.moviefinder.ui.base

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlin.coroutines.CoroutineContext

class ViewStateStore<T : Any>(initialState: T) : CoroutineScope {

    private val _viewState = MutableLiveData<T>().apply {
        value = initialState
    }

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun observe(owner: LifecycleOwner, observer: (T) -> Unit) =
        _viewState.observe(owner, Observer { observer(it) })

    private fun dispatchState(newState: T) {
        _viewState.value = newState
    }

    fun dispatchAction(f: suspend (T) -> Action<T>) {
        launch {
            val action = state()?.let { f(it) }
            withContext(Main) {
                state()?.let { action?.invoke(it) }?.let { dispatchState(it) }
            }
        }
    }

    fun dispatchActions(channel: ReceiveChannel<Action<T>>) {
        launch {
            channel.consumeEach { action ->
                withContext(Main) {
                    state()?.let { action.invoke(it) }?.let { dispatchState(it) }
                }
            }
        }
    }

    fun state() = _viewState.value
}