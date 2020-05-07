# Java-Class-Serializer-Deserializer

### The Purpose:  
This project is to be used when there is a need to deal with incoming JSON-formated data package in a specific 
language of code and convert those objects into JSON-formated package again to send back afterwards.  

###  How It Works:  
This project can take any incoming JSON-format data, and generate java classes accordingly.
In addition, it will also generate a "serialize" function for each of the classes, so that they can be converted back to JSON-formated 
data package any time.  

### Features:  
- Ability to deal with inter-dependencies of objects  
  e.g.  `Person person1` has a `Dog dog1` has a `Person owner2`  
  The deserializer can deal with this kind of situation intelligently so that it will not run into a dead loop. 
- Ability to deal with JSON Array of JSON Objects  
- Depenency Injection & Control Inversion to make it "Open/Closed"  
  Although currently this project only works with java, but it is designed to be very flexible and can be extended to work with any other desired languages such as Python and C++ with only minimum amount of implementation of the provided interface needed.  
  
