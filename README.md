# Task Phone Validation 
#### this is the phone faildation task
to run 
```console
cd phone-validation
./mvnw spring-boot:run

```

to create docker image
```console
cd phone-validation
./mvnw spring-boot:build-image

docker run -p 8080:8080 --name phone-val docker.io/library/phone-validation:0.0.1-SNAPSHOT

```

