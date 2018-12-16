package com.github.sourcefranke.chess960.core;

import static com.github.sourcefranke.chess960.core.ChessPiece.BISHOP;
import static com.github.sourcefranke.chess960.core.ChessPiece.KING;
import static com.github.sourcefranke.chess960.core.ChessPiece.KNIGHT;
import static com.github.sourcefranke.chess960.core.ChessPiece.QUEEN;
import static com.github.sourcefranke.chess960.core.ChessPiece.ROOK;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.list.mutable.ListAdapter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.github.sourcefranke.chess960.core.rules.RuleSet;

@RunWith(MockitoJUnitRunner.class)
public class Chess960Test {

	@Mock
	private RuleSet ruleSet;
	
	private Chess960 chess960;
	
	@Before
	public void setUp() {
		chess960 = new Chess960(ruleSet);
	}
	
	@Test
	public void test() {
		Mockito.when(ruleSet.validate(Mockito.anyList())).thenReturn(true);
		
		MutableList<ChessPiece> position = ListAdapter.adapt(chess960.generate());
		
		Assert.assertEquals(8, position.size());
		Assert.assertEquals(1, count(position, KING));
		Assert.assertEquals(1, count(position, QUEEN));
		Assert.assertEquals(2, count(position, ROOK));
		Assert.assertEquals(2, count(position, KNIGHT));
		Assert.assertEquals(2, count(position, BISHOP));
	}

	private long count(MutableList<ChessPiece> position, ChessPiece toBeCounted) {
		return position.count(current -> current.equals(toBeCounted));
	}
}
