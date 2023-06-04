# Dye_And_Durham_Coding_Assessment

The program is built using Maven. This program code is executed by the Main class (src/main/java/sort/Main.java), which calls the function and accepts 2 parameters:

1. path to the unsorted file (dataFiles/unsorted-names-list.txt)
2. path to the file in which the sorting result will be written (dataFiles/sorted-names-list.txt).
All methods of the program's functionality are in the SortPersonList class.

The files for input and output data are located in the dataFiles folder. The files for the final test are located in the dataFiles/testFiles folder.

Test cases for different cases were written, as well as a final test to check reading and writing to the file and the sorting algorithm. File with test located in (src/test/java/sort/TestSortPersonsList.java)

CONTINUE INTEGRATION (GitHub Actions) Created a build pipeline in GitHub Actions to build and run all tests.

GitHub Actions file (.github/workflows/github-action.yml)