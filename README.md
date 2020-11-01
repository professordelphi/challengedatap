# challengedatap
Challenge - Java (task about selection)

System Crud - Customer

FindAll (get)
 http://localhost:8080/api/v1

Find by Id (get)
  http://localhost:8080/api/v1/1
  
     Example:
     http://localhost:8080/api/v1/1
  
Save (post)
  http://localhost:8080/api/v1
  
  {"name":"Luciana","cpf":"77441122551","address":"Rua Marangua 14"}
  


Update (put)
  http://localhost:8080/api/v1
  
  {"id":1,"name":"Luciana","cpf":"77441122551","address":"Rua Marangua 14"}

Delete (delete)

http://localhost:8080/api/v1/1
  
     Example:
     http://localhost:8080/api/v1/1
     
     
  Podendo ser testado também no HEROKU.COM
  You may test this api in Heroku.com
  https://challengdata.herokuapp.com/api/v1
    
  If you want, you can test with Swagger-ui.html
  https://challengdata.herokuapp.com/swagger-ui.html
  
  #Utilização do DOCKER
  
  Arquivo Dockerfile (no mesmo diretório do .gitignore) com o seguinte conteúdo:
  
FROM openjdk
WORKDIR /app

COPY target/dataprev.jar /app/spring-app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "spring-app.jar"]

---------------------------------------------
Comandos Docker:

docker build -t dataprev:1.0 .
docker run -p 8084:8080 dataprev:1.0


  
  
  
