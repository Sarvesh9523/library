📚 Library Management System (Java CLI)

A Java-based console application for managing library operations such as book management, member management, book issuance, and returns, built using Object-Oriented Programming, HashMaps (O(1) lookup), and File I/O for data persistence.

🚀 Features

📖 Add and manage books

👤 Add and manage members

🔍 Fast book & member lookup using HashMap (O(1))

🔄 Issue and return books with validation

💾 Persistent storage using Java File I/O

🧱 Clean modular OOP architecture

🖥️ Menu-driven Command Line Interface (CLI)

🛠️ Tech Stack

Language: Java

Concepts: OOP, Collections Framework, Exception Handling

Data Structures: HashMap

Persistence: File I/O (BufferedReader / BufferedWriter)

Interface: Command Line (CLI)

🗂️ Project Structure
Library-Management-System/
│
├── Book.java                 # Book entity (Model)
├── Member.java               # Member entity (Model)
├── Library.java              # Business logic layer
├── FileHandler.java          # File I/O & persistence
├── LibraryManagementSystem.java  # Main entry point
├── books.txt                 # Auto-generated book data file
├── members.txt               # Auto-generated member data file
└── README.md

🧠 System Architecture
LibraryManagementSystem (Main)
        |
        v
      Library
     /       \
   Book     Member
        |
   FileHandler


Main → Handles user input & menu

Library → Core business logic

Book / Member → Data models

FileHandler → Persistent storage

⚙️ How It Works

Application starts and loads saved data from files

User interacts through menu-driven CLI

Library performs operations using HashMaps

Data is automatically saved after each operation

On restart, data is restored from files

▶️ How to Run
Prerequisites

Java 8 or higher installed

Steps
git clone https://github.com/your-username/library-management-system.git
cd library-management-system
javac *.java
java LibraryManagementSystem

📈 Performance
Operation	Time Complexity
Book Lookup	O(1)
Member Lookup	O(1)
Issue Book	O(1)
Return Book	O(1)
🧪 Sample Menu
1. Add Book
2. Add Member
3. Issue Book
4. Return Book
5. List Books
6. Exit

🔒 Data Persistence

Uses text files (books.txt, members.txt)

Ensures data is preserved across application restarts

Prevents data loss during crashes or exits

📌 OOP Concepts Used

Encapsulation

Abstraction

Composition

Single Responsibility Principle

Separation of Concerns

🎯 Resume Summary

Developed a Java-based CLI Library Management System using OOP principles, HashMaps for O(1) lookups, and File I/O to ensure data persistence across sessions.

🔮 Future Enhancements

Replace File I/O with Database (MySQL / MongoDB)

Convert to Spring Boot REST API

Add role-based access (Admin / User)

Implement unit testing using JUnit

Add fine calculation system

🤝 Contribution

Contributions are welcome. Feel free to fork the repository and submit a pull request.

📧 Contact

Sarvesh Kumar
📩 Email: sarveshkumar9176@gmail.com

🔗 GitHub: https://github.com/Sarvesh9523

🔗 LinkedIn: https://linkedin.com/in/sarvesh-kumar-IT
