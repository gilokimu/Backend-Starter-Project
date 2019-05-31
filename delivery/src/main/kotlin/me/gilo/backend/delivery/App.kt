package me.gilo.backend.delivery

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages = [
    "me.gilo.backend.delivery.config",
    "me.gilo.backend.dataproviders.db.jpa.config",
    "me.gilo.backend.delivery.rest.imp"
])
class App

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}
