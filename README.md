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

> Replace these placeholders with your screenshots.

| Home |
|------|
| ![](assets/screenshots/home.png) |

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

## 📄 License

This project is licensed under the MIT License.

---

<div align="center">

Made with ☕, Java and a lot of pastel.

**GitHub:** https://github.com/stellarDynamite

</div>
