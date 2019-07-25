
## SQL Joins

https://www.w3schools.com/sql/sql_join.asp


A JOIN clause is used to combine rows from two or more tables, based on a related column between them.

Let's look at a selection from the "Orders" table:


![Join for tables](table.png?raw=true "Tables")


Notice that the "CustomerID" column in the "Orders" table refers to the "CustomerID" in the "Customers" table. The relationship between the two tables above is the "CustomerID" column.

Then, we can create the following SQL statement (that contains an INNER JOIN), that selects records that have matching values in both tables:

```
SELECT Orders.OrderID, Customers.CustomerName, Orders.OrderDate
FROM Orders
INNER JOIN Customers ON Orders.CustomerID=Customers.CustomerID;
```

and it will produce something like this:

|   OrderID	|   CustomerName	|   OrderDate   |
| ------------- | ------------- | ------------- |
|   10308	|   Ana Trujillo Emparedados y helados	|   9/18/1996   |
|   10365	|   Antonio Moreno Taquería	|   11/27/1996  |


Different Types of SQL JOINs
Here are the different types of the JOINs in SQL:

    1.   (INNER) JOIN: Returns records that have matching values in both tables

    2.  LEFT (OUTER) JOIN: Returns all records from the left table, and the matched records from the right table

    3.  RIGHT (OUTER) JOIN: Returns all records from the right table, and the matched records from the left table

    4.  FULL (OUTER) JOIN: Returns all records when there is a match in either left or right table



![Join for tables](joins.png?raw=true "Joints")