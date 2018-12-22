package com.github.sourcefranke.chess960.web.pages;

import static com.github.sourcefranke.chess960.core.ChessPiece.BISHOP;
import static com.github.sourcefranke.chess960.core.ChessPiece.EMPTY;
import static com.github.sourcefranke.chess960.core.ChessPiece.KING;
import static com.github.sourcefranke.chess960.core.ChessPiece.KNIGHT;
import static com.github.sourcefranke.chess960.core.ChessPiece.QUEEN;
import static com.github.sourcefranke.chess960.core.ChessPiece.ROOK;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;

import com.github.sourcefranke.chess960.core.Chess960;
import com.github.sourcefranke.chess960.core.ChessPiece;
import com.github.sourcefranke.chess960.core.rules.BishopsDifferentColorRule;
import com.github.sourcefranke.chess960.core.rules.KingBetweenRooksRule;
import com.github.sourcefranke.chess960.core.rules.Rule;

public class Chess960Page extends WebPage {

	private static final long serialVersionUID = 1L;

	public Chess960Page() {
		add(new Chess960Panel("960panel", new Chess960()));
		
		Chess960 kingAndRooksChess = new Chess960(
				new KingBetweenRooksRule(),
				Arrays.asList(KING, ROOK, ROOK, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY)
			);
		add(new Chess960Panel("kingAndRooksRulePanel", kingAndRooksChess));
		
		Chess960 bishopsChess = new Chess960(
				new BishopsDifferentColorRule(),
				Arrays.asList(BISHOP, BISHOP, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY)
			);
		add(new Chess960Panel("bishopsRulePanel", bishopsChess));
		
		Chess960 othersChess = new Chess960(
				new TrueRule(),
				Arrays.asList(QUEEN, KNIGHT, KNIGHT, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY)
			);
		add(new Chess960Panel("othersPanel", othersChess));
	}
	
	private class TrueRule implements Rule {
		private static final long serialVersionUID = 1L;

		@Override
		public boolean validate(List<ChessPiece> position) {
			return true;
		}
	}
}
