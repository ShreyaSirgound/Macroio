package com.example.application.views.list.InfoViews;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("info1") 
@PageTitle("Info1 | macroio")
@AnonymousAllowed
public class InfoPage1 extends VerticalLayout {

    protected static int age;

	public InfoPage1(){
		setSizeFull(); 
		setAlignItems(Alignment.CENTER);
		setJustifyContentMode(JustifyContentMode.CENTER);

        NumberField ageField = new NumberField();
        ageField.setLabel("Enter your age");
         Div ageSuffix = new Div();
        ageSuffix.setText("years");
        ageField.setSuffixComponent(ageSuffix);

		add(new H1("How old are you?"), ageField);

        ageField.addValueChangeListener(event -> {
            InfoPage1.age = event.getValue().intValue();
            System.out.println(InfoPage1.age + " in");
        });

        Button continueButton = new Button("Continue");
        continueButton.addClickListener( e -> {
            System.out.println(InfoPage1.age + " cont");
            UI.getCurrent().navigate(InfoPage2.class);
        });
        add(continueButton);

	}

}