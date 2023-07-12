package com.example.application.views.list.InfoViews;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("info5") 
@PageTitle("Info5 | macroio")
@AnonymousAllowed
public class InfoPage5 extends VerticalLayout {

    protected static String password;

    public InfoPage5 () {
        setSizeFull(); 
		setAlignItems(Alignment.CENTER);
		setJustifyContentMode(JustifyContentMode.CENTER);

        TextField passwordField = new TextField();
        passwordField.setLabel("Enter password");

		add(new H1("Lastly, create a password for your account"), passwordField);

        passwordField.addValueChangeListener(event -> {
            InfoPage5.password = event.getValue();
            System.out.println(InfoPage5.password + " in");
        });

        Button continueButton = new Button("Continue");
        continueButton.addClickListener( e -> {
            System.out.println(InfoPage5.password + " cont");
            UI.getCurrent().navigate(InfoPage6.class);
        });
        add(continueButton);
    }

}