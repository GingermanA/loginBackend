## Getting Started

1. Open loginBackend on Intellij
2. Setup Database (Postgresql)
	- download postgresql (https://www.postgresql.org/download/windows/)
	- ensure that you have a user "postgres" with password "password" on set up, otherwise proceed to application.yml under resources folder in the project to change the spring: datasource: username and password accordingly
	- go intellij and click on database on the right side panel
	- click "new" => "Data Source" => "Postgresql"
	- set user as "postgres" and password as "password"
	- all other details are default
	- click "test connection" and ensure that you can connect, otherwise might need to debug 
	- click "Apply" and "OK" if fine
	- click refresh in database tab
	- click on the "1 of 3" or whatever if may appear as beside your postgres@localhost, and select "all database" to see your database later on
	- right click on postgres@localhost and click new => database
	- change name to "login" with no caps
	- click ok
3. With database properly created, go ahead and click on the play button on the top right hand of the IDE. The database should contain a table "user-info" with 2 rows of data.
4. Proceed to run the web frontend 

