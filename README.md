Cloud Computing HW 2
======

Link to the application repository which is being used:
[Botnak repo](https://github.com/Gocnak/Botnak)

# Description
I use junit tests to test the above mentioned application. 
Sbt automates the process of managing dependencies and is used to build and run these tests. 
A code coverage report is produced in html format using sbt-jacoco plugin.
Then these html code coverage reports are parsed into text file format using jSoup.
Then I use my implementation of maximum coverage to find out which tests to run in 
order to cover maximum lines of codes. After this, the data is fed to Mapreduce job where
it coverts the data of type <t1, <l1,l2,...,ln>> into <l1, <t1,t2,....tn>>. 
The execution of Mapreduce is also performed on Amazon EMR.

# Requirements
You will need the latest version of Java 8 to run tests. [Download it here.](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)

You will also require intellij ide. [Download it here.](https://www.jetbrains.com/idea/download/#section=windows)

Junit and other dependencies will be automatically added using gradle and sbt.

# How to run the project
1. Copy the repo clone "https://sankul@bitbucket.org/sankul/sankul_rawat_hw2.git".
2. Open intelliJ.
3. In intellij, open project using version control -> git.
4. Follow on screen instructions to clone and import project.
5. Once the project is open, open terminal window inside intellij.
6. To run using sbt, execute following command `sbt clean compile test` in terminal, this will compile and run the tests.
7. `sbt jacoco` command produces the code coverage reports.    

# Location of related items
1. The junit tests are present on path `Botnak/src/test/java/` .
2. build.sbt file is present in the root directory of the project.
3. Code coverage reports (in HTML format) are contained in `Botnak/TestReports` directory.
4. Code coverage reports (in text format) are contained in `Botnak/input` directory.
5. The output of maximum coverage implementation is present in `Botnak/input` directory 
(it overwrites the existing text file).
6. The code for HTML format code coverage report parsing, maximum coverage implementation, 
and Mapreduce is present in `Botnak/mapreduce/src` directory.
