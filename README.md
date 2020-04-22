# hibernate-mapsid-test

### Description
This project demonstrate an issue when using @MapsId of Hibernate.

Domain entity SimpleAddress is a simple entity that uses to show no 
problem when use @MapsId to create it.

In contrasts,HomeAddress is a domain entity that extends from AbsAddress
which has an annotation @Inheritance. It seems @MapsId can not work in 
this situation when creating the HomeAddress domain.

### How to
- start the springboot project
- make an http request to http://localhost:8080/simpleAddress to show 
  SimpleAddress will be created Ok.
- make an http request to http://localhost:8080/homeAddress to show
  HomeAddress will be created fail,then see the Exception message from console, looks like 
  > Referential integrity constraint violation: "FKLBPS9IRLE6VWEQXXGWG1MRXGQ: PUBLIC.HOME_ADDRESS FOREIGN KEY(ID) REFERENCES PUBLIC.USER(ID) (3)";
  
