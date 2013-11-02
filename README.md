JMatrix
=======

A project to implement the algorithms learned in my computational linear algebra course. This code is by no means meant for production. You have been warned.

Features
=======

* The Matrix class is immutable. This makes reasoning about operations much easier and provides some peace of mind. This has some important implications:
	* All Matrix operations return new Matrix objects as opposed to editting the contents of the matrices at hand
	* There is a larger memory footprint than having the matrices be mutable, and you will have to pay the price of allocating memory / copying data. It was decided that immutability was worth this penalty.

* The novel concept of an Enforcer pattern (I couldn't find reference to this anywhere) is implemented. The idea is that the MatrixBuilder is given a list of Enforcers that it must check against before editting the contents of the matrix. This allows the user to gaurentee that the Matrix that will result from the Builder will have specified matrix properties

* In a future release, the Matrix class will keep a set of Matrix properties so that given a Matrix at runtime it is possible to determine what properties it possesses. These "properties" refer to things like being a Square Matrix, or Symmetric. It is intended that these properties could provide additional methods to take advantage of the implications of being of a certain type.

Note: JMatrix takes a different approach than similar libraries such as Apache Commons Linear Algebra package (http://commons.apache.org/proper/commons-math/userguide/linear.html) to design problems.
