# GHAS Kotlin Lab

GitHub Advanced Security の検証用リポジトリです。

対象機能

- CodeQL
- Secret Scanning
- Push Protection
- Dependabot
- SARIF Upload

## ローカル環境起動

```bash
$ docker compose up
```

起動したアプリケーションには、以下の URL でアクセスできます。

```text
http://localhost:49080
```

## Secret Scanningのテスト

Slackのテスト用トークンを使って、意図的にSecret Scanningアラートを発生させる。
[SampleSecrets.kt](src/main/kotlin/com/example/secrets/SampleSecrets.kt)


