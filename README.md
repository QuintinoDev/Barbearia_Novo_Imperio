# Sistema de Barbearia

## Visão Geral
Este projeto é um sistema de gerenciamento para uma barbearia, permitindo que clientes agendem serviços, barbeiros gerenciem seus horários e administradores acompanhem o faturamento e estoque.

## Tecnologias Utilizadas

### Backend
- ![Java](https://upload.wikimedia.org/wikipedia/en/3/30/Java_programming_language_logo.svg) **Java (Spring Boot)** - Framework para desenvolvimento do backend
- ![Spring Boot](https://spring.io/img/spring.svg) **Spring Boot** - Gerenciamento de APIs REST e injeção de dependências
- ![MySQL](https://upload.wikimedia.org/wikipedia/commons/0/0a/MySQL_textlogo.svg) **MySQL** - Banco de dados relacional
- ![Hibernate](https://hibernate.org/images/hibernate-logo.svg) **Hibernate** - ORM para gerenciamento do banco de dados
- ![JWT](https://jwt.io/img/pic_logo.svg) **JWT** - Autenticação e segurança dos usuários

### Frontend
- ![Angular](https://angular.io/assets/images/logos/angular/angular.svg) **Angular** - Interface gráfica do usuário
- ![TypeScript](https://upload.wikimedia.org/wikipedia/commons/4/4c/Typescript_logo_2020.svg) **TypeScript** - Linguagem utilizada no Angular
- ![Bootstrap](https://upload.wikimedia.org/wikipedia/commons/b/b2/Bootstrap_logo.svg) **Bootstrap** - Estilização e responsividade

### Outras Ferramentas
- ![Git](https://git-scm.com/images/logos/downloads/Git-Icon-1788C.svg) **Git & GitHub** - Controle de versão
- ![Postman](https://www.postman.com/img/v2/logo-glyph.png) **Postman** - Testes de API
- ![Docker](https://www.docker.com/wp-content/uploads/2022/03/Docker-Logo-White-RGB_Horizontal-730x189-1.png) **Docker** - Containerização do ambiente

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

