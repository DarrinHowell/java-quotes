# java-quotes
### Authors: 
- Pablo Rosales
- Darrin Howell

### Project 
This application makes a GET request to an API that returns a single random quote via 
transmission of a JSON object. After receiving this object back, we parse the json data
with Google's gson tool, converting it into a quote object. After a quote object has been
instantiated, we print that quote to the console. This new quote object is then appended
 to our collection of quotes and subsequently written to file. This file is updated
  every time our API is successfully hit. <br/> 

In the event that our GET request fails, we fall back on a series of backup methods 
that load in our collection of JSON objects from our hard disk, and we pick a quote
at random. 

### Installing Dependencies and Running our App
Dependencies will be installed on your computer after downloading this repo.

To run our application, run the main method from the App.java file.  


