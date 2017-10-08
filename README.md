CS 441 - Cloud Computing HW 2
======
Submitted By:

Sankul Rawat <srawat5@uic.edu>

Graduate student

UIN: 653416288

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

![picture](images/flow.jpg)

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
1. The junit tests are present on path `sankul_rawat_hw2/src/test/java/` .
2. build.sbt file is present in the root directory of the project.
3. Code coverage reports (in HTML format) are contained in `sankul_rawat_hw2/TestReports` directory.
4. Code coverage reports (in text format) are contained in `sankul_rawat_hw2/input` directory.
5. The output of maximum coverage implementation is present in `sankul_rawat_hw2/input` directory 
(it overwrites the existing text file).
6. The code for HTML format code coverage report parsing, maximum coverage implementation, 
and Mapreduce is present in `sankul_rawat_hw2/mapreduce/src` directory.

#Implementation on Amazon EMR
[Youtube video displaying the deployment and execution on Amazon EMR](https://youtu.be/9PxlI-Z-Qtw)

[Youtube video displaying the final results of execution and comparison between max cover and normal outputs](https://youtu.be/u_eVzI5V-d0)

###Citation
[How to Deploy Custom JAR on Amazon EMR](https://www.youtube.com/watch?v=qyRxq8YwZcU)

#Explanation of Maximum Coverage Problem Implementation [Extra Credit Work]
I use a polynomial time approximation greedy algorithm which a special case of 
maximization of submodular functions with a cardinality constraint.

Algorithm: Greedy Maximum Coverage

1. Input: Set of sets U, k
2. for i=1:::k do 
3.    pick the set that covers the maximum number of uncovered elements 
4. end

The implementation is present in `MaxCover.java`, at location `sankul_rawat_hw2/mapreduce/src/MaxCover`.

###Citations
[Wikipedia article on Max Coverage](https://en.wikipedia.org/wiki/Maximum_coverage_problem)

[Design and Analysis of Algorithms, DUKE University Lectures](https://www.cs.duke.edu/courses/fall13/compsci530/notes/lec16.pdf)

[Set Cover Problem (Greedy Approximate Algorithm)](http://www.geeksforgeeks.org/set-cover-problem-set-1-greedy-approximate-algorithm/)