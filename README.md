# bookstore
Bookstore practice project

In this project I am developing a database with Java, JPA, H2 and Thymeleaf.

This is a practice project, that I am doing in our schools Server Programming course.
As said it's intended to be an exercise that is extended with new functions etc. as the course goes forward.

Currently it has:
 - the bookstore mainpage, where all the books are listed
 - a page for adding new books
 - a page for editing an existin book
 - a page where new categories can be added

Functions for all mentioned above and also a function for deleting a book.

It is also a relational database: there are two Classes, Book and Category, with a many-to-one and one-to-many relationship.

It now also has RESTful services, so books and categories can now be used with JSON.

Now there is Spring Security authentication service, two demo users for it, user list page with which new users can be added and the passwords are in hashed format inside the database. BCryptPasswordEncoder is used for the hashing, although when you add a new user the password needs to be given in already hashed format, i.e. using BCrypt calculator to calculate the hash from the plain text format (remember to check there is now any extra characters when you copy the hashed password, i.e. extra space at the beginning or at the end).
