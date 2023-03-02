# spring-boot-basic-fake-auth
This is to simulate a fake login using a username header

Added basic auth for APIs
The Principal object will have the username

The username will be passed as a request header from the UI which will be used for setting up the security context.
Note this mechanism is used to procede with development in the abscence of any Auth integration.
This will allow the APIs to know the user and user details of the logged in user without actually logging in
