package com.stefanpetcu.codingproblemhashmap.utils

import java.util.*

// The irony is that mutableMapOf() returns an instance of LinkedHashMap:MutableMap
data class StringsHashMap(val values: MutableMap<Int, MutableList<String>> = mutableMapOf()) {
    fun add(value: String): StringsHashMap {
        val hash = calcHash(value)
        val bucket = Optional.ofNullable(values[hash]).orElse(mutableListOf())
        bucket.add(value)
        values[hash] = bucket

        return this
    }

    fun get(value: String): Optional<String> {
        val hash = calcHash(value)

        val bucket = Optional.ofNullable(values[hash])

        if (bucket.isEmpty) {
            return Optional.empty()
        }

        return Optional.ofNullable(bucket.get().find { it -> it.equals(value) })
    }

    private fun calcHash(value: String): Int {
        return value.chars().reduce { acc, ch -> acc + ch }.orElse(0)
    }
}
