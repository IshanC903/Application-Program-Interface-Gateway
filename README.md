# Application-Program-Interface-Gateway
Network Application Course Assignment

NET4500 Assignment 3 - SOAP
Ishan Chaurasia: 101011068
Reece Pillinger: 101013264


The APIGateway.java file is responsible for processing requests from the clients so they can be forwarded to the correct server. The API gateway also is used for load balancing, this is achieved by giving each server a turn to be selected to process the incoming client’s service request. To process the client services requests, there are 4 server classes. (Server(n).java) Server 1 and 2 belonging to service A and Server 3 and 4 belonging to service B. ServiceA/B .java interface with the server to process the client requests appropriately. Client.java is used to process user input by sending the user’s service requests to the APIGateway to be further forwarded.
