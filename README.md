Branch Manager Address Book Application
=======================================
This application facilitate for branch manager to maintain customer contact details. The MVP has been designed build

to meet the acceptance criteria of the user story 042.Please refer the attached user story; Address Book for more details.

Solution Design
---------------
Solution includes four classes.

Customer: hold customer details.

Telephone: Holds telephone details of the customer.

Contact: Represent a contact of the address book.

AddressBook: Represent an address book.

AddressBookApp: Address book application which holds one or more address books.

Util: Class with helper functions and attributes.

Main: Main class of the application.

AddressBookException: Custom exception used in this application. Caller needs to handle this exception in methods calls
                      of AddressBookApp class.

Design and Development Methodologies
------------------------------------
Solution is based on Object Oriented Design principles and Test Drive Development (TDD).

Source Control
--------------
Git has been used as the source control repository.

Languages and tools used
------------------------
This application has been developed in Java 8.

Java:
java version "1.8.0_73"
Java(TM) SE Runtime Environment (build 1.8.0_73-b02)
Java HotSpot(TM) 64-Bit Server VM (build 25.73-b02, mixed mode)

JUnit 1.4.2 for unit tests.

Unit Tests
----------
Unit tests are available within /src/test/**.

Future directions
-----------------
Enrich the application by adding a user interface using rich front end frameworks like AngularJS.
Enhance the application as a microservice to enable to consume operations JSON/XML base.
Extends the application to have a persistence store.
