# 🔤 Anagram Android Game

An interactive Android word puzzle game where players find anagrams by adding one letter to a base word.

## 📱 What It Does

This Android app presents players with a starter word and challenges them to find as many valid English words as possible by adding exactly one letter to form anagrams. The game uses a comprehensive dictionary to validate words and provides real-time feedback with color-coded results.

### Game Mechanics
- **Objective**: Find words that can be formed by adding one letter to the given base word
- **Validation**: Words must be in the dictionary and cannot contain the base word as a substring
- **Scoring**: Valid words appear in green, invalid attempts in red
- **Dictionary**: Uses a curated word list for validation

## 🛠 Tech Stack

| Component | Technology |
|-----------|------------|
| 📱 Platform | Android (Java) |
| 🎯 Min SDK | API 23 (Android 6.0) |
| 🎯 Target SDK | API 28 (Android 9.0) |
| 🏗️ Build System | Gradle |
| 🎨 UI Framework | AndroidX + Material Design |
| 📚 Libraries | AndroidX AppCompat, Material Components |

## 🚀 Getting Started

### Prerequisites
- Android Studio Arctic Fox or later
- Android SDK 28+
- Java 8+

### Installation & Running

1. **Clone the repository**
   ```bash
   git clone https://github.com/stabgan/Anagram-Android-App.git
   cd Anagram-Android-App
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing project"
   - Navigate to the cloned directory

3. **Build and Run**
   - Connect an Android device or start an emulator
   - Click the "Run" button or press `Shift + F10`

### How to Play

1. **Start Game**: Tap the play button to get a random starter word
2. **Enter Words**: Type words that can be formed by adding one letter to the base word
3. **Submit**: Press Enter or the Go button to check your word
4. **View Results**: Valid words appear in green, invalid ones in red
5. **Get Hints**: Tap the help button to reveal remaining valid words
6. **New Round**: Tap play again for a new challenge

## 📸 Screenshots

<div align="center">
  <img src="Screenshots/Screenshot_1562616174.png" width="250" alt="Game Start Screen"/>
  <img src="Screenshots/Screenshot_1562616238.png" width="250" alt="Gameplay"/>
  <img src="Screenshots/Screenshot_1562616253.png" width="250" alt="Results View"/>
</div>

## 🏗️ Architecture

### Core Components

- **`AnagramsActivity`**: Main game interface handling user input and display
- **`AnagramDictionary`**: Dictionary management and word validation logic
- **`words.txt`**: Comprehensive English word database (asset file)

### Key Algorithms

- **Word Sorting**: Characters sorted alphabetically for anagram matching
- **Dictionary Lookup**: HashMap-based O(1) word validation
- **Anagram Generation**: Efficient filtering of dictionary words by letter patterns

## 🔧 Recent Improvements

- ✅ **Fixed Critical Bug**: Resolved HashMap initialization issue that was clearing word lists
- ✅ **AndroidX Migration**: Updated from deprecated Support Libraries to AndroidX
- ✅ **Dependency Updates**: Modernized build dependencies for better compatibility
- ✅ **Code Optimization**: Improved dictionary loading and anagram matching performance

## 📄 License

Licensed under the Apache License, Version 2.0. This project was originally part of Google's "Learn Programming with Android" coursework.

## 🤝 Contributing

This is an educational project, but improvements are welcome! Feel free to:
- Report bugs or suggest enhancements
- Submit pull requests for code improvements
- Add new features or game modes

---

*Part of the "Mastering Java by making Android games" learning series*