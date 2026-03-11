package com.example.vuln

class CommandInjectionLab {

    fun ping(host: String): String {

        val process = Runtime.getRuntime()
            .exec(arrayOf("sh","-c","ping -c 1 $host"))

        return process.inputStream.bufferedReader().readText()
    }
}
