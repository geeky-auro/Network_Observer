package com.aurosaswat.networkobserver

import javax.net.ssl.SSLEngineResult.Status
import kotlinx.coroutines.flow.*

interface ConnectivityObserver {

    fun observe(): Flow<Status>
    // The above function constantly observes the network connectivity

    enum class Status{
          Available,Unavailable,Losing,Lost
    }
}