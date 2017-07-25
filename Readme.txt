Haitian (Linda) Lu, Sneha Kumar — hl723, sk2279 - CS 2110 Summer 2017  HW 4

###########################################################################
Question 2

Main classes:
	Graph.java
	Cluster.java
	Agency.java

Supporting classes:
	Edge.java
 	Node.java
	Person.java
	BinaryHeap.java
	ArrayList.java

JUnit Test classes:
	GraphTest.java

Program supports building a population (person housed in nodes) and an agency (with employees, person housed in node as well that are in the population) searching for the best routes from one of its agent to a person, best as defined by best future 
reusability (least impact on the karma points of the graph). I have used Dijkstra with heap as the basis for searching for the best route. I have implemented the algorithm as choosing the shortest path while taking into account karma points so 
that each friendship uses the least number of karma points while avoiding the karma point of one edge running low by increasing the weight of an edge after each use by the reciprocal of current karma point. Karma points are initialized for each edge as the number of friends they have plus a random number from 0 to 4, to give variability for different kinds of friendship, decreasing by one each time it’s used. Any edge with karma point smaller or equal to zero will be unaccessible. All edge weights are initialized with value 1 first plus the reciprocal of karma points. The way I update weights is specific to the capacity and density of my graph in Unit testing as the specifics to a graph can influence the best way to update weights. 

I have defined a cluster as a group of people in nodes, in which everyone can get to everyone else, while different clusters have very few connections. Two different clusters are connected to each other, but two elements in different clusters might not necessarily be able to reach one another. I have made the Dijkstra so that if an element is unreachable from current person, a statement will be printed out to say that it’s two different clusters. I implemented Tarjan’s Algorithm using stack to find clusters, defined as a group of strongly connected elements in which each 
element can reach every other. This function can be called separately to detect clusters and print out different clusters and the people they contain.