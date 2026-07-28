<div align="center">

# ✂️ Cutlet

### *Slice media. Not code.*

A modern pastel-themed desktop media converter built with **Java Swing** and powered by **FFmpeg**.

![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge)
![Swing](https://img.shields.io/badge/UI-Java%20Swing-8A6BEA?style=for-the-badge)
![FFmpeg](https://img.shields.io/badge/Powered%20by-FFmpeg-007808?style=for-the-badge)
![Maven](https://img.shields.io/badge/Build-Maven-C71A36?style=for-the-badge)

</div>

---

## 📖 Overview

Cutlet is a desktop media converter that combines the simplicity of a modern Java Swing interface with the power of FFmpeg.

Rather than implementing media processing from scratch, the application communicates with FFmpeg through Java's `ProcessBuilder`, providing a clean graphical interface for common media operations.

---

## ✨ Features

- 🎵 Convert media between supported formats
- 🎧 Extract audio from video files
- 📂 File picker integration
- 🌸 Clean pastel-themed desktop interface
- ⚡ FFmpeg integration using Java's `ProcessBuilder`
- 📦 Maven project structure

---

## 📸 Screenshots

<img width="1194" height="672" alt="Screenshot 2026-07-28 at 3 18 49 AM" src="https://github.com/user-attachments/assets/0ba22f77-967c-4b11-879f-0d5a3868089e" />

<img width="280" height="195" alt="Screenshot 2026-07-28 at 3 20 27 AM" src="https://github.com/user-attachments/assets/7c2cbb19-1c19-4e33-b13f-79fdecebca75" />

---

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| Java | Core application |
| Java Swing | Desktop User Interface |
| Maven | Build & Dependency Management |
| FFmpeg | Media Processing |
| ProcessBuilder | Java ↔ FFmpeg Communication |

---

## 🏗️ Project Structure

```text
cutlet
│
├── pom.xml
├── README.md
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── cutlet
│   │   │           ├── Main.java
│   │   │           ├── ffmpeg/
│   │   │           ├── ui/
│   │   │           └── utils/
│   │   │
│   │   └── resources/
│   │
│   └── test/
│
└── target/
```

---

## 🚀 Getting Started

### Prerequisites

- Java 17 or later
- Maven
- FFmpeg installed and available in your system PATH

Verify FFmpeg installation:

```bash
ffmpeg -version
```

---

### Clone the Repository

```bash
git clone https://github.com/stellarDynamite/cutlet.git
```

```bash
cd cutlet
```

---

### Build

```bash
mvn clean compile
```

---

### Run

```bash
mvn exec:java -Dexec.mainClass="com.cutlet.Main"
```

Or run `Main.java` directly from your preferred IDE.

---

## ⚙️ Architecture

```
User
   │
   ▼
Java Swing UI
   │
   ▼
ProcessBuilder
   │
   ▼
FFmpeg
   │
   ▼
Processed Media
```

The UI remains independent from the media-processing engine, making the project modular and easier to maintain.

---

## 🎯 What I Learned

Building Cutlet helped me gain hands-on experience with:

- Java Swing desktop application development
- Maven project organization
- Process management using `ProcessBuilder`
- Integrating external command-line tools into Java applications
- Writing modular and maintainable Java code

---

## 📦 Release

### v1.0.0 — Initial Release

Included:

- Java Swing desktop interface
- FFmpeg integration
- Media conversion
- Audio extraction
- File selection support
- Maven-based project structure

---

<div align="center">

Made with ☕, Java and a lot of pastel.

**GitHub:** https://github.com/stellarDynamite

</div>
