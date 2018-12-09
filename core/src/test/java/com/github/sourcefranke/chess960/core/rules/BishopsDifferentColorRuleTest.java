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
public class BishopsDifferentColorRuleTest {

	private BishopsDifferentColorRule rule = new BishopsDifferentColorRule();
	
	private List<ChessPiece> position;
	private boolean expectedResult;
	
	public BishopsDifferentColorRuleTest(List<ChessPiece> position, boolean expectedResult) {
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
            { Arrays.asList(ROOK, BISHOP, KING, KNIGHT, QUEEN, ROOK, BISHOP, ROOK), true },
            { Arrays.asList(BISHOP, QUEEN, ROOK, BISHOP, ROOK), true },
	        { Arrays.asList(QUEEN, BISHOP, ROOK, BISHOP, ROOK), false },
	        { Arrays.asList(QUEEN, BISHOP, ROOK, ROOK, KING, BISHOP), false }
           });
    }
}
