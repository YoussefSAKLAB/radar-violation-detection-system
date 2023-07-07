# Radar Violation Detection System

This web-based application combines the power of Spring Boot and Angular to create a radar violation detection system. Its main purpose is to identify and monitor radar violations, ensuring timely notifications and generating reports for effective traffic management.

The backend is developed using Spring Boot, while the frontend utilizes Angular with Bootstrap to deliver a user-friendly interface.

Apart from the fundamental functionalities of data querying and modification, the system offers the capability to report speeding violations, which creates a record of the offense. Additionally, it provides vehicle owners with the convenience of viewing their personal violations, granting them quick access to their offense history.

# Table of Contents
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Technologies Used](#technologies-used)
- [Technical Architecture](#technical-architecture)
- [Class Diagram](#class-diagram)
- [Backend Services](#backend-services)
    - [Regestration Service](#regestration-service)
    - [Radar Service](#radar-service)
    - [Infraction Service](#infraction-service)
    - [Eureka Discovery Service](#eureka-discovery-service)
    - [Gateway Service](#gateway-service)
    - [Road Radar](#road-radar)
- [Frontend with Angular](#frontend-with-angular)
- [Author](#author)

## Getting Started
### Prerequisites
Before running this application, you need to have the following software installed on your system :

```java
- Java Development Kit (JDK) version 11 or later
- Node.js version 14 or later
- Angular CLI version 13 or later
- Keycloak  version 21
```
### Installation
Follow these steps to install and run the application :

1. Clone the repository :
```
git clone https://github.com/YoussefSAKLAB/radar-violation-detection-system
```
2. Navigate to the backend directory and run the following command to start the each Spring Boot project :
```
./mvnw spring-boot:run
```
3. Navigate to the frontend directory and run the following command to install the required packages :
```
npm install
```
4. After the packages are installed, run the following command to start the Angular application :
```
ng serve
```
5. Download Keycloak from the official website https://www.keycloak.org/downloads , and then navigate to keycloak/ directory and run the following command :
On MaC/Linux
```
./bin/kc.sh start-dev
```
On Windows
```
./bin/kc.bat start-dev
```
6. Open your browser and navigate to `http://localhost:4200` to access the application.
## Technologies Used
The following technologies and frameworks are used in this application:

- Spring Boot
- Spring Cloud
- Eureka Descovery
- Angular
- Bootstrap
- Spring Boot H2 Database
- Keycloak
## Functionalities
The application allows performing the following operations:
- Submit a speeding violation.
- View violations of a vehicle owner.
- Modify and view radar data.
- Modify and view vehicle and owner data.
- Modify and view infraction data.
## Technical Architecture

<img src="https://raw.githubusercontent.com/YoussefSAKLAB/radar-violation-detection-system/main/assets/radar-violation-detection-system-architecture.png">

## Class Diagram 

<img src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/radar-violation-detection-system-class-diagram.png?raw=true">

## Backend Services

The backend contains 5 services :

### Regestration Service 

```
Registration microservice manages vehicles owned by owners. Each vehicle belongs to a single owner.
An owner is defined by their ID, name, date of birth, email.
A vehicle is defined by its ID, regestration number, brand, fiscal power, and model
```
- Service Structure
<pre>

├───src
│   ├───main
│   │   ├───java
│   │   │   └───org
│   │   │       └───miaad
│   │   │           └───registrationservice
│   │   │               │   RegistrationServiceApplication.java
│   │   │               │
│   │   │               ├───config
│   │   │               │       CXFSoapWebServiceConfig.java
│   │   │               │
│   │   │               ├───dto
│   │   │               │       OwnerRequestDTO.java
│   │   │               │       OwnerResponseDTO.java
│   │   │               │       VehicleRequestDTO.java
│   │   │               │       VehiclerResponseDTO.java
│   │   │               │
│   │   │               ├───entites
│   │   │               │       Owner.java
│   │   │               │       OwnerProjection.java
│   │   │               │       Vehicle.java
│   │   │               │       VehicleProjection.java
│   │   │               │
│   │   │               ├───mappers
│   │   │               │       OwnerMapper.java
│   │   │               │       VehicleMapper.java
│   │   │               │
│   │   │               ├───repositories
│   │   │               │       OwnerRepository.java
│   │   │               │       VehicleRepository.java
│   │   │               │
│   │   │               ├───services
│   │   │               │       OwnerService.java
│   │   │               │       OwnerServiceImpl.java
│   │   │               │       VehicleService.java
│   │   │               │       VehicleServiceImpl.java
│   │   │               │
│   │   │               └───web
│   │   │                   ├───graphql
│   │   │                   │       OwnerGraphqlController.java
│   │   │                   │       VehicleGraphqlController.java
│   │   │                   │
│   │   │                   ├───grpc
│   │   │                   │   │   GrpcConfig.java
│   │   │                   │   │   OwnerGrpcService.java
│   │   │                   │   │
│   │   │                   │   └───stub
│   │   │                   │           OwnerGrpcServiceGrpc.java
│   │   │                   │           OwnerService.java
│   │   │                   │
│   │   │                   ├───rest
│   │   │                   │       OwnerRestController.java
│   │   │                   │       VehicleRestController.java
│   │   │                   │
│   │   │                   └───soap
│   │   │                           OwnerSoapService.java
│   │   │                           VehicleSoapService.java
│   │   │
│   │   └───resources
│   │       │   application.properties
│   │       │   owner-service.proto
│   │       │   xsd-schema.xsd
│   │       │
│   │       ├───graphql
│   │       │       schema.graphqls
│   │       │
│   │       ├───static
│   │       └───templates
</pre>
- Web services integration REST, GraphQL, SOAP et GRPC :

> a. REST :

Tests with `Postman`

<table>
    <tr>
        <td >
            <h5 align="center">All Vehicles</h5>
                <p align="center">
                    <img src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/RestGetVehicles.png?raw=true" alt="project example"/>
                </p>
        </td>
    </tr>
    <tr>
        <td >
            <h5 align="center">Find Vehicle By Id</h5>
                <p align="center">
                    <img src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/RestGetVehicleById.png?raw=true" alt="project example"/>
                </p>
        </td>
    </tr>
</table>

<table>
    <tr>
        <td >
            <h5 align="center">Delete Vehicle</h5>
                <p align="center">
                    <img src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/RestDeleteVehicleById.png?raw=true" alt="project example"/>
                </p>
        </td>
    </tr>
    <tr>
        <td >
            <h5 align="center">Update Vehicle</h5>
                <p align="center">
                    <img src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/RestPutVehicleById.png?raw=true" alt="project example"/>
                </p>
        </td>
    </tr>
</table>


> b. GraphQL :
Tests with `Google Chrome` or any browser can be conducted by accessing the following link:
```
http://localhost:8081/graphiql?path=/graphql
```
<table>
    <tr>
        <td>
            <h5 align="center">All Owners with specific attributes</h5>
                <p align="center">
                    <img alt="project example"
                         src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/graphqlGetOwners.png?raw=true"/>
                </p>
        </td>
    </tr>
    <tr>
        <td>
            <h5 align="center">Find Owner By Id with specific attributes</h5>
                <p align="center">
                    <img alt="project example"
                         src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/graphqlGetOwnerById.png?raw=true"/>
                </p>
        </td>
    </tr>
    <tr>
        <td>
            <h5 align="center">Add New Owner</h5>
                <p align="center">
                    <img alt="project example"
                         src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/graphqlAddNewOwner.png?raw=true"/>
                </p>
        </td>
    </tr>
    <tr>
        <td>
            <h5 align="center">Delete an Owner using their Id</h5>
                <p align="center">
                    <img alt="project example"
                         src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/graphqlDeleteOwnerById.png?raw=true"/>
                </p>
        </td>
    </tr>
</table>

> c. SOAP :

Tests with `Postman`
<table>
    <tr>
        <td >
            <h5 align="center">All Owners </h5>
                <p align="center">
                    <img src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/SoapgetVehiclesRequest.png?raw=true" alt="project example"/>
                    <img src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/Soap%20getVehiclesResponse.png?raw=true" alt="project example"/>
                </p>
        </td>
    </tr>
    <tr>
        <td >
            <h5 align="center">Find Vehicle By Id</h5>
                <p align="center">
                    <img src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/Soap%20getVehicleById.png?raw=true" alt="project example"/>
                </p>
        </td>
    </tr>
</table>

> d. GRPC :

Tests with `Postman`
<table>
    <tr>
        <td>
            <h5 align="center">All Owners</h5>
                <p align="center">
                    <img alt="project example"
                         src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/GrpcGetOwners.png?raw=true"/>
                </p>
        </td>
    </tr>
    <tr>
        <td>
            <h5 align="center">Find an Owner By Id</h5>
                <p align="center">
                    <img alt="project example"
                         src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/GrpcGetOwnerById.png?raw=true"/>
                </p>
        </td>
    </tr>
</table>


### Radar Service 

```
The radar microservice is responsible for managing radar entities. Each radar is defined by its ID, maximum speed limit, and coordinates (longitude and latitude). The microservice handles the storage and retrieval of radar data, allowing for efficient management and monitoring of radar systems.
```
- Service Structure
<pre>
├───src
│   ├───main
│   │   ├───java
│   │   │   └───org
│   │   │       └───miaad
│   │   │           └───radarservice
│   │   │               │   RadarServiceApplication.java
│   │   │               │
│   │   │               ├───entites
│   │   │               │       Radar.java
│   │   │               │
│   │   │               ├───feign
│   │   │               │       InfractionRestClient.java
│   │   │               │
│   │   │               ├───models
│   │   │               │       Infraction.java
│   │   │               │       NewData.java
│   │   │               │
│   │   │               ├───repositories
│   │   │               │       RadarRepository.java
│   │   │               │
│   │   │               └───web
│   │   │                       RadarRestController.java
│   │   │
│   │   └───resources
│   │       │   application.properties
│   │       │   radar-service.proto
│   │       │
│   │       ├───static
│   │       └───templates
</pre>

### Infraction Service 

```
The infraction microservice is responsible for managing violations. Each violation is defined by its ID, date, the radar number that detected the offense, the vehicle registration number, the vehicle's speed, the radar's maximum speed limit, and the fine amount. The microservice handles the storage and processing of violation data, enabling effective management and enforcement of traffic offenses.
```
- Service Structure
<pre>
├───src
│   ├───main
│   │   ├───java
│   │   │   └───org
│   │   │       └───miaad
│   │   │           └───infractionservice
│   │   │               │   InfractionServiceApplication.java
│   │   │               │
│   │   │               ├───entites
│   │   │               │       Infraction.java
│   │   │               │
│   │   │               ├───feign
│   │   │               │       RadarRestClient.java
│   │   │               │       VehicleRestClient.java
│   │   │               │
│   │   │               ├───models
│   │   │               │       NewData.java
│   │   │               │       Owner.java
│   │   │               │       Radar.java
│   │   │               │       Vehicle.java
│   │   │               │
│   │   │               ├───repositories
│   │   │               │       InfractionRepository.java
│   │   │               │
│   │   │               └───web
│   │   │                       InfractionRestController.java
│   │   │
│   │   └───resources
│   │       │   application.properties
│   │       │
│   │       ├───static
│   │       └───templates
</pre>

### Eureka Discovery Service
```
Eureka is a server-side module within the Netflix OSS stack that facilitates the registration and discovery of services in a microservices architecture. It enables services to effectively communicate and locate each other within the system.
```
- Service Structure
<pre>
├───src
│   ├───main
│   │   ├───java
│   │   │   └───org
│   │   │       └───miaad
│   │   │           └───eurekadiscovery
│   │   │                   EurekaDiscoveryApplication.java
│   │   │
│   │   └───resources
│   │           application.properties
│   │
│   └───test
│       └───java
│           └───org
│               └───miaad
│                   └───eurekadiscovery
│                           EurekaDiscoveryApplicationTests.java
│
</pre>

### Gateway Service
```
Spring Cloud Gateway offers a centralized access point for directing and filtering incoming requests to microservices within a distributed system. It facilitates flexible and scalable routing, allowing for dynamic selection based on different criteria.
```
- Service Structure
<pre>
├───src
│   ├───main
│   │   ├───java
│   │   │   └───org
│   │   │       └───miaad
│   │   │           └───gateway
│   │   │                   GatewayApplication.java
│   │   │
│   │   └───resources
│   │           application.properties
│   │           application.yml
</pre>

### Road Radar
```
A Java application designed to simulate a radar system that generates random instances of speeding violations and sends them to the Radar-Service.
```

- Service Structure
<pre>
├───src
│   ├───main
│   │   ├───java
│   │   │   └───org
│   │   │       └───miaad
│   │   │           └───radarroad
│   │   │               │   RadarDetectionService.java
│   │   │               │   RadarRoadApplication.java
│   │   │               │
│   │   │               └───models
│   │   │                       NewData.java
│   │   │                       Radar.java
│   │   │                       Vehicle.java
│   │   │
│   │   └───resources
│   │       │   application.properties
│   │       │
│   │       ├───static
│   │       └───templates
</pre>

* Test

<table>
    <tr>
        <td>
            <p align="center">
                <img alt="project example"
                     src="https://github.com/el-moudni-hicham/radar-violation-detection-system/assets/85403056/0068cd62-3044-47ad-b1ac-a03c34713801"/>
            </p>
        </td>
    </tr>

</table>

# Frontend with Angular

## Video Demonstration

https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/video/Youssef%20SAKLAB-Distributed%20system%20Project.mp4?raw=true


## Application Sceenshots
### Login Page
```
The Login page in the front-end of my application utilizes Keycloak for authentication and authorization purposes. It serves as the user interface component where users can securely log in to access the application's features and resources.
If the provided login or password is incorrect, the system will raise an error, notifying the user of the authentication failure.
```
<table>
    <tr>
        <td >
            <p align="center">
                <h5 align="center">Login Page</h5>
                <img src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/frontend/loginPage.png?raw=true" alt="project example"/>
            </p>
        </td>
    </tr>
    <tr>
        <td>
            <p align="center">
                <h5 align="center">Incorrect Login or Password</h5>
                <img src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/frontend/InvalidLoginOrPassword.png?raw=true" alt="project example">
            </p>
        </td>
    </tr>
</table>

### Admin Page
```
Upon successful login, the user will be redirected to the admin dashboard, granting them access to the administrative interface of the application.
```
<table>
    <tr>
        <td >
            <p align="center">
                <h5 align="center">Admin Page</h5>
                <img src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/frontend/adminPage.png?raw=true" alt="project example"/>
            </p>
        </td>
    </tr>
</table>

### Dashboard Page
```
To access the dashboard, the user needs to navigate to the menu and click on the "Dashboard" option. From there, they will have the option to choose among different functionalities, such as viewing the list of infractions, the list of owners, the list of vehicles, or adding a new radar.

In the dashboard, users can not only access various functionalities but also have the ability to view the current statistics regarding the number of vehicles, owners, and infractions. This information provides a summary or overview of the system's data, allowing users to quickly assess the volume and status of these entities.
```
<table>
    <tr>
        <td >
            <p align="center">
                <h5 align="center">Dashboard Page</h5>
                <img src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/frontend/dashboard.png?raw=true" alt="project example"/>
            </p>
        </td>
    </tr>
</table>

### Owners Page
```
On the owner page, users have the capability to view two key aspects: 
- The list of owners
- The list of vehicles associated with a specific owner.

To access the list of owners, users can simply navigate to the respective section on the page. Upon locating the desired owner, users can click on the vehicle logo, symbolizing the vehicles owned by that particular owner, to view the corresponding list of vehicles. This functionality enables users to explore the vehicles owned by a specific owner with ease.
```
<table>
    <tr>
        <td >
            <p align="center">
                <h5 align="center">Owners Page</h5>
                <img src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/frontend/owners.png?raw=true" alt="project example"/>
            </p>
        </td>
    </tr>
    <tr>
        <td >
            <p align="center">
                <h5 align="center">Owners Page with Associated Vehicle List</h5>
                <img src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/frontend/allOwnersInfo.png?raw=true" alt="project example"/>
            </p>
        </td>
    </tr>
</table>

### Vehicles Page
```
On the Vehicles page, users can access a comprehensive list of vehicles along with their respective owners. To view the owner of a specific vehicle, users simply need to click on the user icon located in front of the vehicle entry. This action will provide immediate access to the owner's details, allowing users to quickly retrieve information about the owner associated with the selected vehicle.
```
<table>
    <tr>
        <td >
            <p align="center">
                <h5 align="center">Vehicles Page</h5>
                <img src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/frontend/vehicles.png?raw=true" alt="project example"/>
            </p>
        </td>
    </tr>
    <tr>
        <td >
            <p align="center">
                <h5 align="center">Vehicles Page Displaying Owner Information</h5>
                <img src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/frontend/vehiclesInfo.png?raw=true" alt="project example"/>
            </p>
        </td>
    </tr>
</table>

### Radars Page
```
The Radars page provides users with a comprehensive list of available radars, offering functionalities such as deletion, updating, and changing the status from ON to OFF and vice versa. To delete a radar, users can click on the delete button, which prompts the system to display a confirmation message before proceeding with the deletion. Similarly, to update a radar, users can click on the update button, which redirects them to the dedicated update page for making necessary modifications.
```
<table>
    <tr>
        <td >
            <p align="center">
                <h5 align="center">Radars Page</h5>
                <img src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/frontend/allRadars.png?raw=true" alt="project example"/>
            </p>
        </td>
    </tr>
    <tr>
        <td >
            <p align="center">
                <h5 align="center">Radars Page - Delete Radar</h5>
                <img src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/frontend/deleteRadar.png?raw=true" alt="project example"/>
            </p>
        </td>
    </tr>
    <tr>
        <td >
            <p align="center">
                <h5 align="center">Radars Page - Update Radar</h5>
                <img src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/frontend/editRadar.png?raw=true" alt="project example"/>
            </p>
        </td>
    </tr>
</table>

### Infractions Page
```
On the Infractions page, users can access a comprehensive list of infractions along with their corresponding status (paid or unpaid). If users require detailed information about a specific infraction, they can simply click on the green button located in front of the infraction entry. By doing so, users will be able to view additional information, including details about the vehicle involved, the owner of the vehicle, and information pertaining to the radar associated with the infraction. This functionality allows users to obtain a complete overview of the infraction and relevant data with ease.
```
<table>
    <tr>
        <td >
            <p align="center">
                <h5 align="center">Infractions Page</h5>
                <img src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/frontend/allInfractions.png?raw=true" alt="project example"/>
            </p>
        </td>
    </tr>
    <tr>
        <td >
            <p align="center">
                <h5 align="center">Infractions Page - Full Infos of Infraction</h5>
                <img src="https://github.com/YoussefSAKLAB/radar-violation-detection-system/blob/main/assets/frontend/allInfractionsWithInfos.png?raw=true" alt="project example"/>
            </p>
        </td>
    </tr>
</table> 

# Docker deployment
```
The `docker-compose.yml` script to deploy the distributed system in Docker containers.
```
# Author

- [@YoussefSAKLAB](https://www.github.com/YoussefSAKLAB)

