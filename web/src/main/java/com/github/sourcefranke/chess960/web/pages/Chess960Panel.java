package com.github.sourcefranke.chess960.web.pages;

import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.util.ListModel;

import com.github.sourcefranke.chess960.core.Chess960;
import com.github.sourcefranke.chess960.core.ChessPiece;

public class Chess960Panel extends Panel {

	private static final long serialVersionUID = 1L;
	
	public Chess960Panel(String id, Chess960 chess960) {
		super(id);
		
		IModel<List<ChessPiece>> piecesModel = new ListModel<>(chess960.generate());
		
		ListView<ChessPiece> view = new ListView<ChessPiece>("repeater", piecesModel) {

			private static final long serialVersionUID = 1L;
			
			private Color color = Color.WHITE;

			@Override
			protected void populateItem(ListItem<ChessPiece> item) {
				if(Color.WHITE.equals(color)) {
					color = Color.BLACK;
				}
				else {
					color = Color.WHITE;
				}
				
				item.add(new ChessPiecePanel("piece", item.getModel(), color));
			}
		};
		
		WebMarkupContainer wmc = new WebMarkupContainer("wmc");
		wmc.setOutputMarkupId(true);
		wmc.add(view);
		add(wmc);
		
		AjaxLink<Void> button = new AjaxLink<Void>("button") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				view.setList(chess960.generate());
				target.add(wmc);
			}
		};
		add(button);
	}
}
