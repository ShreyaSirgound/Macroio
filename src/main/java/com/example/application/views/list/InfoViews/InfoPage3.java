package com.example.application.views.list.InfoViews;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("info3") 
@PageTitle("Info3 | macroio")
@AnonymousAllowed
public class InfoPage3 extends VerticalLayout {

	public InfoPage3(){
		setSizeFull(); 
		setAlignItems(Alignment.CENTER);
		setJustifyContentMode(JustifyContentMode.CENTER);

        CheckboxGroup<String> dietCheck = new CheckboxGroup<>();
        dietCheck.setLabel("Please select all that apply");
        dietCheck.setItems("Vegan", "Vegetarian", "Non-Vegetarian", "Keto", "Pescatarian" );
        dietCheck.select("Vegan");

		add(new H1("What are your dietary preferences?"), dietCheck);

        Button continueButton = new Button("Continue");
        continueButton.addClickListener( e -> UI.getCurrent().navigate(InfoPage5.class));
        add(continueButton);
	}

}