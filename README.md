# Questionnaire
Web Application to configure and build forms from stored in db customized html elements

Layoutes consisted of html elements with customized parameters are stored in db. Program provides functionality to find and build 
needed layouts to transmit them later to the client side.

Layouts in this context can be either form to provide client with some questionnaire or a simple div block.

Although all html tag's parameters can be independent from external sources and stored in database as they are, there's also an opportunity
to specify values which are defined in main css and js files which are uploaded to the client side as static resources.


../ [GET]; ../index [GET] - view main form <br>
../saveStartPageFormData [POST] - will save submitted data from form (this url is used to send data to the server transparently by ajax)<br>
../list [GET]; ../show [GET] - show all recorded data from form

Scripts for creating database schema could be found in db/create_schema
Scripts to fill database with main form which is used in base route could be found in db/fill_schema

Tested on Tomcat 8.5.34 and MySQL 5.5.23
