# Sistema de Barbearia

## Visão Geral
Este projeto é um sistema de gerenciamento para uma barbearia, permitindo que clientes agendem serviços, barbeiros gerenciem seus horários e administradores acompanhem o faturamento e estoque.

## Tecnologias Utilizadas

### Backend
- ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white) **Java (Spring Boot)** - Framework para desenvolvimento do backend
- ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white) **Spring Boot** - Gerenciamento de APIs REST e injeção de dependências
- ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white) **PostgreSQL** - Banco de dados relacional
- ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white) **Hibernate** - ORM para gerenciamento do banco de dados
- ![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=json-web-tokens&logoColor=white) **JWT** - Autenticação e segurança dos usuários

### Frontend
- ![Angular](https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white) **Angular** - Interface gráfica do usuário
- ![TypeScript](https://img.shields.io/badge/TypeScript-007ACC?style=for-the-badge&logo=typescript&logoColor=white) **TypeScript** - Linguagem utilizada no Angular
- ![Bootstrap](https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white) **Bootstrap** - Estilização e responsividade

### Outras Ferramentas
- ![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white) **Git & GitHub** - Controle de versão
- ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white) **Postman** - Testes de API
- ![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white) **Docker** - Containerização do ambiente

## Estrutura do Banco de Dados
O banco de dados contém as seguintes tabelas principais:

1. **Usuario** - Armazena clientes e barbeiros
2. **Servico** - Lista os serviços oferecidos
3. **Agendamento** - Gerencia os horários marcados
4. **Pagamento** - Registra os pagamentos
5. **Produto** - Gerencia o estoque

## Classes do Backend
As principais classes do backend incluem:

- **Usuario** (Clientes e Barbeiros)
- **Servico** (Cortes, barba, etc.)
- **Agendamento** (Ligação entre cliente, barbeiro e serviço)
- **Pagamento** (Gerenciamento financeiro)

Este projeto será desenvolvido seguindo as melhores práticas de **arquitetura MVC** e utilizando **RESTful APIs** para comunicação entre frontend e backend.

