package com.github.sourcefranke.chess960.core.rules;

import java.util.List;

import com.github.sourcefranke.chess960.core.ChessPiece;

import static com.github.sourcefranke.chess960.core.ChessPiece.*;

/**
 * Restriction for the king to be placed between both rooks
 * 
 * @author sourcefranke
 */
public class KingBetweenRooksRule implements Rule {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see {@link Rule#validate(List)}
	 */
	@Override
	public boolean validate(List<ChessPiece> position) {
		return position.indexOf(ROOK) < position.indexOf(KING)
				&& position.indexOf(KING) < position.lastIndexOf(ROOK);
	}
}
