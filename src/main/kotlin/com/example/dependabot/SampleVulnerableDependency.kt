package com.example.dependabot

import org.apache.commons.collections.bag.HashBag

object SampleVulnerableDependency {

    fun countWords(input: String): Map<String, Int> {
        val bag = HashBag()

        input.split(Regex("\\s+"))
            .map { it.trim().lowercase() }
            .filter { it.isNotEmpty() }
            .forEach { bag.add(it) }

        return bag.uniqueSet()
            .associate { token -> token.toString() to bag.getCount(token) }
    }
}
