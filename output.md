
Header:
Content-Type: application/json
Supported HTTP Methods :
 
Using POST Create a new temperature
POST   : http://localhost:8080/api/temperatures
Input -

{
	"Temperature in celsius":45
}

Output -

{
   "id": 1,
	 "Temperature in celsius": 45 ,
   "Created On": "2018-06-05T04:18:08.915+0000",
   "Updated On": "2018-06-05T04:18:08.915+0000"
}

Using GET retrieve a all temperatures in celsius and fahrenheit
GET    : http://localhost:8080/api/temperatures

Using GET retrieve a temperature by given id
GET    : http://localhost:8080/api/temperatures/2

Using PUT update a temperature for existing id
PUT    : http://localhost:8080/api/temperatures/3

Using DELETE remove a temperature by id
DELETE : http://localhost:8080/api/temperatures/2
 
 

 
 

 

















