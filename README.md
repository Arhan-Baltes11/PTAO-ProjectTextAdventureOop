# PTAO-ProjectTextAdventureOop
A Project by Arhan Baltes to test out Object Oriented Programming with Java, by making an adventure game.

## Details

This project was started on 4th of March, but official programming started on the 11th, both in the year 2024.
Git repository started on: 11th of March 2024.

## TO DO

- Write the following commands:
    - ~~Pet (Gives the entity some involuntary headpats.)~~

- Add comments to functions to say how they work

- Create a saving mechanic
    - Test Saving Mechanic on the subject of Items on Location.

- Create a way to allow the banishment spell

- Make the merchant capable of being traded with

## Changelog

### V 0.1.1 - Narrator
 - Overhauled most code to now be story based.
 - Fixed several bugs related to non-functioning commands.
 - Added a help command.
 - You will always look around on your current location.
    - You can still look around by command, but that will cause the command to be mentioned twice.

### V 0.1.0 - Sprout
 - First official build compiled
 - Characters can do a great variety of actions, from inspecting items to using them.
 - Creating a saving mechanic. Currently, a known bug is that items will duplicate. Currently still being fixed
 - Save.json created and possible to load or save by typing "load" or "save" in the commands.
 - A possibility to quit the program by typing in "quit"
    - "quit" will give you an additional prompt if you quit without saving.
 - created the banish command has been created. Once you do so, the game officially ends.
    - to banish, type "banish". It only works if you have 3 specific items, and only works on the end boss.
        - "banish" can lead to some unpredictable results.
 - Removed several unnecessary code blocks.
 - Removed RandomEncounters
    - This may be created again in the future. 
 - When exiting the game, you will reload from when you last saved.
    - The save file is found in src/main/java/JsonFiles/Save.json
        - Deleting Save.json will start the game with default parameters.
 - Added Usable items
    - The Healing Potion in your Inventory can now be used to heal you, for instance.

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
