# social

# Developer Info

Login feature used okta's OIDC based authentication. Hence you need to create a dev account with Okta and keep a note of your "yourOktaDomainUrl", "clientId" and "clientSecret". These details have to be passed as params to run the application.

## Build
```mvn clean package```

## Running application

### Maven
```mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dspring.security.oauth2.client.provider.okta.issuer-uri='{yourOktaDomainUrl}' -Dspring.security.oauth2.client.registration.okta.client-id='{clientId}' -Dspring.security.oauth2.client.registration.okta.client-secret='{clientSecret}'"```
### Docker
#### start application

```export OKTA_DOMAIN_URL={yourOktaDomainUrl}```

```export CLIENT_ID={clientId}```

```export CLIENT_SECRET={clientSecret}```

```docker-compose up -d --build```

```docker-compose up -d --build```
#### stop application
```docker-compose down```
