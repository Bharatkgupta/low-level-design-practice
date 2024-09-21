# Parking Lot Low Level Design

## Table of Contents

1. [Introduction](#introduction)
2. [Getting Started](#getting-started)
3. [Folder Structure](#folder-structure)
4. [Dependency Management](#dependency-management)
5. [Project Overview](#project-overview)
6. [Directory Structure](#directory-structure)

## Introduction

This is a low-level design implementation of a parking lot system. The system allows users to create parking lots, park vehicles, and manage parking slots.

All functional and non-functional requirements for this LLD are available at [design-a-parking-lot - work@tech](https://workat.tech/machine-coding/practice/design-parking-lot-qm6hwq4wkhp8)

## Getting Started

To get started with the game, follow these steps:

1. Clone the repository using `git clone https://github.com/Bharatkgupta/low-level-design-practice.git`
2. Navigate to the project directory using `cd parking-lot`
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
- `java.time.Instant`
- `java.time.Duration`

## Project Overview

The project provides a simple command-line interface for users to interact with the parking lot system. Users can create parking lots, park vehicles, and manage parking slots.

## Directory Structure

```bash
snake-and-ladder-game
├── src
│   ├── enums
│   │   ├── Color.java
│   │   └── VehicleType.java
│   ├── models
│   │   ├── Bike.java
│   │   ├── Car.java
│   │   ├── Floor.java
│   │   ├── ParkingLot.java
│   │   ├── Slot.java
│   │   ├── Ticket.java
│   │   ├── Truck.java
│   │   └── Vehicle.java
│   ├── services
│   │   ├── FloorLayoutStrategies
│   │   │   ├── EqualRatio.java
│   │   │   ├── FloorLayoutStrategy.java
│   │   │   └── RandomRatio.java
│   │   ├── ParkingStrategies
│   │   │   ├── BestParkingSlot.java
│   │   │   ├── NearestParkingSlot.java
│   │   │   └── ParkingStrategy.java
│   │   ├── ParkingRepository.java
│   │   ├── ParkingService.java
│   │   ├── PaymentGatway.java
│   │   ├── TicketService.java
│   │   └── VehicleFactory.java
│   └── App.java
├── lib
│   └── ... (dependencies)
├── bin
│   └── ... (compiled output files)
└── README.md
```
