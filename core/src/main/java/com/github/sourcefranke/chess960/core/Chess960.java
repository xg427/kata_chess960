package com.github.sourcefranke.chess960.core;

import static com.github.sourcefranke.chess960.core.ChessPiece.BISHOP;
import static com.github.sourcefranke.chess960.core.ChessPiece.KING;
import static com.github.sourcefranke.chess960.core.ChessPiece.KNIGHT;
import static com.github.sourcefranke.chess960.core.ChessPiece.QUEEN;
import static com.github.sourcefranke.chess960.core.ChessPiece.ROOK;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import com.github.sourcefranke.chess960.core.rules.RuleSet;

/**
 * Generator for determining the starting position of a Chess960 game
 * 
 * @author sourcefranke
 */
public class Chess960 implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private RuleSet ruleSet;

	private List<ChessPiece> setOfPieces;
	
	/**
	 * Constructor for configuring default set of pieces and default set of rules
	 */
	public Chess960() {
		this(RuleSet.defaultSet());
	}
	
	/**
	 * Constructor for configuring default set of pieces and custom set of rules
	 * 
	 * @param ruleSet custom set of restrictions for starting positions allowed
	 */
	public Chess960(RuleSet ruleSet) {
		this(ruleSet, Arrays.asList(KING, QUEEN, ROOK, ROOK, KNIGHT, KNIGHT, BISHOP, BISHOP));
	}

	/**
	 * Constructor for configuring custom set of pieces and custom set of rules
	 * 
	 * @param ruleSet custom set of restrictions for starting positions allowed
	 * @param setOfPieces custom set of pieces
	 */
	public Chess960(RuleSet ruleSet, List<ChessPiece> setOfPieces) {
		this.ruleSet = ruleSet;
		this.setOfPieces = setOfPieces;
	}

	/**
	 * Generates the next starting position based on set of pieces and restrictions defined before
	 * 
	 * @return a valid starting position
	 */
	public List<ChessPiece> generate() {
		List<ChessPiece> position = new ArrayList<>(setOfPieces);
		
		do {
			Collections.shuffle(position);
		}
		while(!ruleSet.validate(position));
		
		return position;
	}
	
	/**
	 * main method
	 */
	public static void main(String[] args) {
		Chess960 chess960 = new Chess960();
		
		Stream.iterate(1, i -> ++i).limit(10)
		.map(i -> chess960.generate())
		.forEach(position -> {
			position.stream().forEach(piece -> System.out.print(piece.getSymbol() + " "));
			System.out.print("\n\n");
		});
	}
}
