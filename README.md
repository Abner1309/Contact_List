## 🖥 Contact List (Desktop Software)
This project consists of implementing a simple and intuitive desktop application for contact management.

### 🖼 Presentation:
![Main Screen - Light](images/Main-Screen-Light-Theme.png)
![Main Screen - Dark](images/Main-Screen-Dark-Theme.png)

### 💡 Features:
1. Contact registration (Name, Phone, and Email).
2. Editing existing contacts.
3. Active search for registered contacts.
4. Deleting contacts.
5. Theme customization (light/dark).

### ⚙ Technologies Used:
1. Java 21+ (Programming Language).
2. JavaFX 21+ (Framework For Interfaces).
3. Maven (Dependencies Manager).
4. SceneBuilder (FXML Builder).
5. CSS (Styling).
5. SQLite (Local Database).

### 🛠 Instalation:
1. Make sure you have Java 21 or higher installed on your computer.
2. Download the (.jar) file available in the releases tab.
3. Open the terminal and run the command: `java -jar [path]`.
4. Enjoy.

### 📂 Folder Structure:
The project was structured following design patterns to separate business logic from the visual interface:
```text
src/main/java/com/agenda/
 ├── controller/  # Controlling the interface logic (events).
 ├── dao/         # Data access (Persistence).
 ├── model/       # Entity classes (Contact).
 └── view/        # Initialization main class.

src/main/resources/com/agenda/
 ├── css/         # Stylesheets for the interface.
 └── fxml/        # Screen layout files.

