# Desafio Técnico - API para gerenciar as sessões de votação das assembleias

Camada de *backend* feita em Spring Boot.

Este projeto tem a finalidade de **facilitar** e **agilizar** o processo de sessão de votação e apuração dos resultados durante às assembleias realizadas pelas cooperativas.

## Requisitos de Negócio 
  - Cadastrar uma nova pauta;
  - Abrir uma sessão de votação em uma pauta (a sessão  de votação deve ficar aberta por um tempo
determinado na chamada de abertura ou 1 minuto por default);
  - Receber votos dos associados em pautas (os votos são apenas 'Sim'/'Não'. Cada associado  é
identificado por um id único e pode votar apenas uma vez por pauta);
  - Contabilizar os votos e dar o resultado da votação na pauta.

## Tecnologias
- [JDK 11](https://www.oracle.com/technetwork/java/javase/downloads/java-archive-javase11-5116896.html)
- [Maven 3](https://maven.apache.org)
- [Lombok](https://projectlombok.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [SpringData](https://spring.io/projects/spring-data)
- [Flyway](https://flywaydb.org/)
- [Orika Mapper](http://orika-mapper.github.io/orika-docs/)
- [Swagger](https://swagger.io/)
- [PostgreSql](https://www.postgresql.org/)

### Instalação

```sh
$ git clone https://github.com/hugoan/desafio-back-votos-api.git
$ cd desafio-back-votos-api
$ mvn package
$ cd target
$ java -jar desafio-back-votos-api.jar
```