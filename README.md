# 🌟 VeilCrypt 🌟  
_Secure your secrets with style!_  

[![Java](https://img.shields.io/badge/Java-17+-orange?style=flat-square&logo=java)](https://www.oracle.com/java/)  
[![Build Status](https://img.shields.io/badge/Build-Passing-brightgreen?style=flat-square)](https://github.com/juhiagarwal2003/VeilCrypt/actions)  
[![Contributions Welcome](https://img.shields.io/badge/Contributions-Welcome-brightgreen?style=flat-square)](#-contributing)  

---

## 🚀 Project Overview  

🔒 **VeilCrypt** is your go-to Java-powered app for safeguarding sensitive files. Forget complex workflows—hide, unhide, and manage files with OTP-secured authentication, all while ensuring your data remains your own.  

### ✨ Features  
- **Email OTP Authentication**: Secure access using one-time passwords sent via email.  
- **File Hiding & Unhiding**: Keep your files invisible from prying eyes.  
- **MySQL Database**: Effortlessly store and retrieve file metadata.  
- **Intuitive Interface**: Command-line simplicity for powerful functionality.  

---

## 🛠️ Project Structure  

```plaintext
VeilCrypt/
├── Main.java         # Entry point for the app
├── service/          # Core application logic
│   ├── SendOTPService.java
│   ├── GenerateOTP.java
│   └── UserService.java
├── dao/              # Database access layer
│   ├── dataDAO.java
│   └── serDAO.java
├── views/            # User interaction layer
│   ├── UserView.java
│   └── Welcome.java
├── model/            # Data structures
│   ├── data.java
│   └── user.java
└── db/
    └── MyConnection.java  # Database connection utilities
```

---

## ⚡ How It Works  

1. **Signup or Login**: Authenticate securely with an OTP sent to your registered email.  
2. **Hide Files**: Select files to hide, and VeilCrypt makes them invisible.  
3. **Unhide Files**: Choose hidden files to restore them to visibility.  
4. **View Hidden Files**: A list of all concealed files is available for review.  

---

## 🛠️ Getting Started  

### Prerequisites  
- **Java JDK 17+**  
- **MySQL Server**  
- **Maven**  

### Installation  
1. Clone the repository:  
   ```bash
   git clone https://github.com/juhiagarwal2003/Veil-Crypt.git
   cd VeilCrypt
   ```  
2. Update the `MyConnection.java` file with your MySQL credentials.  

3. Build the project:  
   ```bash
   mvn clean install
   ```  
4. Run the application:  
   ```bash
   java -cp target/classes Main
   ```  

---

## 🎯 Roadmap  

- [ ] Add GUI for enhanced user experience.  
- [ ] Integrate AES file encryption for an extra layer of security.  
- [ ] Add audit logging to track file activities.  

---

## 🤝 Contributing  

We ❤️ contributions!  

1. Fork the repository.  
2. Create your feature branch: `git checkout -b feature-name`.  
3. Commit your changes: `git commit -m "Add some feature"`.  
4. Push to the branch: `git push origin feature-name`.  
5. Open a pull request.  

---

## 💌 Connect  

📧 Email: [juhiagarwal200379@gmail.com](mailto:juhiagarwal200379@gmail.com)  
🌐 LinkedIn: [Juhi Agarwal](https://www.linkedin.com/in/juhi-agarwal-005b2625a/)  

---

**VeilCrypt**: _Hiding secrets, unveiling possibilities._ 🌟

