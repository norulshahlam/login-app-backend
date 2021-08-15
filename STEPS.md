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
	not authorized page
	
	
	******************************************


*** DOKCERISE MYSQL ***
{HOSTPORT:CONTAINERPORT}

`run!`
	
	 docker run --detach --env MYSQL_ROOT_PASSWORD=root --env MYSQL_DATABASE=login_app --env MYSQL_PASSWORD=root --env MYSQL_USER=admin --name localhost --publish 3306:3306 mysql:8.0.26
	 
`for debug`
	
	docker container ps -a
	docker container stop 
	docker container prune
	docker volume prune
	
`stop all running proceses`

	docker rm $(docker ps -a -q) -f

`run mysql in cli using docker`

	docker exec -it localhost bash

`connect to mysql`

	mysql -u admin -proot
	
`test`

	use login_app;
	show tables;
	select * from login_app.user;


*** DOKCERISE SPRING APP ***



add maven plugin for docker
add dockerfile with config
make sure jdk from spring & dockerfile is same 
change jdbc url: https://stackoverflow.com/questions/51527683/java-net-unknownhostexception-dockerized-mysql-from-spring-boot-application

`create docker`

	docker build . -t login-app-backend
	
or

	use maven pakvage

`push to docker hub`

	docker push norulshahlam/login-app-backend:0.0.1-SNAPSHOT	


`run!`

	docker run -d -p 8000:8000 --name login-app-backend --link localhost:mysql norulshahlam/login-app-backend:0.0.1-SNAPSHOT


*** DOKCERISE REACT APP ***
https://www.youtube.com/watch?v=DSIC3JTQnPs
create Dockerfile and configure
add in main folder
docker ignore

`build`

	docker build -t norulshahlam/login-app-frontend .
	
`run` 

	docker run -it -p 3000:3000 --name login-app-frontend norulshahlam/login-app-frontend:latest
	docker run -it -d -p 80:3000 --name login-app-frontend norulshahlam/login-app-frontend:latest
	
	
***** TEST FULL STACK APP *********

if u cant login due to CORS run this command:

	chrome.exe --user-data-dir="C://Chrome dev session" --disable-web-security

manager role

	username: useruser
	password: useruser

user role

	username: managers
	password: managers
	





******** AWS EC2 *************

initialize docker
https://docs.aws.amazon.com/AmazonECS/latest/developerguide/docker-basics.html





******************** GUIDES *****************************

spring boot, mysql dokcerize
https://www.youtube.com/watch?v=fvEWoy1xOvo&t=932s

unable to listen to port
https://stackoverflow.com/questions/51527683/java-net-unknownhostexception-dockerized-

to check for port information
https://stackoverflow.com/questions/48198/how-can-you-find-out-which-process-is-listening-on-a-tcp-or-udp-port-on-windows

initilize db on spring start
https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto.data-initialization
	
com.mysql.cj.jdbc.exceptions.CommunicationsException: Communications link failure
https://stackoverflow.com/questions/2839321/connect-java-to-a-mysql-database/2840358#2840358
 	
https://stackoverflow.com/questions/32019353/adding-a-custom-login-controller-with-spring-security
https://stackoverflow.com/questions/31540476/does-spring-security-require-a-custom-login-controller-when-providing-a-custom-l
https://stackoverflow.com/questions/40033522/how-spring-securitys-custom-login-works
https://www.baeldung.com/spring-security-login
https://docs.spring.io/spring-security/site/docs/3.0.x/reference/core-web-filters.html

run this if u have CORS issue
chrome.exe --user-data-dir="C://Chrome dev session" --disable-web-security