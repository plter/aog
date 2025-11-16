/*
Created on 2025/11/15
@author https://yunp.top
 */

package top.yunp.aog.async

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine


suspend fun <R> vtCoroutine(runner: () -> R): R {
    return suspendCoroutine {
        Thread.startVirtualThread {
            try {
                it.resume(runner())
            } catch (e: Throwable) {
                it.resumeWithException(e)
            }
        }
    }
}

val IOScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)