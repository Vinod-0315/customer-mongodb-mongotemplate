# Customer Management with MongoTemplate (MongoDB)

A Spring Boot project demonstrating **CRUD and query operations on Customer data** using **MongoTemplate**. Operations are executed programmatically via a **service layer** and can be verified in **MongoDB Compass GUI**.

---

## Repository Name Suggestion

`customer-mongodb-mongotemplate`

---

## Technologies Used

* Java 17
* Spring Boot 3.x
* Spring Data MongoDB (`MongoTemplate`)
* MongoDB (Compass GUI for visualization)
* CommandLineRunner to execute operations on application startup

---

## Features

* Register single or multiple customers
* Fetch customers by ID, all customers, or by multiple criteria
* Update customer details or addresses (single or batch)
* Remove customers individually or by criteria
* Register or update customer in one operation
* All operations performed programmatically using MongoTemplate
* Data visible and verifiable in MongoDB Compass

---

## Installation / Running the Project

1. **Clone the repository**

```bash
[git clone <your-repository-url>](https://github.com/Vinod-0315/customer-mongodb-mongotemplate.git)
cd customer-mongodb-mongotemplate
```

2. **Configure MongoDB**

* Update `application.properties` with your MongoDB connection details:

```properties
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=customerDB
```

3. **Run the project**

* Using Maven:

```bash
mvn spring-boot:run
```

* Or from your IDE (Eclipse / IntelliJ): run the main class `CustomerMongoTemplateApplication.java`

> All operations in the **CommandLineRunner** class will execute automatically at startup.

4. **Verify operations**

* Open MongoDB Compass
* Connect to the `customerDB` database
* Inspect the `customer` collection to verify CRUD operations

---

## Example Operations Implemented

* **Register Customer**

```java
registerCustomer(emp);
```

* **Batch Register**

```java
registerCustomerBatch(List<Customer> list);
```

* **Fetch Customer by ID**

```java
fetchCustomer("cust123");
```

* **Fetch All Customers**

```java
fetchAll(Customer.class);
```

* **Query by Number & Address**

```java
showCustomersByNumberAndAddress(1234567890L, "Mumbai", Customer.class);
```

* **Query by CBILL**

```java
showCustomersByCbill(1001, Customer.class);
```

* **Update Customer**

```java
updateCustomer("cust123","New Address","New Name", Customer.class);
```

* **Update Address by Regex**

```java
updateCustomerAddrss(".*Street", "New Street", Customer.class);
```

* **Register or Update**

```java
registerOrUpdate("Mumbai", 1002, Customer.class, "New Add");
```

* **Remove Customer**

```java
removeCustomer("cust123", Customer.class);
```

* **Find All and Remove by CBILL**

```java
findAllandRemove(Customer.class, 1001);
```

---

## Notes

* All CRUD and query operations are performed **programmatically via MongoTemplate**
* **CommandLineRunner** executes operations automatically at startup
* MongoDB Compass can be used to **visualize and verify** the data

---

## Author

Vinod Lucky
