package com.example.application.views.list.InfoViews;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("info4") 
@PageTitle("Info4 | macroio")
@AnonymousAllowed
public class InfoPage4 extends VerticalLayout {

	public InfoPage4(){
		setSizeFull(); 
		setAlignItems(Alignment.CENTER);
		setJustifyContentMode(JustifyContentMode.CENTER);

        MultiSelectListBox<String> activityList = new MultiSelectListBox<>();
        activityList.setItems("Little to no excercise", "Little excercise (1-3 times/week)", "Moderate excercise (3-5 times/week)", "Heavy excercise (6-7 times/week)");
        activityList.select("Little to no excercise");
        add(new H1("How active are you?"), activityList);

        Button continueButton = new Button("Continue");
        continueButton.addClickListener( e -> UI.getCurrent().navigate(InfoPage5.class));
        add(continueButton);
	}

}