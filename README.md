RESTfulLDAP
==================

. simple sample learning RESTful connecting our Active Directory Windows (LDAP)
  This guide walks you through the process of creating a "LDAP" RESTful web service with Spring.

. You’ll build a service that will accept HTTP GET requests at:
  http://localhost:8080/restful

. You can customize the restful with an optional name parameter in the query string:
  http://localhost:8080/restful/services/userlogin


. The userid parameter value and password parameter value is reflected in the response:
  [{"retval":0,"username":"out342","password":"pwd1234A","message":"Successfull to validate LDAP"}]

What you’ll need:
-----------------------
. A favorite text editor or IDE
. JDK 1.7 or later
. Maven 3.0+

Build with Maven:
-----------------------
. Create the directory structure :

└── src
    └── main
        └── java
            └── com
                └── beliapalagi
                    └── restful
                        └── object
                        └── service
                        └── util
                        
. pom.xml :
------------------------

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.beliapalagi.restful</groupId>
    <artifactId>restful</artifactId>
    <version>1.0</version>
    <packaging>war</packaging>
    <name>restful</name>
    
    <developers>
        <developer>
            <id>chedoxtop</id>
            <name>Pratama Rendra</name>
            <email>chedoxtop@gmail.com</email>
            <organization>beliapalagi.com</organization>
        </developer>
    </developers>

    <properties>
        <endorsed.dir>${project.build.directory}/endorsed</endorsed.dir>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.1</version>
                <configuration>
                    <source>1.7</source>
                    <target>1.7</target>
                    <proc>none</proc>
                </configuration>
            </plugin>
        </plugins>   
    </build>
    
    <repositories>        
        <repository>
            <id>codelds</id>
            <url>https://code.lds.org/nexus/content/groups/main-repo</url>
        </repository>
    </repositories>
    
    <dependencies>
        <dependency>
            <groupId>org.eclipse.persistence</groupId>
            <artifactId>eclipselink</artifactId>
            <version>2.5.1</version>
        </dependency>
        
        <dependency>
            <groupId>org.eclipse.persistence</groupId>
            <artifactId>org.eclipse.persistence.jpa.modelgen.processor</artifactId>
            <version>2.5.1</version>
            <scope>provided</scope>
        </dependency>
        
        <dependency>
            <groupId>javax</groupId>
            <artifactId>javaee-web-api</artifactId>
            <version>6.0</version>
            <scope>provided</scope>
        </dependency>
        
        <dependency>
            <groupId>org.codehaus.jackson</groupId>
            <artifactId>jackson-core-asl</artifactId>
            <version>1.9.7</version>
        </dependency>

        <dependency>
            <groupId>org.codehaus.jackson</groupId>
            <artifactId>jackson-mapper-asl</artifactId>
            <version>1.9.7</version>
        </dependency>

        <dependency>
            <groupId>org.apache.tomcat</groupId>
            <artifactId>servlet-api</artifactId>
            <version>6.0.35</version>
        </dependency>

        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-commons-annotations</artifactId>
            <version>3.2.0.Final</version>
        </dependency>

        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-entitymanager</artifactId>
            <version>3.5.6-Final</version>
        </dependency>

        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>3.5.6-Final</version>
        </dependency>

        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-annotations</artifactId>
            <version>3.5.6-Final</version>
        </dependency>

        <dependency>
            <groupId>jstl</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-tx</artifactId>
            <version>3.0.5.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>3.0.5.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-orm</artifactId>
            <version>3.1.1.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-asm</artifactId>
            <version>3.1.1.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.6.4</version>
        </dependency>

        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>jcl-over-slf4j</artifactId>
            <version>1.6.2</version>
        </dependency>
  
        <dependency>
            <groupId>com.oracle</groupId>
            <artifactId>ojdbc14</artifactId>
            <version>10.2.0.3</version>
        </dependency>
        
    </dependencies>

</project>

                        
            

