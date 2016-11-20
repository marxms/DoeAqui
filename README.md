# Configurações

## Banco de Dados

* SGBD: MySQL
* Criar um banco de dados:
```sql
  CREATE DATABASE db_doe_aqui;
```
* User: "root"
* password: ""

## Importar Projeto

* Fazer clone deste repositório através do git
```bash
  git clone https://github.com/camilasantiago/SistemaAcademico.git
```
* Importar projeto no eclipse com a opção "Projects from git";
* Em "Select Repository Source" escolher "Existing local repository";
* Em "Select a Git Repository" escolher o repositório clonado, em geral "doe-aqui";
* Em "Select a wizard to use for importing projects" escolhar a opção "Import using the Nwe Project wizard";
* Crie um projeto "Dynamic Web Project" dentro do repositório local sem criar o arquivo "web.xml";
* Mude o projeto para "Mavem project".

# Requisitos

* Java JDK 1.8
* Eclispe Mars ou Neon
* MySQL 5.5+
* Apache Tomcat 8.0.37
