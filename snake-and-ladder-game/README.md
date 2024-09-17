# Snake and Ladder Game

## Table of Contents

1. [Introduction](#introduction)
2. [Getting Started](#getting-started)
3. [Folder Structure](#folder-structure)
4. [Dependency Management](#dependency-management)
5. [Game Overview](#game-overview)
6. [Gameplay](#gameplay)
7. [Directory Structure](#directory-structure)

## Introduction

Snake and Ladder Game is a simple console-based game written in Java. The game is designed for multiple players and allows them to roll multiple dices in one go.

## Getting Started

To get started with the game, follow these steps:

1. Clone the repository using `git clone https://github.com/your-username/snake-and-ladder-game.git`
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

## Gameplay

Here's a step-by-step guide to play the game:

1. The game starts with each player at the starting position (0).
2. Each player takes turns rolling the dice.
3. The number on the dice determines how many steps the player can move forward.
4. If a player lands on a snake's head, they must move backward to the corresponding number.
5. If a player lands on a ladder's foot, they can move forward to the corresponding number.
6. The game continues until one player reaches the final destination (100).

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
