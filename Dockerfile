FROM java:openjdk-8-alpine


WORKDIR /app


COPY ./target/micro-servico-consultalivros.jar /app/micro-servico-consultalivros.jar

EXPOSE 8181
CMD java -jar /app/micro-servico-consultalivros.jar
