package com.example.application.views.list.InfoViews;

import com.example.application.views.list.User;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("intro") 
@PageTitle("Intro | macroio")
@AnonymousAllowed
public class IntroPage extends VerticalLayout {

    protected static String username;
    Binder<User> beanBinder = new Binder<User>();
    TextField nameField = new TextField();

	public IntroPage(){
		setSizeFull(); 
		setAlignItems(Alignment.CENTER);
		setJustifyContentMode(JustifyContentMode.CENTER);

        
        nameField.setLabel("Enter your name");
        nameField.setValue("Mickey Mouse");
        nameField.setClearButtonVisible(true);
        nameField.setRequired(true);
        
        add(new H1("Let's learn a bit about you"), nameField);
        bindToBean();

        nameField.addValueChangeListener(event -> {
            IntroPage.username = event.getValue();
            System.out.println(IntroPage.username + " in");
        });

        Button continueButton = new Button("Continue");
        continueButton.addClickListener( e -> {
            System.out.println(IntroPage.username + " cont");

            do {
                System.out.println("bleh");
                if(IntroPage.username.length() > 0) {
                    UI.getCurrent().navigate(InfoPage1.class);
                    break;
                } else {
                    bindToBean();
                }
            } while (IntroPage.username.length() > 0); 
        });

        add(continueButton);

	}

    private void bindToBean() {
        beanBinder.forField(nameField)
        .asRequired("Name is required")
        .withValidator(nameField -> nameField.length() > 0,"Name should be at least 1 character long").bind(User::getName, User::setName);
    }
}