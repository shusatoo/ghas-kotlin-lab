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

Secret Scanningからは以下のようなアラートが出る。

```sh
$ git push origin devlab
...
remote: error: GH013: Repository rule violations found for refs/heads/devlab.
remote: 
remote: - GITHUB PUSH PROTECTION
remote:   —————————————————————————————————————————
remote:     Resolve the following violations before pushing again
remote: 
remote:     - Push cannot contain secrets
remote: 
remote:     
remote:      (?) Learn how to resolve a blocked push
remote:      https://docs.github.com/code-security/secret-scanning/working-with-secret-scanning-and-push-protection/working-with-push-protection-from-the-command-line#resolving-a-blocked-push
remote:     
remote:     
remote:       —— Slack Incoming Webhook URL ————————————————————————
remote:        locations:
remote:          - commit: 9e4c66f49fbf0124b882ca4cf0647a4d1d4ef50a
remote:            path: src/main/kotlin/com/example/secrets/SampleSecrets.kt:6
remote:     
remote:        (?) To push, remove secret from commit(s) or follow this URL to allow the secret.
remote:        https://github.com/shusatoo/ghas-kotlin-lab/security/secret-scanning/unblock-secret/3D4M1sOsswRFdziFPIxRzi5jYVL
remote:     
remote: 
remote: 
To https://github.com/shusatoo/ghas-kotlin-lab.git
 ! [remote rejected] devlab -> devlab (push declined due to repository rule violations)
error: failed to push some refs to 'https://github.com/shusatoo/ghas-kotlin-lab.git'
```

