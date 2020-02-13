# WILDLIFE TRACKER

An application that helps track Animals in a park.

#### By Daniel Sindet

## Description

 The application allows rangers to track wildlife sightings in an area. The user can add an animal to the system and report its sighting by providing details such as location, health and age. The animals added can eithr be endangered or not endangered. 

## Setup/Installation Requirements
1. Not set yet

#### To re-create the database, follow these steps;
In PSQL:
* CREATE DATABASE wildlife_tracker;
* \c wildlife_tracker;
* CREATE TABLE animals (id serial PRIMARY KEY, name varchar);
* CREATE TABLE endangered_animals (id serial PRIMARY KEY, name varchar, health varchar, age varchar);
* CREATE TABLE sightings (id serial PRIMARY KEY, animal_id int, location varchar, ranger_name varchar);
* CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;

## Behaviour driven Development (BDD)
|#User inputs   |  #Example outputs |         
|---------------|-------------------|
|When it receives:               | It should return:                  |
| User adds an animal             | An animal is added                |
| User adds an endangered animal             | An endangered animal is added |
| User reports an animal sighting            | Animal sighting is reported  |




## Technologies and language used
* Java (SDK JRE)
* Gradle
* Spark - web framework.
* Postgres SQL - Database


## License
 * Wildlife Tracker
#### Copyright (c) 2020 Daniel Sindet 

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

