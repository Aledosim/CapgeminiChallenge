# Capgemini's Challenge Answers

## About
This repository contains the answers to the Capgemini's development challenge for their _Academia Capgemini_ selection 
process. The questions involved basic algorithm logic with strings and printing characters in command line. The deadline
was five days from the sending of questions (they can be found 
[here](https://github.com/Aledosim/CapgeminiChallenge/raw/main/Desafio%20de%20programa%C3%A7%C3%A3o.pdf) in portuguese).
The event happened in February 2022 and you can checkout my answers for their 2021 edition 
[here](https://github.com/Aledosim/adreg).

## Installation
### Prerequisites
You'll need [JUnit5](https://junit.org/junit5/) in order to execute the tests. Or just use [Maven](https://maven.apache.org/).

Developed with [OpenJDK](https://openjdk.java.net/) version 11.0.14.

### Installation
1. Clone the repo and enter the folder
   ```sh
   git clone https://github.com/Aledosim/CapgeminiChallenge
   cd CapgeminiChallenge
   ```
2. Each question is an independent Maven project, so you need to access each question folder and compile it as you want.
If you are using Maven, inside the question directory run:
   ```sh
   mvn package
   ```
   And then you can launch the jar file at target folder.

### JavaProcess warning
The `JavaProcess` file under the test folder of all questions is unique. All
three are hardlinks. This way I could apply the "don't repeat yourself" 
without mess with paths.

## Usage
Launch the jar file with the desired input, e.g.:
   ```sh
   # inside question1 folder
   java -jar target/question1.jar 6
        *
       **
      ***
     ****
    *****
   ******
   ```

The same with question 2 and 3, e.g.:
   ```sh
   # inside question2 folder
   java -jar target/question2.jar Ya3
   3
   ```
   ```sh
   # inside question3 folder
   java -jar target/question3.jar ifailuhkqq
   3
   ```

### Getting help
For each question there is a help text you can access with `-h` or `--help` flags, e.g.:
   ```sh
   # inside question1 folder
   java -jar target/question1.jar -h
   usage: question1 [--help|-h] NUMBER_OF_LINES

   This program prints a stair of *

   positional arguments:
     NUMBER_OF_LINES      the height of the stair (the width is the same) 

   optional arguments:
     -h, --help  show this help message and exit

   This application is part of Capgemini Brasil's trainee selection program.
   ```

### Testing
Tests resides beside `main` folder inside `src`. If you're using Maven, run:
   ```sh
   # inside some question folder
   mvn test
   ```

## Author
Alexandre do Sim – [LinkedIn](https://www.linkedin.com/in/alexandre-do-sim/) – aledosim@yahoo.com.br

The answers are distributed under the GPL3 license. See `LICENSE` for more information.

## Acknowledgements
### What I've learned
This is my most confident project until now. Although Java isn't my primary language (which is Python lol), I felt really
comfortable with the documentation. The strong static type discipline was the hard side, but in the end I enjoyed to
do not type checks for myself like I would do on some other language. My style of code generally is using VIM and all terminal 
work, but this time IntelliJ saved me. The best thing I discovered from this exercise is the Java stream API, that remind me 
the JavaScript promisse, a great feature.

### Future tasks
* automate print_help function tests of all questions
* reformat print_help function of all questions to ease maintenance
* implement an Exception for invalid input on Question1.print_line
* implement an Exception for invalid input on Question3.substringAnagramCount
