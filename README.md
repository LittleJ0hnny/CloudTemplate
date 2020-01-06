# CloudTemplate

Generate Token

    POST url: http://localhost:8100/authservice/oauth/token

    basic Auth {
        Client ID: rootClientID
        Client Secret: rootClientSecret
    }

    headers {
        "Content-Type" "application/x-www-form-urlencoded"
    }

    body {
        grant_type: password
        username: rootClientRootUser
        password: rootClientRootUserPassword
    }

1. Make Id not updatable field