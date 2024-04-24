# POC - Testing Automation Framework for DemoBlaze

In this project we will be creating an automation framework to test several functionalities of a demo e-commerce app focused on selling technology devices like phones, monitors and laptops.

## Getting started

These instructions will guide you on how to have a copy of this proyect running on your local machine, where you will be able to run or extend the project however you see fit

### Prerequisites

* Git
* Java
* Maven

If you don't have any of these technologies installed, the following tutorials may help you: 

* Git: https://www.youtube.com/watch?v=4xqVv2lTo40
* Java: https://www.youtube.com/watch?v=BG2OSaxWX4E
* Maven: https://www.youtube.com/watch?v=1QfiyR_PWxU

### Installing the project

To create a local copy of the project, you will need to open up your git terminal, then go to the directory you want the app to be located, and use the following command 

```
git clone https://github.com/DanielOchoa1214/DemoBlazeAutomation.git
```

Luego muevete al directorio creado y desde ahi ejecuta los siguientes comandos
Then go the root of the cloned project and from there execute the following command

```
mvn clean test
```

And if everything went well you should see in console the following output

![Screenshot 2024-04-24 085530](https://github.com/DanielOchoa1214/DemoBlazeAutomation/assets/77862016/31c88ba4-e870-47cd-88ef-47ba048f497a)

And to see some detailed test reports, you can open up either one of the following files:

```
reports/report.html
```

![image](https://github.com/DanielOchoa1214/DemoBlazeAutomation/assets/77862016/c73cd823-eb67-4b64-8f5c-d0fa3c7dcfe3)
![image](https://github.com/DanielOchoa1214/DemoBlazeAutomation/assets/77862016/696f9d04-67f1-41f5-a7d0-54687f8a96b3)

```
target/surefire-reports/index.html
```

![image](https://github.com/DanielOchoa1214/DemoBlazeAutomation/assets/77862016/2bf2b894-0cba-4eb7-915b-f32953407db7)

## Build with

* Love
* [Maven](https://maven.apache.org/) - Dependency administrator
* [IntelliJ IDEA](https://www.jetbrains.com/es-es/idea/) - Development IDE

## Version

1.0-SNAPSHOT

## Authors

* Daniel Ochoa - [DanielOchoa1214](https://github.com/DanielOchoa1214)
* Rafael Zúñiga - [Kiloren19](https://github.com/Kiloren19)
* Jenson Pérez - [Jenson-08](https://github.com/Jenson-08)

## Licence

GNU General Public License family

## Acknowledgments

* To the best Scrum Master we could ask for *Andres Novoa*
* Figo, mi beautiful dog
