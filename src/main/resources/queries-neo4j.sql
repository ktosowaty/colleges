USING PERIODIC COMMIT 10000 
LOAD CSV WITH HEADERS FROM "file:/C:/Users/Konrad/Desktop/pliki/addresses.csv" AS inof FIELDTERMINATOR ',' 
CREATE (:Address {id: inof.id, province: inof.province, city: inof.city, street: inof.street, 
buildingNumber: inof.buildingNumber, flatNumber: inof.flatNumber, zipCode: inof.zipCode});


USING PERIODIC COMMIT 10000 
LOAD CSV WITH HEADERS FROM "file:/C:/Users/Konrad/Desktop/pliki/colleges.csv" AS inof FIELDTERMINATOR ',' 
CREATE (:College {id: inof.id, name: inof.name, type: inof.type});


USING PERIODIC COMMIT 10000 
LOAD CSV WITH HEADERS FROM "file:/C:/Users/Konrad/Desktop/pliki/groups.csv" AS inof FIELDTERMINATOR ',' 
CREATE (:Group {id: inof.id, number: inof.number, fieldOfStudy: inof.fieldOfStudy, 
creationDate: inof.creationDate, semester: inof.semester});


USING PERIODIC COMMIT 10000 
LOAD CSV WITH HEADERS FROM "file:/C:/Users/Konrad/Desktop/pliki/teachers.csv" AS inof FIELDTERMINATOR ',' 
CREATE (:Teacher {id: inof.id, firstName: inof.firstName, lastName: inof.lastName, birthDate: inof.birthDate, 
sex: inof.sex, degree: inof.degree});


USING PERIODIC COMMIT 10000 
LOAD CSV WITH HEADERS FROM "file:/C:/Users/Konrad/Desktop/pliki/students.csv" AS inof FIELDTERMINATOR ',' 
CREATE (:Student {id: inof.id, firstName: inof.firstName, lastName: inof.lastName, birthDate: inof.birthDate, 
sex: inof.sex, studentCardNumber: inof.studentCardNumber});


USING PERIODIC COMMIT 10000 
LOAD CSV WITH HEADERS FROM "file:/C:/Users/Konrad/Desktop/pliki/belongsTo.csv" AS inof FIELDTERMINATOR ',' 
MATCH (group: Group { id: inof.groupId}),(college: College { id: inof.collegeId}) 
CREATE (group)-[:belongs_to {}]->(college);


USING PERIODIC COMMIT 10000 
LOAD CSV WITH HEADERS FROM "file:/C:/Users/Konrad/Desktop/pliki/knows.csv" AS inof FIELDTERMINATOR ',' 
MATCH (student1: Student { id: inof.student1Id}),(student2: Student { id: inof.student2Id}) 
CREATE (student1)-[:knows { since: inof.since }]->(student2);


USING PERIODIC COMMIT 10000 
LOAD CSV WITH HEADERS FROM "file:/C:/Users/Konrad/Desktop/pliki/livesStudent.csv" AS inof FIELDTERMINATOR ',' 
MATCH (student: Student { id: inof.studentId}),(address: Address { id: inof.addressId}) 
CREATE (student)-[:lives {}]->(address);


USING PERIODIC COMMIT 10000 
LOAD CSV WITH HEADERS FROM "file:/C:/Users/Konrad/Desktop/pliki/livesTeacher.csv" AS inof FIELDTERMINATOR ',' 
MATCH (teacher: Teacher { id: inof.teacherId}),(address: Address { id: inof.addressId}) 
CREATE (teacher)-[:lives {}]->(address);


USING PERIODIC COMMIT 10000 
LOAD CSV WITH HEADERS FROM "file:/C:/Users/Konrad/Desktop/pliki/isEstablished.csv" AS inof FIELDTERMINATOR ',' 
MATCH (college: College { id: inof.collegeId}),(address: Address { id: inof.addressId}) 
CREATE (college)-[:is_established {}]->(address);


USING PERIODIC COMMIT 10000 
LOAD CSV WITH HEADERS FROM "file:/C:/Users/Konrad/Desktop/pliki/attends.csv" AS inof FIELDTERMINATOR ',' 
MATCH (student: Student { id: inof.studentId}),(group: Group { id: inof.groupId}) 
CREATE (student)-[:attends {}]->(group);


USING PERIODIC COMMIT 10000 
LOAD CSV WITH HEADERS FROM "file:/C:/Users/Konrad/Desktop/pliki/teaches.csv" AS inof FIELDTERMINATOR ',' 
MATCH (teacher: Teacher { id: inof.teacherId}),(group: Group { id: inof.groupId}) 
CREATE (teacher)-[:teaches { subject: inof.subject, hours: inof.hours }]->(group);


CREATE INDEX ON :Student(studentCardNumber);


CREATE CONSTRAINT ON (group:Group) ASSERT group.number IS UNIQUE;


MATCH (student1: Student {firstName: 'Jan', lastName: 'Kowalski'}),(student2: Student {firstName: 'Damian', lastName: 'Nowak'}), 
path = shortestPath((student1)-[:knows*]-(student2)) RETURN path;

MATCH (student1: Student {firstName: 'Jan', lastName: 'Kowalski'}),(student2: Student {firstName: 'Damian', lastName: 'Nowak'}), 
path = shortestPath((student1)-[:knows*]-(student2)) RETURN length(path);


MATCH (teacher: Teacher {firstName: 'Piotr', lastName: 'Nowak'})-[:teaches*]->(group: Group)<-[:attends*]-(student: Student {firstName: 'Tomasz', lastName: 'Krawczyk'}) RETURN group;


MATCH path = (student1: Student {firstName: 'Tomasz', lastName: 'Kowalski'})-[:knows*1..3]-(student2: Student) WHERE length(path) = 2
WITH student2 MATCH (student2)-[:attends]->(group: Group) WHERE group.number IN ['UZ8N2', 'UZ9N2'] RETURN student2;


MATCH (student: Student)-[:attends]-(group: Group)-[:belongs_to]-(college: College) 
WITH college, count(student) AS studentNumber WHERE studentNumber > 120 RETURN college;

MATCH (student: Student)-[:attends]-(group: Group) 
WITH group, count(student) AS studentNumber WHERE studentNumber < 10 RETURN group, studentNumber;


CALL algo.pageRank.stream('Student', 'knows', {iterations:20, dampingFactor:0.85}) 
YIELD nodeId, score RETURN algo.asNode(nodeId).studentCardNumber AS student, score ORDER BY score DESC;