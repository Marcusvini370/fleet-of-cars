<h1 align="center"> API - Frota de Carros </h1>
<p align="center">Sistema de Gestão de uma frota de carros com crud e regras de négocio, a api foi feita com spring boot 2.6.2 no backend,
o projeto tem tratamento de exceções, dto, paginação, documentação com swagger, flyway, spring security entre outros.</p>

<br>

## <h2 align="center">Endpoints do projeto documentados no OpenApi!</h2>

A documentação da api pode ser acessada pelo seguinte site: https://api-fleet-of-cars.herokuapp.com/swagger-ui/index.html .

<strong>Obs:</strong> Segue os dados do usuário para autenticação - <strong>Login: </strong> admin , <strong>Senha: </strong>fleetmg@!


![swag](https://user-images.githubusercontent.com/51136557/185996094-ce069f1b-2299-4ebc-9263-29388feb4ef9.png)

## <h2 align="center">Autenticação pela documentação OpenApi</h2>

![Animação](https://user-images.githubusercontent.com/51136557/186007367-cf6dca45-ab79-4396-9a4c-00ced1cb08ab.gif)

<br>


## <h2 align="center">Demonstração da API</h2>

![Animação-min](https://user-images.githubusercontent.com/51136557/186000594-3814a92c-695c-47e4-838d-5ad191d1eee5.gif)

<br>


## 🚀 Tecnologias
- Spring Boot 2.6.2
- jdk 17
- JPA
- PostgreSQL
- Spring Security
- OpenApi
- ModelMapper
- FlyWay

<br>

## 💻 Instalção do projeto

#### O primeiro passo é fazer o clone do projeto no seu ambiente local:

```bash
git clone https://github.com/Marcusvini370/fleet-of-cars.git
```

#### Backend

Depois que o projeto foi clonado no seu ambiente, importe o projeto back-end para sua ide como o intelij, sts ou outra, instale as dependências nele, após isso é necessário criar um banco de dados no postgreSQL com o nome car-manager, após isso é só rodar ele na ide de preferência que estará funcionando.

<strong>Obs:</strong> o nome do banco de dados pode ser alterado no arquivo application.properties para o de preferência se preferir.

Link da api hospedada no heroku:

```bash
https://api-fleet-of-cars.herokuapp.com/
```
