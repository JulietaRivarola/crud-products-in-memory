CRUD Products In-Memory

This is a simple CRUD (Create, Read, Update, Delete) application for managing products. The app allows you to perform basic operations on products, such as adding new products, updating existing products, deleting products, and searching for products by ID or name.

API Reference

This application exposes a REST API for managing products. The following endpoints are available:

GET /products: Retrieves a list of all products. 
POST /products: Creates a new product. 
PUT /products/{id}: Updates the product with the specified ID. 
DELETE /products/{id}: Deletes the product with the specified ID.

Request Parameters

id: The ID of the product to retrieve or update. 
name: The name of the product to search for. 
sortBy: The field to sort the results by. (default: "price") 
order: The sort order (asc or desc). (default: "asc")

Built With
- Java
- Spring Boot
- h2 database
