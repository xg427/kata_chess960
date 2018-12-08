# Chess960 Kata
This is a proposal for a new kata to be introduced. It's about [Chess960][1], a chess variant with somehow random starting positions.

## About the Kata
The kata is about implementing an algorithm to return a valid starting position for a Chess960 game. Each time the implementation is called, some different position out of the 960 possibilities should be returned.

## Rules for starting position
1. The king must be placed between the two rooks
2. The two bishops must be placed on squares of different colors
3. All the other pieces can be placed without any further restriction

## Hints
For reasons of simplicity you might think of an array (or similar) of 8 characters to represent the order of the pieces from left to right.

The most common characters to refer to single pieces of a chess game are:
* **K**: King
* **Q**: Queen
* **R**: Rook
* **N**: Knight
* **B**: Bishop
* **P**: Pawn (not needed here)

##Examples
Valid results could look like one of these examples here:
* "R N B Q K B N R" (which is also the starting position of "normal" chess)
* "R Q B N K R N B"
* "Q N T B B K N R"


[1]: https://en.wikipedia.org/wiki/Chess960 "Wikipedia: Chess960"
