package com.github.crudkt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CrudKtApplication

fun main(args: Array<String>) {
    runApplication<CrudKtApplication>(*args)
}
