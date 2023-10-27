# CRUD

A inventory Backend Application using h2DB for normal CRUD operations .
This is a maven based project so to run the sample - 
- Clone the project in your local 
- Maven build with goal - clean install
- Run the application by running DemoApplication.java as java application

The application exposes the following services - 

GET CALLS - 
{localhost}/api/v1/equipment - to fetch all the equipments in inventory
{localhost}/api/v1/equipment{id} - to fetch the equipments with id provided by user, in inventory, if present then provides the equipment otherwise throws a error 

POST CALLs-
{localhost}/api/v1/equipment - to save a new equipment in inventory

PUT CALLs-
{localhost}/api/v1/equipment{id} - to edit the equipments with id provided by user, in inventory, if present otherwise throws a error

DELTE CALLs-
{localhost}/api/v1/equipment{id} - to delete the equipments with id provided by user, in inventory, if present otherwise throws a error
