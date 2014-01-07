
# CSCI 1302 - Minesweeper Alpha Project

This repository contains the skeleton code for the Minesweeper Alpha project
assigned to the students in Michael E. Cotterell's Spring 2014 CSCI 1302 class
at the University of Georgia. Please read the entirety of this file before
beginning your project. 

## Academic Honesty

You agree to the Academic Honesty policy as outlined in the course syllabus and
course website. In accordance with this notice, I must caution you to **not** 
fork this repository on GitHub if you have an account. Doing so will more than
likely make your copy of the project publicly visible. Please follow the 
instructions contained in the Resources section below in order to do your 
development on nike.

## Project Description

This first project is meant to ensure that you are able to apply and extend
your prequisite knowledge as well as introduce you to developing and testing
a Java 7 application in a Linux environment (i.e., the Nike development
server). Many aspects of this project will be new to you. You will be asked
to do things that you have never been given explicit directions for before.
This is just a part of software development. Sometimes you need to research
how to solve a problem in order to implement a solution. That being said,
the material included in this document should hopefully answer the majority
of your questions.

Your goal is to develop a non-recursive, non-GUI (GUI = Graphical User 
Interface) version of the game called Minesweeper. The code for this game will
be organized in such a way that the recursive elements of Minesweeper can
be added at a later point in time. It will also be organized so that you can
add a GUI to it later as well. Interestingly, the organization of some of the 
classes in this project will also introduce you to some elementary aspects of
game programming.

This project must be implemented in Java 7, and it must compile and run 
correctly, using SBT (more on SBT later) on Nike.

### Minesweeper Overview

In Minesweeper, the player is initially presented with a grid of 
undifferentiated squares. Either some randomly-selected squares or seed-selected
squares (more on seeds later) are designated to contain mines. Typically, the
size of the grid and the number of mines are set in advance by the user or by a
seed file. The ratio of the number of mines to the grid size is often used as a
measure of an individual game's difficulty. The grid size can also be
represented in terms of the number of rows and columns in the grid.

The game is played in rounds. During each round, the player is presented with
the grid, the number of rounds completed so far, as well as a prompt. The player
has the option to do 5 different things:

 1. Reveal a square on the grid.
 2. Mark a square as potentially containing a mine.
 3. Mark a square as definitely containing a mine.
 4. Display help information.
 5. Quit the game.

When the player reveals a square of the grid, different things can happen. If 
the revealed square contains a mine, then the player loses the game. If the 
revealed square does not contain a mine, then a digit is instead displayed in 
the square, indicating how many adjacent squares contain mines (in the 
recursive implementation, if no mines are adjacent, then the square becomes 
blank). 

The player uses this information to deduce the contents of other squares, and 
may perform any of the first three options in the list presented above. When the
player marks a square as potentially containing a mine, a <code>?</code> is 
displayed in the square. When the player marks the square as definitely 
containing a mine, a flag, represented as <code>F</code> is displayed in the 
square. The player can mark or reveal any square in the grid, even squares that
have already been marked or reveleaed. The logic for determining what happens
to the square is always the same.

The game is won when both all of the mines are located (i.e., all squares 
containing a mine are marked by the user as containing a mine) and when there 
are no squares still marked as potentially containing a mine. At the end of the
game the player is presented with a score. 
Let <code>rows</code>, <code>cols</code>, <code>mines</code>, and 
<code>rounds</code> denote the number of rows in the grid, columns in the grid,
total number of mines, and number of rounds completed, respectively. The 
player's score is calculated as follows:

```java
score = (rows * cols) - mines - rounds;
```

The higher the score, the better. Negative scores are possible.

### The Grid and Interface

In this Minesweeper game, the size of the grid is restricted to no more than 10
rows and 10 columns. The number of rows and columns need not be the same. To be
more precise, the number of rows must be strictly greater than 0 and less than
or equal to 10. The number of columns must also be strictly greater than 0 and
less than or equal to 10. Rows and columns are indexed starting at 0. Therefore,
in a 10*10 (rows * columns), the first row is indexed as 0 and the last row is
indexed as 9 (similarly for columns).

Let's assume we are, in fact, playing a 10*10 game of Minesweeper. When the game
starts, the interface should look like this:

```

 Rounds Completed: 0

 0 |   |   |   |   |   |   |   |   |   |   |
 1 |   |   |   |   |   |   |   |   |   |   |
 2 |   |   |   |   |   |   |   |   |   |   |
 3 |   |   |   |   |   |   |   |   |   |   |
 4 |   |   |   |   |   |   |   |   |   |   |
 5 |   |   |   |   |   |   |   |   |   |   |
 6 |   |   |   |   |   |   |   |   |   |   |
 7 |   |   |   |   |   |   |   |   |   |   |
 8 |   |   |   |   |   |   |   |   |   |   |
 9 |   |   |   |   |   |   |   |   |   |   |
     0   1   2   3   4   5   6   7   8   9

minesweeper-alpha$ 
```

Please note that the first and second-to-last lines are blank. All other lines, 
except the last line containing the prompt, start with one blank space. The line
containing the prompt contains an extra space after the <code>$</code> so that
when the user types in a command, the text does not touch the <code>$</code>.

#### Revealing a Square

#### Help Command


#### Displaying Errors

If the player types in <code>help</code>, 

### Functional Requirements



## Project Tasks


## Extra Credit Tasks


## Directory Structure and Packages


## Build System


## Submission Instructions


## Questions


## Frequently Asked Questions