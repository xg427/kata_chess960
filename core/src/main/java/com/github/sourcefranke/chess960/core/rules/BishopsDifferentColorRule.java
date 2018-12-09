package com.github.sourcefranke.chess960.core.rules;

import static com.github.sourcefranke.chess960.core.ChessPiece.BISHOP;

import java.util.List;

import com.github.sourcefranke.chess960.core.ChessPiece;

/**
 * Restriction for both bishops to be placed on fields of different color
 * 
 * @author sourcefranke
 */
public class BishopsDifferentColorRule implements Rule {

	/**
	 * @see {@link Rule#validate(List)}
	 */
	@Override
	public boolean validate(List<ChessPiece> position) {
		return position.indexOf(BISHOP) % 2 != position.lastIndexOf(BISHOP) % 2 ;
	}
}
