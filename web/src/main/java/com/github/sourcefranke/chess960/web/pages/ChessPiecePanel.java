package com.github.sourcefranke.chess960.web.pages;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import com.github.sourcefranke.chess960.core.ChessPiece;

public class ChessPiecePanel extends Panel {

	private static final long serialVersionUID = 1L;

	public ChessPiecePanel(String id, IModel<ChessPiece> model, Color color) {
		super(id, model);

		Component img;
		String imgId = "piece";
		switch (model.getObject()) {
			case KING:
				img = new Image(imgId, Model.of("king.svg.png"));
				break;
				
			case QUEEN:
				img = new Image(imgId, Model.of("queen.svg.png"));
				break;
				
			case ROOK:
				img = new Image(imgId, Model.of("rook.svg.png"));
				break;
				
			case KNIGHT:
				img = new Image(imgId, Model.of("knight.svg.png"));
				break;
				
			case BISHOP:
				img = new Image(imgId, Model.of("bishop.svg.png"));
				break;
				
			default:
				img = new Image(imgId, Model.of("blank.svg.png"));
		}

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
