# PTAO-ProjectTextAdventureOop
A Project by Arhan Baltes to test out Object Oriented Programming with Java, by making an adventure game.

## Details

This project was started on 4th of March, but official programming started on the 11th, both in the year 2024.
Git repository started on: 11th of March 2024.

## TO DO

- Write the following commands:
    - Talk ("Speak to a targeted entity") x
    - Attack ("Assault an entity and initiate combat") x
    - Pick Up (Take an item from a location, add it to inventory and remove it from the world) x
    - Drop (Remove an item from the inventory and place it into the world) x
    - Equip (Equip a new item that's either a weapon or armor) x
    - Banish (Banish a creature completely from the realm of existence. For some reason, it only works against the Elder Beast) x
    - Look (Inspects the direction you point towards, or if combined with the word "around", inspect your current location) x
    - Inventory (Checks what is currently in your inventory) x
    - Use (Use an item that's in your inventory) x
    - Save (Saves the game) 
    - Inspect (Inspects a specified item in your inventory.) x
    - ~~Pet (Gives the entity some involuntary headpats.)~~

- Add comments to functions to say how they work

- Create a saving mechanic

- Create a way to allow the banishment spell

- Make the merchant capable of being traded with

## Changelog

### V 0.0.5 - Wanderer
 - Gave the player the ability to move
 - Created GameData to hold any necessary in-game information (A bit like an interchangeable hub)
 - Added collision to grids
 - Fixed a bug where all walls are classified as mountains

### V 0.0.4 - Cartographer
 - Made a method to write the Locations.json file
 - Removed Weather from Location class due to redundancy

### V 0.0.3 - Butler
 - Added org/json to allow Json files to be read.
 - Usage of canonical path to let files be read while the project loads.

### V 0.0.2 - Strife
 - Added Combat Mechanics
 - All Entities now have health
 - Changed the Version notes (It makes more sense to change it to 0.0.x before I actually made a released version at all. Whoops!)

### V 0.0.1 - Dawn

- Project Started
