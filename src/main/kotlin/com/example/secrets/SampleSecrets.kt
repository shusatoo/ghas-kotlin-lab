package com.example.secrets

object SampleSecrets {

    // ホスト部の `.example.com` を除去してpush試行すると Secret Scanningアラートが出る。
    // GitHub側で定義されているパターンにマッチするため。（Slack webhook URLのパターン）
    // See: https://docs.github.com/ja/code-security/reference/secret-security/supported-secret-scanning-patterns
    const val SLACK_EXAMPLE_WEBHOOK_URL =
        "https://hooks.slack.com.example.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX"

}
