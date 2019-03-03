# spring-lib-example
A simple example for create lib for Spring application with repository, service &amp; controller

Petit exemple afin de répondre à la problématique suivante : 

* Intégration d'une librairie (jar) exposant une API REST, avec un package différent des applications intégrant cette lib
* Intégration d'une librairie (jar) exposant une API REST, un service, un repository et une entité (exemple avec un... mais cela fonctionne aussi avec plusieurs)

Pour cela j'ai créer deux lib (`library` et `libdata`) afin de répondre à ces deux questions.

Le tout pour une application `Spring`.

---

### 1 pom.xml

Tout d'abord, il faut déclarer les dépendances correcte pour un environement `Spring`.

En premier lieu, pensez a declarer votre version de `Spring`, cela sera plus propre.

```xml
<properties>
    ...
    <spring.boot.version>2.1.3.RELEASE</spring.boot.version>
    ...
</properties>
``` 

Puis declarer le dependance lié, ce ne sont pas les dependances que vous allez utiliser, mas celles qui permettront de définir celle que vous utiliserez.

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-dependencies</artifactId>
            <version>${spring.boot.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot</artifactId>
            <version>${spring.boot.version}</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-autoconfigure</artifactId>
            <version>${spring.boot.version}</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

A priori, seule la première est importante, car elle fixe les dependances `SpringBoot` disponible et leur version.

Et c'est tout pour la configuration de votre projet.

### 2 Injection des beans de la librairie

Vous ne pouvez decement pas déclarer le scan de composant dans les packages de votre lib au niveau de l'application,
c'est tordu et non élégant.

Le principe est simple, vous allez créer une annotation, qui via les métadata (annotation d'initialisation d'une annotation),
va forcer l'import d'une classe de configuration (au sens `Spring` du terme) : 

```java
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(LibDataConfiguration.class)
public @interface EnableLibData {
}
```

C'est l'annotation `@Import` qui est chargé de cet appel.
Et c'est aussi simple que cela en ce qui concerne la base de notre annotation.

Regardons ce qui se passe maintenant au niveau de la classe de configuration.
Nous allons aussi utiliser des annotations de configuration Spring : 

```java
@Configuration
@ComponentScan("org.shipstone.sandbox.springlib.libdata")
@EntityScan(basePackageClasses = { Message.class })
@EnableJpaRepositories(basePackageClasses = { MessageRepository.class })
public class LibDataConfiguration {
}
```

En premier lieu, nous délcarons notre classe comme bean de configuration via l'annotation `@Configuration`.

Puis, via l'annotation `@ComponentScan`, nous lançons le scan du repertoire de base de notre librairie afin de recensser les beans.
***Attention***, cela fonctionne pour les Controller et les bean simple, mais cela ne prend pas en compte les entités et les repository (data).

Le recensement des entité (`JPA`) est assuré par l'annotation `@EntityScan`.
Dans notre exemple, j'ai indiqué une classe, mais on peut comme pour l'annotation précédente utiliser le package sous forme de String.

Et les repository (`JPA`) sont pris en charge par l'annotation `@EnableJpaRepositories`, avec la même remarque que précédement.

Et voilà, votre librairie permet l'exposition d'un controller REST qui fait appel à un service, qui lui même utilise un repository permettant de recupérer des entité issue d'une couche de persistance.
Couche de persistance déclarée par l'application utilisant la librairie.

### 3 Utilisation de la librairie.

Pour utiliser la librairie au niveau de votre application, rien de plus simple :)

Déclaration de la dépendance : 

```xml
<dependency>
    <groupId>org.shipstone.sandbox.springlib</groupId>
    <artifactId>lib-data</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

et ajout de l'annotation de votre librairie sur la classe de l'application : 

```java
@SpringBootApplication
@EnableLibData
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}

```

*Et le tour est joué !*

Pour le test (utilisation de HTTPie) :
```
http :8080/api/lib-data/messages
```
et 
```
http :8080/api/lib-data/messages/TOT
```
