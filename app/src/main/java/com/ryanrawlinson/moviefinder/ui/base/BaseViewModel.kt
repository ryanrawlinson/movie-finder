package com.ryanrawlinson.moviefinder.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel

//abstract class BaseViewModel<E: Event, S: ViewState> : ViewModel() {
abstract class BaseViewModel : ViewModel() {
    private val viewModelJob = SupervisorJob()
    protected val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

//    abstract fun processEvents(events: SendChannel<E>)
//
//    abstract fun states() : ReceiveChannel<S>

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}