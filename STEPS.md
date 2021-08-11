***** BACKEND ****

spring-starter - login-app-backend
define db relationship and ER diagram
create user model 
create repo implement grandteduthority
map relationship
	add getter/setter for role in user!
create userDeatilsService, add @Service
creeate wsecurityConfig, add @Configuration
	load your userDeatils
	expose bcrypt
	mvcmatchers & roles
configure datasource
	mysql
	port number
ensure db is created in mysql
credentials is set up
create controller
	login page to test roles
add user credentials in db
	test by login using roles
	
*** FRONT END ****

components
	login page
	welcome page
	restirctied page
	
https://stackoverflow.com/questions/32019353/adding-a-custom-login-controller-with-spring-security
https://stackoverflow.com/questions/31540476/does-spring-security-require-a-custom-login-controller-when-providing-a-custom-l
https://stackoverflow.com/questions/40033522/how-spring-securitys-custom-login-works
https://www.baeldung.com/spring-security-login
https://docs.spring.io/spring-security/site/docs/3.0.x/reference/core-web-filters.html


run this if u have CORS issue
chrome.exe --user-data-dir="C://Chrome dev session" --disable-web-security