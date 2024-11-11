package org.example

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    val co = GlobalScope.launch {
        coroutineScope {
            delay(1000)
            println("First!")
        }

        coroutineScope {
            delay(1000)
            println("Second!")
        }
    }

    co.cancel()
    println("OutSide!")
    co.join()

}

data class Node(val parent: Node?, val value: String)