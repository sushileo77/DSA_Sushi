/*

The Queue interface of the Java collections framework provides the functionality of the queue data structure. It extends the Collection interface.

Classes that Implement Queue:

Since the Queue is an interface, we cannot provide the direct implementation of it. In order to use the functionalities of Queue, we need to use classes that implement it:

ArrayDeque
LinkedList
PriorityQueue

In queues, elements are stored and accessed in First In, First Out manner. That is, elements are added from the behind and removed from the front.

In Java, we must import java.util.Queue package in order to use Queue.

Syntax:

 Queue<String> names= new ArrayDeque<>();
The above statement creates a Queue of Strings, we can now push and remove Strings from this queue easily.

Methods of Queue:

add() - Inserts the specified element into the queue. If the task is successful, add() returns true, if not it throws an exception.
offer() - Inserts the specified element into the queue. If the task is successful, offer() returns true, if not it returns false.
element() - Returns the head of the queue. Throws an exception if the queue is empty.
peek() - Returns the head of the queue. Returns null if the queue is empty.
remove() - Returns and removes the head of the queue. Throws an exception if the queue is empty.
poll() - Returns and removes the head of the queue. Returns null if the queue is empty.
size() - Return an integer denoting the total number of elements in the queue at present.

*/
