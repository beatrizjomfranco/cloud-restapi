# cloud-restapi
# Realizando Deploy na Nuvem de um Conjunto de API’s Desenvolvida em Spring Boot

Reprodução da solução guiada pelo especialista da DIO com o intuito de construir uma API para controle de um estacionamento de veículos

Os códigos em java foram criados através da IDE VSCode

# Objetivo Específico
Controlar a entrada e saída de veículos
Cadastrar os dados de cada veículo num banco de dados relacional
Criar controle de acesso da API nas nuvens

# Requisitos:
Cliente é o automóvel.
Usuário é o operador do estacionamento.

# Dados:
Placa, modelo e cor.
Data e hora de entrada.
Calcular o valor do checkout.

# Etapas de Desenvolvimento da API


## 1. Criar o projeto Java com Spring Boot
1. Criar o projeto java com Spring Boot 
1.1 Acessar https://start.spring.io/

------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## 1.1 Conceito de Spring Initializr
Para facilitar a criação de APIs utilizando outras IDEs, a Spring disponibilizou o Spring Initializr. Spring Initializr é uma UI (User Interface) que permite a criação de projetos Sprint Boot de forma facilitada. 
Através desta UI definimos nome do projeto, pacotes, dependências (starters do spring e outros projetos), linguagem (Java, Groovy ou Kotlin). Uma vez definido é só clicar no botão Generate e o projeto será criado, gerando um zip pronto para ser importado na IDE de sua preferência.
Fonte: https://www.zup.com.br/blog/spring-boot
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

## 1.2 Dados do Initializr
Project: Marven
Language: Java
Spring Boot: 2.7.5
Group:br.bootcamp
Artifact: cloud-restapi
Name:cloud-restapi
Description: realizando Deploy na Nuvem de um Conjunto de API’s Desenvolvida em Spring Boot
Package: br.bootcamp.cloud-restapi
Java: 11

Generate--> Extrair arquivo zipado --> abrir na IDE VSCode
------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## 1.3 Estrutura do arquivo pom.xml

spring-boot-starter-web --> Auxilia na construção de aplicações web trazendo já disponíveis para uso Spring MVC, Rest e o Tomcat como servidor.

spring-boot-devtools --> É um conjunto de funcionalidades que ajuda o trabalho de qualquer dev. Como, por exemplo, restart automático da aplicação quando ocorre alguma mudança no código.

org.modelmapper --> Mapeando Objeto para Objeto com ModelMapper

springfox-swagger2 --> Swagger2 é um projeto de código aberto usado para gerar os documentos da API REST para serviços da Web RESTful.

springfox-swagger-ui --> para interagir com a configuração, também é necessário adicionar a dependência que fornece o Swagger UI:

spring-boot-starter-data-jpa --> O Spring Data JPA é uma framework que faz parte do conjunto de projetos do Spring Data que tem como finalidade tornar a integração de aplicações Spring com a JPA (Java Persistence API), uma de suas principais vantagens é a capacidade que o mesmo possui para criar a camada de acesso aos dados sem a necessidade de termos que implementar manualmente as famosas classes de DAO (Data Access Object).

org.postgresql --> O PostgreSQL é um sistema de banco de dados objeto-relacional que tem as características de sistemas de bancos de dados comerciais tradicionais com melhoramentos encontrados nos sistemas SGBDs de próxima geração. PostgreSQL é livre e o código-fonte completo está disponível.

spring-boot-starter-security --> Spring Security é um framework do projeto Spring que possui um sistema de autenticação e autorização de alto nível e altamente customizável para aplicações Java.

io.rest-assured --> Rest-Assured é uma ferramenta que foi desenvolvida para facilitar a criação de testes automatizados para APIs REST.

Spring Boot Starter Test: Contém a maioria das dependências necessárias para realizar testes da sua aplicação: Junit, AssertJ, Hamcrest, Mockito, entre outros.

org.testcontainers --> é uma biblioteca Java que permite subir instâncias docker durantes o ciclo de testes.

spring-boot-maven-plugin --> plugin para gerar o arquivo .jar

Fonte: https://www.zup.com.br/blog/spring-boot
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

## 2. src --> main --> java\one\bootcamp

CloudRestapiApplication.java

Rodar para montar a aplicação que será desenvolvida

CloudRestapiApplication fará todas as injeções de dependência para poder rodar a aplicação.

Startou o Tomcat na porta 8080 --> 2022-11-14 14:56:11.727  INFO 8560 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path

Para verificar abrir o navegador e digital http://localhost:8080/

A seguinte página retornará: Whitelabel Error Page
This application has no explicit mapping for /error, so you are seeing this as a fallback.
Mon Nov 14 15:13:27 BRT 2022
There was an unexpected error (type=Not Found, status=404).
No message available
----------------------------------------------------------------------
## 4 Criar uma conta no Heroku
Ir me create new app
app name: bootcamp
choose a region: United State
create a new pipeline, onde será feito o build e o deployment
name the pipeline: bootcamp
Choose a stage to add this app to: production
Clicar no botão create app

## 4.1 ir em open app para visualizar a página:
https://bootcamp.herokuapp.com/
Heroku | Welcome to your new app!

## 4.2 Conectar a conta do Heroku com a do Github
Escolher o repositorio cloud-spring para se conectar
Habilitar: enable automatic deploys
Choose a branch to deploy: master e clique em deploy branch
Deu push failed
Ir para overview
open app --> documentation --> java
-----> Building on the Heroku-22 stack
-----> Determining which buildpack to use for this app
 !     No default language could be detected for this app.
			HINT: This occurs when Heroku cannot detect the buildpack to use for this application automatically.
			See https://devcenter.heroku.com/articles/buildpacks
 !     Push failed
-----------------------------------------------------------
#### O que são buildpacks?
Buildpacks are responsible for transforming deployed code into a slug, which can then be executed on a dyno. Buildpacks are composed of a set of scripts, and depending on the programming language, the scripts will retrieve dependencies, output generated assets or compiled code, and more. This output is assembled into a slug by the slug compiler.

Heroku’s support for Ruby, Python, Java, Clojure, Node.js, Scala, Go and PHP is implemented via a set of open source buildpacks.
fonte: https://devcenter.heroku.com/articles/buildpacks

## 4.3 Para sanar esse problema, vá na ide e na raiz (cloud-restapi) crie um arquivo system.properties e defina a versão java a qual se está trabalhando
java.runtime.version=11

fazer o commit para atualizar do repo no github

## Pacotes e classes construídas
pacote config --> classes: SecurityConfig.java e SwaggerConfig.java

pacote controller:
classes HelloController.java e ParkingController.java
pacote dto--> classes ParkingCreateDTO.java e ParkingDTO.java
pacote mapper-->ParkingMapper.java

pacote exception: classe ParkingNotFoundException.java

pacote model --> classe Parking.java

pacote repository --> interface ParkingRepo

pacote service --> classes ParkingCheckout.java e ParkingService.java
------------------------------------------------------



