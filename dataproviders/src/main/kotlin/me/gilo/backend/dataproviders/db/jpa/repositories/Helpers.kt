package me.gilo.backend.dataproviders.db.jpa.repositories

import java.util.*

fun <T> Optional<T>.unwrap(): T? = orElse(null)

fun <T, E> Optional<T>.unwrap(conv: (T) -> (E)): E? = unwrap()?.let { conv(it) }

fun <T, E> MutableList<T>.unwrap(conv: (MutableList<T>) -> (E)): E? = let { conv(it) }