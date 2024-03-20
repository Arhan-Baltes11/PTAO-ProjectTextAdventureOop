# Project Text Adventure - Commentary

Irrelevant commentary written by Arhan Baltes to explain things about the machinations and incidents learned during the development of this project.

## Introduction

Hey there, I'm Arhan Baltes, as my GitHub account (ArhanBaltes11) suggests. I wrote the code for this initially on the 11th of March, when I barely knew anything about Java. And after the end of this project, I doubt I will still know everything about it, and there may be way better frameworks that can do what I wanted to create, but easier.

The project was created from school as a thing to fill in my portfolio, which I found quite exciting, as I have always wanted to make a game, and I had experimented with text adventures before, with things like Python, C# and even in PHP.

## Why Java

So, it was suggested that everyone use C# for this project, because that's what the school knew best and we had practiced so much on it with the school's online learning environment. When it was discussed on what languages we were told to use, the teacher did say that it must be made in Object-Oriented-Programming, to teach people about classes and how to prevent repetition. I then asked: "Can we also use Java?" to which the teacher said: "Sure, you can! It is OOP, after all!" and that's kind of how it started on my first ever project to write in Java.

I always wanted to write in Java, but, the reason why I even bothered with it was because a few months ago, I told a friend that one of my new year's resolutions was to learn it, then show to him everything I've learned by July. Other than that, I saw that there was many requests for people who did Java programming, and I figured I might as well add that to the belt of experiences.

## WriteLocation.java

When you're looking around the code in the project, one class stands completely out, and that's `WriteLocation.java`. I made it **VERY** specific to fill a .json document with basically the entirety of the game's grid. I had it mapped out on a piece of paper on what should the grid looked like, the types of terrain, what is on it, etc. And, because the grid is basically a 15x15 square, that would mean I have to write "Gridx" (x is the number of the grid square) and it's contents 225 times. And frankly, I was not going to write the same thing with different modifications 224 more times. That'd be crazy! And I'd risk carpal tunnel at age 30!

So, instead, I decided to make a bunch of coordinates first based on the terrain type, what is impassable and what isn't. And because there are a ton of loops, if/else if statements, and a nested loop to repeat and create new columns. 

With all those loops and constantly looping through large arrays, you'd expect performance to drop by a lot. It didn't, surprisingly, and I haven't tried to optimize it ever since.

As for `Locations.json`, I estimated that the amount of characters is around 30000 characters, with 1508 lines of code. When you have to meticulously check each object 