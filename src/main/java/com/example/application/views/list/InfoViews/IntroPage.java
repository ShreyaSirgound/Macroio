package com.example.application.views.list.InfoViews;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("intro") 
@PageTitle("Intro | macroio")
@AnonymousAllowed
public class IntroPage extends VerticalLayout {

	public IntroPage(){
		setSizeFull(); 
		setAlignItems(Alignment.CENTER);
		setJustifyContentMode(JustifyContentMode.CENTER);

		add(new H1("Let's learn a bit about you"));

        TextField name = new TextField();
        name.setLabel("Enter your name");
        name.setValue("Rocket Racoon");
        name.setClearButtonVisible(true);
        add(name);

        Button continueButton = new Button("Continue");
        continueButton.addClickListener( e -> UI.getCurrent().navigate(InfoPage1.class));
        add(continueButton);
	}

}