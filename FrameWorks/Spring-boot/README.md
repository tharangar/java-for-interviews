
# HOW TO BE PRODUCTIVE WITH SPRING BOOT.

https://www.youtube.com/watch?v=oZJ91pWBWpQ

* GETTING STARTED
    Dependency Management / Starters /Start.spring.io

* DEVELOPMENT-TIME
    Devtools / Auto-configuration report /configuration properties /testing

* PRODUCTION
    Actualtor endpoints

How to avoide making projects complicated and how to reduce the time requied for development.


# GETTING STARTED

Spring boot start with pom file for maven .


### PAREMT POM (Uncompatible Dependency issues in pom file)

 If you use spring boot paretn dependency, it will remove hazzle you want to find out compatible spring boot dependency packages. So manually giving dependency version is not good.

 So better to use PARENT POM. It will give you all the manage dependency and it will give you default dependencies requied for th applications. So it is highly recomand to use parent pom.

 Followign features are activated with parent pom.

 1. Dependency Managment
 2. JAva Level 1.8 is default but if you want 
 3. Sensible Plugins 
 4. Resource Filtering


![Spring Boot Parent pom](images/parent.PNG?raw=true "PARENT POM")

When you have the parent pom which version defined for spring boot, all other spring spring dependencies are not reqired to mention those versions.

#### Dependency Management with Parent pom

![Spring Boot Parent pom](images/dependency.PNG?raw=true "DEPENDENCY MANAGEMENT")


## STARTERS

STARTERS is another good concept which we can use minimum of lines in pom.xml file. Starter is set of dependencies which can be used for various objectives.
Ex : spring-boot-starter-web, spring-boot-starter-security

![Spring Boot Starter](images/starter.PNG?raw=true "DEPENDENCY MANAGEMENT")

* ONE-STOP SHOP FOR A SET OF DEPENDENCIES
    You can use a starter instead of a bundle of dependencies which are requeid for specific perposes.
* NO COPY /PASTE FOR COMMON USE-CASES
    Starters are created to user for specific use cases. Ex for security, web application etc
* STARTERS ARE MANGED DEPENDENCIES.
    So dont need to define versions.
* COMMUNITY STARTERS.
    There are community created starters. It can be found from pivotal github page listed under starters.

## START.SPRING.IO

www.start.spring.io web site is a spring boot application generator with any dependency and version .  You can check the application structure before generate using Explore option.


# DEVELOPMENT TIME

## DEVTOOLS


![Spring Boot Devtools](images/devtools.PNG?raw=true "DEVTOOLS")

Spring boot dev tool a nice tool which helps you to run the  application while you are codeing. Once you done the chagnes when you save code it will check your class path and when their is a a change automatically build and re run the application. Make sure <optional> true </optional> it will ignore same dependency imported early. (May be from starters).

Following are the summary what devtool does in your application.

* Automatic restart
    project web server restart
* condition evaluation delta
    Interceptors linke handler interceptor.
* sensible property defaults
    you can change prod, local and testing environments using varials property files.
* live reload for static resources
    if you change static resouce it will load without restarting the applicaiton.


## TROUBLE SHOOT AUTO CONFIGURATION

1. By turning --DBUG ON you will receive CONDITION EVALUATION REPORT .

2. You can see CONDITIONS ENDPOINT from Actuator also.

3. USE THE SOURCE
    * *AutoConfiguration
    * @Conditional*


## CONFIGURATION PROPERTIES

Before configuration properties it was used @Value anotation for this porpose.
Ex : 
```
@Value("${relasenotes.github.repositoyr:spring-progject}")
private String organization;
```

But this is not good when the property is complecated and when there is hiracical properties.

Now you can have @ConfigurationProperties which is more sopisticated.

ex : 

You can define your configuration properties as classes.
You can have nested properites also in this files. we can inject these beans for any componetn.

![Spring Boot Configuration Property injection](images/configurationPropery.PNG?raw=true "CONFIGURATION PROPERTY")

How to use the configuration property in components.

![Spring Boot Configuration property injection](images/component.PNG?raw=true "CONFIGURATION PROPERTY INJECTION TO COMPONENTS")

with spring boot 2.2 you can use as above. but for early version you have to enable Configuraiton propeties as bellow.

@EnableConfigurationProperties(RelaseNotesProperties.class)

![Spring Boot Enable Configuration property ](images/enablecp.PNG?raw=true "CONFIGURATION PROPERTY ENABLE before spring 2.2")

In future relases it will add 

@ConfigurationPropertiesScan 

anotation which will automatically identified all Configuration Properties.

#### FEATURES OF CONFIGIRATION PROPERTIES.

* @Value(${"property"}) are tedious
* JSR-303 Validation
    we can use validation like notnull, notblank etc
* AUTO-COMPLETION
    Following dependency will enable auto completion for configuration properties.
![Spring Boot Enable Configuration property Autocompletion ](images/autocompletion.PNG?raw=true "CONFIGURATION PROPERTY ENABLE autocompletion")
* /CONFIGPROPS ENDPOINT
*  IMMUTABLE
    Since 2.2 it will support to constructor binding. dont need setters only getters requied.

## TESTINGS

#### Slice Testing

Spring boot has a testing layer which is not a integration test and also unit test.  It is come in between.
It tests anotations provided by spring boot.

@SpringBootTest

It will load up our entire application so it is littble bit slow.
We can identify benas misconfiguration type of error . 

Video explain how to mock it and test it properly.


#### JUNIT 5 testing

Spring 2.2 comes with junit 5. 

#### TESTCONTAINERS

This is a docker container which support junit file support.


# PRODUCTION

## ACTUATOR 
Spring Boot Actuator is good production level debug tool.
Features include

### ACTUATOR ENDPOINTS

* HEALTH
* INFO
* ENVIRONMENT
* RUNTIME CONFIGURATION OF LOGGERS
* JVM THREAD DUMP

#### HEALTH ENDPOINT
* AGGREATES HEALTH INDICATORS
* CUSTOM HEALTH INDICATORS CAN BE ADDED.
* USAGE:
* AUTHENTICATED / UNAI=UTHENTICATED
* HEALTH GROUPS.

#### INFO ENDPOINT
* GIT INFORMATION
    branch/commit Id / commit time
* BUILD INFORMATION
    artifact / group /version
* CUSTOME INFO CONTRIBUTORS

#### ENV ENDPOINT
* ACCESS TO THE SPRING ENVIRONMENT
* SHOWS
* ACTIVE PROFILES.
* PROPERTY SOURCES IN THE ORDER

#### LOGGER ENDPOINT
* ACCESS TO APPLICATION LOGGERS
* UPDATE THE LOGGER CONFIGURATION AT RUN TIME.

#### THREAD DUMP ENDPOINTS
* PROVIDE A THREAD DUMP FROM THE APPLICATION's JVM
* ACCEPTS TEST/PLAIN REQUEST
* COMPATIVLE WITH following THREAD DUMP ANALIZERS.
    https://fastthread.io
    https://github.com/irockel/tda

How to activate Actuator in a project

![Spring Boot Actuator ](images/actuator.PNG?raw=true "ACTUATOR")


Enable the access through web.



![Spring Boot Actuator ](images/enableActuator.PNG?raw=true "ENABLE ACTUATOR")