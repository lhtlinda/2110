Sneha Kumar, Haitian (Linda) Lu — sk2279, hl723 — CS 2110 Summer 2017 — HW 3

#############################################################

Question 1 

Main Classes: 
	Calculator.java
Supporting Classes: 
	ExpressionParser.java
	Node.java
	MyStack.java
	
Exception Classes: 
	InvalidRPNException.java
	InvalidInfixException.java
JUnit Test Classes:
	CalculatorTest.java
	ParserTest.java
	
	Version 1: 
	
Non-implemented changes:
	1. 

#############################################################


Question 2

Main classes:
	Graph.java
	
Supporting classes:
	MyQueue.java
	Person.java
	Arraylist.java
	Node.java

JUnit Test classes:
	GraphTest.java
	

Program has a built-in adjacency list  with the capability to search for the path from one random person for another and
output the process. There are three available methods: breadth-first search, depth-first search and bidirectional breadth-
first search. Output shows the name of start and finish person . The person encountered on the 
path are also printed, the printing order is the direct path leading from start to finish person for BFS. and for DFS and 
BidirectionalBFS it is the search order. Bidirectional has the steadiest performance on average and BFS has some extreme cases 
where it takes very long because it's good mostly for closer elements while DFS is better for further ones. Bidirectional is 
noticeably better for larger data.

	
