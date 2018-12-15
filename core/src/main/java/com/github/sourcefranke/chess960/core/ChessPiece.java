package com.github.sourcefranke.chess960.core;

/**
 * Set of pieces in a chess game
 * 
 * @author sourcefranke
 */
public enum ChessPiece {
	
	KING('K'), QUEEN('Q'), ROOK('R'), KNIGHT('N'), BISHOP('B'), EMPTY(' ');
	
	private char symbol;
	
	private ChessPiece(char symbol) {
		this.symbol = symbol;
	}
	
	/**
	 * @return the character representation of the given piece
	 */
	public char getSymbol() {
		return symbol;
	}
}
