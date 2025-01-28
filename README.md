
# Portfolio Ai - Backend

Criação automática de portfólio para devs!

Como funcionará:

- Você poderá usar seu perfil no github ou linkedin, conectar ao sistema e criar um site de portfólio personalizável! Isso mesmo, sem você ter que criar seu próprio, mas somente tendo perfil em uma dessas contas.
 




## Stack utilizada


**Back-end:** ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)  ![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)


## Documentação da API

#### Retorna todos os usuários

```http
  GET /api/users
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `api_key` | `string` | **Obrigatório**. A chave da sua API |

#### Retorna um usuário

```http
  GET /api/users/${email}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `email`      | `string` | **Obrigatório**. O email do usuário desejado |


## Roadmap

~~- Resolver bugs com mapstruct~~

- Adicionar entidades
  - ~~User~~  

- Spring Security

- OAuth2

- Testes unitários com JUnit

- Observabilidade com Actuator

- CI/CD com Github Actions

- Revisão

## Apêndice

Viu um ponto de melhoria? Gostaria de ajuda? Entre em contato comigo no Linkedin!! (Clique no botão abaixo) 

[![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/gustavodiasdsc)
