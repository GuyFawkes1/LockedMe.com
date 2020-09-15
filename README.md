# Digitization of LockedMe - Specification Document

**Digitization of LockedMe.com**

**Project Details:**

As a part of the product digitization drive at Company Lockers Pvt. Ltd., this project is a prototype of LockedMe.com. The following are the features and specifications of it.

This project offers a variety of functionality around files - addition, deletion, listing, which will be clearly stated in this specification document..

The user of this prototype, interacts with it through the command line. Upon starting up the application the user will be greeted with the welcome screen and then offered:

- An option to return the current file names in the ascending order.
- An option to manipulate the current files in the directory. Which upon selecting will give him:
    - An option to add a file to the existing directory list
    - An option to delete a specific file from the existing directory. (This is case-sensitive)
    - An option to search specific file from the main directory
    - An option to navigate back to the main context
- An option to close the entire application.

**Developer details:**

This application is being developed by K Isaac Prasanth, a Java Fullstack developer for the Company Lockers Pvt Ltd.

**Sprints planned:**

The following are the user stories for the project.

1. As a user I want to be greeted with a warm welcome screen.
2. As a user, I want to create new files so that I can add new files into the product
3. As a user, I want to see all the files in the directory so that I can see all my files in the application at once.
4. As a user, I want to delete a file that is no longer required to be kept in the directory so that my directory remains clean.
5. As a user I want to search for a file so that I can verify it exists or not.

These user stories have been divided into two sprints

- One - covering user stories numbered - 1,2,4
- Two - covering user stories numbered - 3,5

**Github Repository:**

The entire project can be found at [https://github.com/GuyFawkes1/LockedMe.com.git](https://github.com/GuyFawkes1/LockedMe.com.git)

**Flowcharts and algorithms used in the project:**

**User Experience Flowchart:**

![UXFlow](/FlowCharts/UXFlowChart.png)

For the sake of simplicity, user inputs at the add file, search file and delete file processes have been omitted in the flowchart.

**Implementational details:**

The classes and their packages used in the program are:

- LockedMeMain (org.lockedme.main): It starts the program and spawns an object of class LockedMePresentation to provide user interfaces, and an object of class LockedMeServiceImpl, which deals with business logics.
- LockedMePresentationImpl(org.lockedme.presentation.impl): This is the presentation layer of the application. It displays the main and secondary menus.
- LockedMeServiceImpl (org.lockedme.lockedmeservice.impl): This is the business layer of the application that will handle all the business logic like validating if a given file name is valid, sorting the list that has been retrieved from the DAO, asking DAO to create, search or delete an object.
- LockedMeDaoImpl(org.lockedme.dao.impli): This class deals with the implementation and maintenance of our databases. In this case it's a simple Set, implemented by HashSet.
- UserFile(org.lockedme.model): This is the model class for the entire application that outlines the UserFile object. Currently it only holds a single parameter, name, but can be expanded to include a variety of other parameters and fields.
- UserFileException(org.lockedme.exception): This is the exception class.

Other than this, to ensure quality of code, We also created interfaces for the first four classes listed above.

![ClassesFlow](/FlowCharts/ClassesFlow.png)

**Functionality and the corresponding algorithm behind them:**

**Adding new File:**

The new file is created and put in the DAO, i.e. the set by DAO, on the request of the Service class, which in turn was requested to do so by the main class. Addition is O(1), because it's a HashSet and addition in a HashSet is based on the hashcode generated.

**Deleting a File:**

It is quite similar to adding a new file, with the difference being instead of adding a file, we are removing an object from the Set. This is also an O(1) operation.

**Searching for a file:**

Searching for a file is O(1) because we are maintaining the data in a HashSet, thus a hashcode will be generated based on the name of the file and will be checked at that address.

**List of all files currently stored:**

For this operation, we ask DAO to simply send the entire list of the objects stored in it, to the service layer. This operation is O(n). Then the service layer uses a custom comparator, to compare two UserFile objects by name and sort them in alphabetical order. For this we are using java.text.Collater, so that we can differentiate even accents and produce accurate alphabetically ordered results.

**Concepts used in the project:**

- Interfaces
- Collections
- Exceptions
- Comparators
- Overriding
- HashCode(), equals()
- Sorting

**Enhancements that can be implemented:**

- We can add more details to the UserFile object,such as date of creation, type of file etc. and create operations and displays based on those values.
- We can create persistent files on disk by tweaking the DAO layer to add a persistence component to it, either by directly writing the files to a directory in the machine or maintaining some sort of a database to keep track of these.

**Unique Selling Points:**

1. This application has been built with extensibility and flexibility in mind. The code base is divided into modular parts and any one part or implementation can be tweaked with and extended without causing a cascading failure in the entire code base.
2. We have created a quick and high quality product to showcase the concept of LockedMe.com, so that a complete implementation, with persistence, web components can be developed with this as a template.
