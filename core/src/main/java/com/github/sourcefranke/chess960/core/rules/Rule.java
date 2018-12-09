package com.github.sourcefranke.chess960.core.rules;

import java.io.Serializable;
import java.util.List;

import com.github.sourcefranke.chess960.core.ChessPiece;

/**
 * Interface of implementing restrictions for placing pieces in the starting position of a Chess960 game
 * 
 * @author sourcefranke
 */
public interface Rule extends Serializable {

	/**
	 * @param position current position to be tested for complying the given restriction
	 * @return boolean flag indicating whether or not the restriction was followed
	 */
	boolean validate(List<ChessPiece> position);
}
