package com.github.sourcefranke.chess960.core.rules;

import static com.github.sourcefranke.chess960.core.ChessPiece.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.github.sourcefranke.chess960.core.ChessPiece;

@RunWith(Parameterized.class)
public class KingBetweenRooksRuleTest {

	private KingBetweenRooksRule rule = new KingBetweenRooksRule();
	
	private List<ChessPiece> position;
	private boolean expectedResult;
	
	public KingBetweenRooksRuleTest(List<ChessPiece> position, boolean expectedResult) {
		this.position = position;
		this.expectedResult = expectedResult;
	}
	
	@Test
	public void test() {
		Assert.assertEquals(expectedResult, rule.validate(position));
	}
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
             { Arrays.asList(BISHOP, ROOK, KING, QUEEN, ROOK), true },
             { Arrays.asList(ROOK, BISHOP, QUEEN, KING, ROOK), true },
	         { Arrays.asList(ROOK, ROOK, KING), false },
	         { Arrays.asList(KING, ROOK, ROOK), false },
	         { Arrays.asList(ROOK, BISHOP, ROOK, KING), false },
	         { Arrays.asList(KING, QUEEN, ROOK, KNIGHT, ROOK), false }
           });
    }
}
