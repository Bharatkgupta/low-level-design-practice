# Snake and Ladder Game

## Table of Contents

1. [Introduction](#introduction)
2. [Getting Started](#getting-started)
3. [Folder Structure](#folder-structure)
4. [Dependency Management](#dependency-management)
5. [Game Overview](#game-overview)
6. [Directory Structure](#directory-structure)

## Introduction

Snake and Ladder Game is a simple console-based game written in Java. The game is designed for multiple players and allows them to roll multiple dices in one go.

All functional and non-functional requirements for this LLD are available at [snake-and-ladder-game - work@tech](https://workat.tech/machine-coding/practice/snake-and-ladder-problem-zgtac9lxwntg)

## Getting Started

To get started with the game, follow these steps:

1. Clone the repository using `git clone https://github.com/Bharatkgupta/low-level-design-practice.git`
2. Navigate to the project directory using `cd snake-and-ladder-game`
3. Compile the code using `javac -d bin src/models/*.java src/services/*.java src/*.java`
4. Run the game using `java -cp bin App`

## Folder Structure

The project follows the standard Maven folder structure:

- `src`: contains the source code
- `lib`: contains the dependencies
- `bin`: contains the compiled output files

## Dependency Management

The project uses the following dependencies:

- `java.util.List`
- `java.util.Scanner`
- `java.util.UUID`

## Game Overview

The game is designed for multiple players. Each player rolls multiple dices in one go. The game continues until one player reaches the final destination.

## Directory Structure

```bash
snake-and-ladder-game
├── src
│   ├── models
│   │   ├── Board.java
│   │   ├── Dice.java
│   │   ├── Game.java
│   │   ├── Snake.java
│   │   ├── Ladder.java
│   │   └── Player.java
│   ├── services
│   │   ├── CLI.java
│   │   ├── GameService.java
│   │   └── PlayerManager.java
│   └── App.java
├── lib
│   └── ... (dependencies)
├── bin
│   └── ... (compiled output files)
└── README.md
```
