package com.github.sourcefranke.chess960.core.rules;

import java.util.ArrayList;
import java.util.List;

import com.github.sourcefranke.chess960.core.ChessPiece;

/**
 * Holds and manages all defined restrictions for starting positions
 * 
 * @author sourcefranke
 */
public class RuleSet implements Rule {
	
	private List<Rule> rules;

	/**
	 * @return the official set of restrictions for starting positions of a Chess960 game
	 */
	public static RuleSet defaultSet() {
		return new RuleSet().add(new KingBetweenRooksRule()).add(new BishopsDifferentColorRule());
	}

	/**
	 * Constructor
	 */
	public RuleSet() {
		rules = new ArrayList<>();
	}
	
	/**
	 * @param rule new restriction to be added to the given set of rules
	 * @return the whole set of restrictions
	 */
	public RuleSet add(Rule rule) {
		rules.add(rule);
		return this;
	}

	/**
	 * @param position current position to be tested for complying all defined restrictions
	 * @return boolean flag indicating whether or not all the restrictions were followed
	 */
	@Override
	public boolean validate(List<ChessPiece> position) {
		return rules.stream().allMatch(rule -> rule.validate(position));
	}
}
