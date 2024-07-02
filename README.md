# Challenger-ForumHub

## Visão Geral

Esta API permite a criação, listagem, detalhamento, atualização e exclusão de tópicos em um fórum, bem como autenticação de usuários utilizando tokens JWT.

## Endpoints

### Autenticação

- **URL:** `POST /auth`
- **Descrição:** Autentica um usuário e gera um token JWT.
- **Body:**
  ```json
  {
    "email": "user@example.com",
    "senha": "password"
  }
