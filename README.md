# library-system

This is a basic library management system that lets you create, read, update, and delete books and authors using Spring Boot and MYSQL.

In order to use this application, create a new database/schema in MYSQL called lms. This is what the application will read and write to when data is inputted and saved.

Go into application.properties and make sure the host, username, and password are updated to match your system.

Once this is completed, run the application and type in the local host followed by /authors.

This application works by creating an author first. Just click on the add author button and type in the name of the author. Once done, click submit. You should see this populate on the page and within the lms database/scheme in MYSQL Workbench.
After which, you can type in /book in the url after the local host or click on Books in the navigation bar.
Click add a book and select the author from a dropdown menu. (note: I did attempt to create an input box for books where the user can input a new author but I ran into issues with the input and so it was deleted).
Once completed, hit submit and you should now see the book populate within the table, along with edit and delete buttons for that entry.

If you go back to /authors (either by typing in the location or by clicking on authors in the navigation bar), you should now see the author entry reflecting associated books.

To edit books or authors, click on the edit button for that entry and update the fields for each book object or each author object. Book titles and author names are text inputs. Author selection is a selection input.
Once edits have been finalized, click on the submit button on the form.

To delete a book or author, click on the respective delete button for that specific entry. The delete button will seach for that entry's unique ID and delete it from the database.

The /authors and /books pages automatically list out each entry so there are no separate "viewing" pages.




