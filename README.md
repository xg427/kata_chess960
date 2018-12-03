# Chess960 Kata
This is a proposal for a new kata to be introduced. It's about [Chess960][1], a chess variant with somehow random starting positions.

## About the Kata
The kata is about implementing some algorithm to return a valid starting position for a Chess960 game. Each time the implementation is called, some different position out of the 960 existing possibilities should be returned.

## Rules for starting position
1. The king has to be placed between both rooks
2. The two bishops are not allowed to be placed on squares of the same color
3. All the other pieces can be placed without any restriction

## Hints
For reasons of simplicity you might think of an array of 8 characters to represent all the positions of the pieces at the first row of a chess board from left to right.

The most common characters to refer to single pieces of a chess game are:
* "K": King
* "Q": Queen
* "R": Rook
* "N": Knight
* "B": Bishop
* "P": Pawn (not needed here)

[1]: https://en.wikipedia.org/wiki/Chess960 "Wikipedia: Chess960"
