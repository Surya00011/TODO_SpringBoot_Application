ToDo Application - Spring Boot & MySQL 📝🚀
This is a ToDo List application built using Spring Boot, MySQL, and Docker,
It allows users to add, view, update, and delete tasks efficiently,
The application follows the MVC architecture and integrates Thymeleaf for the front-end.

🔹 Features
✅ Add new tasks
✅ View all tasks
✅ Search tasks by ID
✅ Delete tasks
✅ Dockerized for easy deployment
✅ MySQL database integration

🔹 Tech Stack
Backend: Spring Boot, Java
Database: MySQL
Frontend: Thymeleaf, HTML, CSS
Build Tool: Maven
Containerization: Docker

🔹 Installation & Setup
1️⃣ Clone the Repository
2️⃣ Configure MySQL
Update application.properties with your MySQL credentials:
spring.datasource.url=jdbc:mysql://localhost:3306/todoDatabase
spring.datasource.username=root
spring.datasource.password=yourpassword
3️⃣ Build the Project
Install Maven build tool to your local machine,and open project location in cmd promt.
cmd: mvn clean package
4️⃣ Run the Application
java -jar target/ToDo-Application-0.0.1-SNAPSHOT.jar

