target\site\jacoco\intex.html 
test cases report

Swagger-Ui
http://localhost:8085/swagger-ui/index.html
username =admin
password = password


Usercontroller
Post=localhost:8085/api/users 
{
"username":"suresh",
"password":"abc",
"role":"ADMIN"
}
Get =localhost:8085/api/Users/{id}
will get users information
update =localhost:8085/api/Users/{id}
update using id

delete= localhost:8085/api/Users/{id}
delete by id

ActivityLogController

Post=localhost:8085/api/activity-logs
{
"user": "admin",
"activity":"running",
"timestamp":"20/01/2025",
"Status":"active"
}

Get= localhost:8085/api/activity-logs
activtiy using id

update=localhost:8085/api/activity-logs/{id}
update using id

delete=localhost:8085/api/activity-logs/{id}
delete using id

WorkoutPlan
Post= localhost:8085/api/workout-plans
{
"name":"gym",
"user":"ADMIN",
"exercises":[
"running",
"jummping"
]
}

get,update,delete =localhost:8085/api/workout-plans/{id"


