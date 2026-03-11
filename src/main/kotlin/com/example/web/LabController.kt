package com.example.web

import com.example.vuln.CommandInjectionLab
import com.example.vuln.PathTraversalLab
import com.example.vuln.SqlInjectionLab
import org.springframework.web.bind.annotation.*

@RestController
class LabController {

    private val sql = SqlInjectionLab()
    private val path = PathTraversalLab()
    private val cmd = CommandInjectionLab()

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
