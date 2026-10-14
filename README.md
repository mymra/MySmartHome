# MySmartHome

A console-based Java prototype made for OBJ2000 – Objektorientert programmering 1.

## Features

- Manage lights, a thermostat, and a motion sensor in one smart home.
- Turn individual devices on or off, or turn off all devices.
- Store scheduled times for lights and thermostats.
- Control the existing home through a SmartHome app installed on MyPhone.

Scheduled times are stored and displayed; they do not trigger real-time actions or control physical devices.

## Project structure

- `src/smarthome/` – devices, scheduling, `SmartHome`, the app, and demo classes.
- `src/myphone/` – the phone and basic app classes reused from the course project.

## Running the project

Open the project in IntelliJ IDEA and run `smarthome.MorningDemo` to see the complete morning scenario.

The smaller demos `Task1Demo`, `Task2Demo`, `Task3Demo`, and `Task4Demo` demonstrate the individual development stages.

## Design

`SmartDevice` is an abstract superclass for shared device behaviour. `Light`, `Thermostat`, and `MotionSensor` extend it. `Light` and `Thermostat` also implement `Schedulable`. `SmartHomeApp` extends `App` and controls an existing `SmartHome` instance.
