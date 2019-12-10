CREATE TABLE College( 
	id Int Identity(1,1), 
	name VARCHAR(255), 
	type VARCHAR(255) ) AS NODE;

CREATE TABLE [Group]( 
	id Int Identity(1,1), 
	number VARCHAR(255), 
	fieldOfStudy VARCHAR(255), 
	creationDate Date, 
	semester Int ) AS NODE;
	
CREATE TABLE Teacher( 
	id Int Identity(1,1), 
	firstName VARCHAR(255), 
	lastName VARCHAR(255), 
	birthDate Date, 
	sex VARCHAR(10), 
	degree VARCHAR(20) ) AS NODE;

CREATE TABLE Student( 
	id Int Identity(1,1), 
	firstName VARCHAR(255), 
	lastName VARCHAR(255), 
	birthDate Date, 
	sex VARCHAR(10), 
	studentCardNumber Int ) AS NODE;
	
CREATE TABLE Address( 
	id Int Identity(1,1), 
	province VARCHAR(255), 
	city VARCHAR(255), 
	street VARCHAR(255), 
	buildingNumber Int, 
	flatNumber Int, 
	zipCode VARCHAR(10) ) AS NODE;
	
CREATE TABLE belongs_to AS EDGE; 
CREATE TABLE knows(since Date) AS EDGE; 
CREATE TABLE lives_student AS EDGE; 
CREATE TABLE lives_teacher AS EDGE; 
CREATE TABLE is_established AS EDGE; 
CREATE TABLE attends AS EDGE;
CREATE TABLE teaches(subject VARCHAR(255), hours Int) AS EDGE; 


SELECT student1.firstName, student1.lastName, student2.firstName, student2.lastName 
FROM Student student1, knows, Student student2 
WHERE MATCH(student1-(knows)->student2);


SELECT student.firstName, student.lastName
FROM Student, attends, [Group] 
WHERE MATCH (Student-(attends)->[Group]) AND [Group].number = 'PZ9N2';  


SELECT student.firstName, student.lastName
FROM Student, lives_student, Address  
WHERE MATCH (Student-(lives_student)->Address) AND Address.street = 'Kazury'; 
