package com.github.sourcefranke.chess960.core.rules;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.github.sourcefranke.chess960.core.ChessPiece;

public class RuleSetTest {

	private RuleSet ruleSet;
	
	@Before
	public void setUp() {
		ruleSet = new RuleSet();
	}
	
	@Test
	public void oneTrue() {
		ruleSet.add(new TrueRule());
		Assert.assertTrue(ruleSet.validate(new ArrayList<>()));
	}
	
	@Test
	public void oneFalse() {
		ruleSet.add(new FalseRule());
		Assert.assertFalse(ruleSet.validate(new ArrayList<>()));
	}
	
	@Test
	public void oneTrue_oneFalse() {
		ruleSet.add(new TrueRule()).add(new FalseRule());
		Assert.assertFalse(ruleSet.validate(new ArrayList<>()));
	}
	
	@Test
	public void oneFalse_oneTrue() {
		ruleSet.add(new FalseRule()).add(new TrueRule());
		Assert.assertFalse(ruleSet.validate(new ArrayList<>()));
	}
	
	@Test
	public void twoTrue() {
		ruleSet.add(new TrueRule()).add(new TrueRule());
		Assert.assertTrue(ruleSet.validate(new ArrayList<>()));
	}
	
	@Test
	public void twoTrue_oneFalse() {
		ruleSet.add(new TrueRule()).add(new FalseRule()).add(new TrueRule());
		Assert.assertFalse(ruleSet.validate(new ArrayList<>()));
	}
	
	private class TrueRule implements Rule {

		private static final long serialVersionUID = 1L;

		@Override
		public boolean validate(List<ChessPiece> position) {
			return true;
		}
	}
	
	private class FalseRule implements Rule {

		private static final long serialVersionUID = 1L;

		@Override
		public boolean validate(List<ChessPiece> position) {
			return false;
		}
	}
}
