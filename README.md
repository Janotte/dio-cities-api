# Cities API
<p align="center">
  <a href="https://github.com/Janotte/dio-cities-api#about">About</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="https://github.com/Janotte/dio-cities-api#requirements">Requirements</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="https://github.com/Janotte/dio-cities-api#clone">Clone</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="https://github.com/Janotte/dio-cities-api#database">Database</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="https://github.com/Janotte/dio-cities-api#api">API</a>
</p>


---

## About

In this project, a **API REST** with **Spring Boot** was developed, a small system to consult the countries and nations, states and cities of Brazil and calculate the distance between two Brazilian cities.

---

## Requirements

The following technologies were developed and used in this project.

- Microsoft Windows
- Java 11 or higher versions.
- Git
- Docker
- An IDE of your choice like IntelliJ Community, Eclipse Community or Spring Tool Suite 4.
- Postman

---

## Clone

```bash
# Clone project
$ git clone https://github.com/Janotte/dio-cities-api

#  Enter the project
$ cd dio-cities-api
```

---

## Database

 1. Follow these instructions to install Docker on Windows:

    ​	:whale: [Docker](https://docs.docker.com/docker-for-windows/install/)

    

 2. Getting required images, go to  the Windows command line prompt and execute:

    ```basic
    docker pull postgres
    docker pull dpage/pgadmin4
    ```

    

 3. Listing the existing images in your Docker:

    ```basic
    docker images
    ```

    ![image-20210228160227261.png](./img/image-20210228160227261.png)

 4. Creating a network to execute the containers.

    ```basic
    docker network create --driver bridge postgres-network
    ```

    ![image-20210228160640236](./img/image-20210228160640236.png)

 5. Creating folders for Docker volumes and copy scripts

    ```basic
    cd\
    mkdir data
    cd data
    copy C:\Dados\Projetos\dio-cities-api\data\*.sql
    ```

    ![image-20210228160833209](./img/image-20210228160833209.png)

 6. Creating a container to run a PostgresSQL.

    ```basic
    docker run --name postgres-server --network=postgres-network -e "POSTGRES_PASSWORD=Your_Password" -p 5432:5432 -v c:\postgresdb\data:/data -d -e "POSTGRES_DB=cities" postgres
    ```

    ![image-20210228153533673](./img/image-20210228153533673.png)

    

 7. Listing the container instances.

    ```basic
    docker ps
    ```

    ![image-20210228153644240](./img/image-20210228153644240.png)

 8. Geting inside the postgres docker container.

    ```basic
    docker exec -it postgres-server bash
    ```

    ![image-20210228153751876](./img/image-20210228153751876.png)

 9. Populating the cities database.

    ```basic
    cd data
    psql -h 127.0.0.1 -d cities -U postgres -f country.sql
    psql -h 127.0.0.1 -d cities -U postgres -f state.sql
    psql -h 127.0.0.1 -d cities -U postgres -f city.sql
    psql -h 127.0.0.1 -d cities -U postgres -f extension.sql
    ```

    ![image-20210228154009429](./img/image-20210228154009429.png)

    ![image-20210228154115770](./img/image-20210228154115770.png)

    ![image-20210228154211353](./img/image-20210228154211353.png)

    ![image-20210228154251048](./img/image-20210228154251048.png)

 10. Listing all databases for postgres user.

     ```basic
     psql -U postgres -l
     ```

     ![image-20210228154359235](./img/image-20210228154359235.png)

 11. Choosing the relevant db we want to use.

     ```basic
     psql -U postgres -d cities
     ```

     ![image-20210228154446850](./img/image-20210228154446850.png)

 12. Geting all the tables of this database using command /d.

     ```basic
     \d
     ```

     ![image-20210228154532435](./img/image-20210228154532435.png)

 13. Viewing the schema of a specific table.

     ```basic
     \d country
     ```

     ![image-20210228151200837](./img/image-20210228151200837.png)

 14. Calculating the distance between two cities using the Point method.

     ```basic
     select ((select lat_lon from city where id = 4929) <@> (select lat_lon from city where id=5254)) as distance;
     ```

     ![image-20210228151353036](./img/image-20210228151353036.png)

 15. Calculating the distance between two cities using the Cube method.

     ```basic
     select earth_distance(ll_to_earth(-21.95840072631836,-47.98820114135742), ll_to_earth(-22.01740074157715,-47.88600158691406)) as distance;
     ```

     ![image-20210228151458181](./img/image-20210228151458181.png)

 16. Quiting the SQL terminal.

     ```basic
     Ctrl + d
     exit
     ```

     ![image-20210228154653407](./img/image-20210228154653407.png)

---

 ## API

To run the project on the terminal, enter the following command:

```
java -jar cities-api-0.0.1-SNAPSHOT.jar
```

![image-20210228164439580](./img/image-20210228164439580.png)


To run the tests with Postman, import the cities collection.

![image-20210228165105062](./img/image-20210228165105062.png)

---

<h3 align="center">
  Desenvolvido por Sandro André Janotte
  <br/>

  <a align="center">

   [![Linkedin](https://i.stack.imgur.com/gVE0j.png) LinkedIn](https://www.linkedin.com/in/sandro-andr%C3%A9-janotte-2b022450/)
&nbsp;
  [![GitHub](https://i.stack.imgur.com/tskMh.png) GitHub](https://github.com/janotte)
  </a>
</h3>

---