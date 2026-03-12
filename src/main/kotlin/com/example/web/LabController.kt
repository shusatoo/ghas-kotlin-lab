package com.example.web

import com.example.vuln.CommandInjectionLab
import com.example.vuln.PathTraversalLab
import com.example.vuln.SqlInjectionLab
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
class LabController {

    private val sql = SqlInjectionLab()
    private val path = PathTraversalLab()
    private val cmd = CommandInjectionLab()

    @GetMapping("/", produces = [MediaType.TEXT_HTML_VALUE])
    fun index(): String {
        return """
            <html>
              <head>
                <title>GHAS Kotlin Lab</title>
              </head>
              <body>
                <h1>GHAS Kotlin Lab</h1>
                <p>Available endpoints:</p>
                <ul>
                  <li><a href="/user?username=test">/user?username=test</a></li>
                  <li><a href="/file?name=test.txt">/file?name=test.txt</a></li>
                  <li><a href="/ping?host=127.0.0.1">/ping?host=127.0.0.1</a></li>
                </ul>
              </body>
            </html>
        """.trimIndent()
    }

    @GetMapping("/user")
    fun user(@RequestParam username: String): String {
        return sql.findUser(username)
    }

    @GetMapping("/file")
    fun file(@RequestParam name: String): String {
        return path.readFile(name)
    }

    @GetMapping("/ping")
    fun ping(@RequestParam host: String): String {
        return cmd.ping(host)
    }
}
