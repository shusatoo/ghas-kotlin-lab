package com.example.vuln

import java.sql.DriverManager

class SqlInjectionLab {

    fun findUser(username: String): String {

        val conn = DriverManager.getConnection(
            "jdbc:h2:mem:testdb",
            "sa",
            ""
        )

        val stmt = conn.createStatement()

        val sql = "SELECT username FROM users WHERE username = '$username'"

        val rs = stmt.executeQuery(sql)

        val result = StringBuilder()

        while (rs.next()) {
            result.append(rs.getString("username"))
        }

        return result.toString()
    }
}
