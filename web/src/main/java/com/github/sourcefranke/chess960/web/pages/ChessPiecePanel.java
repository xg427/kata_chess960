package com.github.sourcefranke.chess960.web.pages;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import com.github.sourcefranke.chess960.core.ChessPiece;

public class ChessPiecePanel extends Panel {

	private static final long serialVersionUID = 1L;

	public ChessPiecePanel(String id, IModel<ChessPiece> model, Color color) {
		super(id, model);
		
		String picString = null;
		
		switch (model.getObject()) {
			case KING:
				picString = "king.svg.png";
				break;
			case QUEEN:
				picString = "queen.svg.png";
				break;
			case ROOK:
				picString = "rook.svg.png";
				break;
			case KNIGHT:
				picString = "knight.svg.png";
				break;
			case BISHOP:
				picString = "bishop.svg.png";
				break;
		}
		Image img = new Image("piece", picString);
		img.add(new AttributeModifier("height", "50px"));
		img.add(new AttributeModifier("width", "50px"));
		
		String colorString = "";
		switch (color) {
			case WHITE:
				colorString = "white";
				break;
			case BLACK:
				colorString = "gray";
				break;
		}
		
		WebMarkupContainer container = new WebMarkupContainer("container");
		container.add(AttributeModifier.append("style", "background-color:" + colorString));
		container.add(img);
		
		add(container);
	}

}
