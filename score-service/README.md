## SCORE SERVICE

If you want to know the customer's credit score, you should use this service.

#### Get Credit Score By SSID
```
GET http://localhost:8081/api/credit-score/{ssid}
Accept: application/json
Content-Type: application/json

RESPONSE: HTTP 200
{
  "scores": 400,
  "success": true
}

RESPONSE: HTTP 400
{
  "success": false,
  "message": "SSID: Must consist of 11 digits."
}

RESPONSE: HTTP 400
{
  "success": false,
  "message": "SSID: The last digit cannot be an odd number."
}
```
