# User flow

* Controller --> Service --> DAO

# Setup database

**Create Docker Postgres container**

* docker run --name postgres-spring -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:alpine

**Connect Container**

* docker exec -it *CONTAINER ID* bin/bash
* psql -U postgres
* \l

**Create database**
* CREATE DATABASE ogsdb;

**Connect database and find relations**
* \c ogsdb
* \d

**Create Extension UUID**
* CREATE EXTENSION "uuid-ossp"

**Insert record**
* INSERT INTO person (id, name) VALUES (uuid_generate_v4(), 'Rick Schuurman');






