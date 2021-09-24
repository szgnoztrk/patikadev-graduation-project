## CUSTOMER SERVICE

If you want to add, delete, update and list **customers** to the system, you should use this service.

#### Create a Customer Resource
```
POST http://localhost:8080/api/customers
Accept: application/json
Content-Type: application/json

{
  "email": "szgnoztrk@gmail.com",
  "fullName": "Sezgin Öztürk",
  "gender": "MALE OR FEMALE",
  "phone": 905343697677,
  "salary": 5000,
  "ssid": 29776973134
}

RESPONSE: HTTP 200 (Created)
```

#### Update a Customer Resource
```
PUT http://localhost:8080/api/customers
Accept: application/json
Content-Type: application/json

{
  "email": "szgnoztrk@gmail.com",
  "fullName": "Sezgin Öztürk",
  "gender": "MALE OR FEMALE",
  "phone": 905343697677,
  "salary": 5000,
  "ssid": 29776973134
}

RESPONSE: HTTP 200 (Updated)
```
#### Delete a Customer Resource
```
DELETE http://localhost:8080/api/customers/{customerID}
Accept: application/json
Content-Type: application/json

RESPONSE: HTTP 200 -> (Deleted)
RESPONSE: HTTP 400 -> (Customer) with ID is not found!
```

#### List Customers Resource
```
GET http://localhost:8080/api/customers
Content-Type: application/json

RESPONSE: HTTP 200
[
  {
    "id": 5,
    "fullName": "Sezgin Öztürk",
    "ssid": "29776973134",
    "email": "szgnoztrk@gmail.com",
    "phone": "905343697677",
    "salary": 5000,
    "gender": "MALE"
  }
]
```

#### Get a Customer by Customer Id Resource
```
GET http://localhost:8080/api/customers/id/{id}
Accept: application/json
Content-Type: application/json

RESPONSE: HTTP 200
{
  "id": 5,
  "fullName": "Sezgin Öztürk",
  "ssid": "29776973134",
  "email": "szgnoztrk@gmail.com",
  "phone": "905343697677",
  "salary": 5000,
  "gender": "MALE"
}

RESPONSE: HTTP 400
{
  "status": 400,
  "message": "Customer with ID({id}) not found!",
  "timestamp": 1632486065001
}
```

#### Get a Customer by Customer SSID Resource
```
GET http://localhost:8080/api/customers/ssid/{ssid}
Accept: application/json
Content-Type: application/json

RESPONSE: HTTP 200
{
  "id": 5,
  "fullName": "Sezgin Öztürk",
  "ssid": "29776973134",
  "email": "szgnoztrk@gmail.com",
  "phone": "905343697677",
  "salary": 5000,
  "gender": "MALE"
}

RESPONSE: HTTP 400
{
  "status": 400,
  "message": "Customer with SSID({ssid}) not found!",
  "timestamp": 1632486065001
}
```

#### Get a Customer by Customer Phone Resource
```
GET http://localhost:8080/api/customers/phone/{phone}
Accept: application/json
Content-Type: application/json

RESPONSE: HTTP 200
{
  "id": 5,
  "fullName": "Sezgin Öztürk",
  "ssid": "29776973134",
  "email": "szgnoztrk@gmail.com",
  "phone": "905343697677",
  "salary": 5000,
  "gender": "MALE"
}

RESPONSE: HTTP 400
{
  "status": 400,
  "message": "Customer with SSID({phone}) not found!",
  "timestamp": 1632486065001
}
```

