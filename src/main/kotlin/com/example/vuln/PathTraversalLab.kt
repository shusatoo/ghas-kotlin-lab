package com.example.vuln

import java.io.File

class PathTraversalLab {

    fun readFile(name: String): String {

        val file = File("/tmp/" + name)

        return file.readText()
    }
}
