
# HOW TO BE PRODUCTIVE WITH SPRING BOOT.

https://www.youtube.com/watch?v=oZJ91pWBWpQ

* GETTING STARTED
    Dependency Management / Starters /Start.spring.io

* DEVELOPMENT-TIME
    Devtools / Auto-configuration report /configuration properties /testing

* PRODUCTION
    Actualtor endpoints

How to avoide making projects complicated and how to reduce the time requied for development.


## GETTING STARTED

Spring boot start with pom file for maven .


### PAREMT POM (Uncompatible Dependency issues in pom file)

 If you use spring boot paretn dependency, it will remove hazzle you want to find out compatible spring boot dependency packages. So manually giving dependency version is not good.

 So better to use PARENT POM. It will give you all the manage dependency and it will give you default dependencies requied for th applications. So it is highly recomand to use parent pom.

 Followign features are activated with parent pom.

 1. Dependency Managment
 2. JAva Level 1.8 is default but if you want 
 3. Sensible Plugins 
 4. Resource Filtering


![Spring Boot Parent pom](parent.PNG?raw=true "PARENT POM")

When you have the parent pom all other spring spring dependencies are not reqired to mention those versions.

#### Dependency Management with Parent pom

![Spring Boot Parent pom](images/dependency.PNG?raw=true "DEPENDENCY MANAGEMENT")