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

@Route("info5") 
@PageTitle("Info5 | macroio")
@AnonymousAllowed
public class InfoPage5 extends VerticalLayout {

    protected static String password = "";
    Binder<User> beanBinder = new Binder<>();
    TextField passwordField = new TextField();

    public InfoPage5 () {
        setSizeFull(); 
		setAlignItems(Alignment.CENTER);
		setJustifyContentMode(JustifyContentMode.CENTER);

        passwordField.setLabel("Enter password");
        passwordField.setRequired(true);

		add(new H1("Create a password for your account"), passwordField);
        bindToBean();

        passwordField.addValueChangeListener(event -> {
            InfoPage5.password = event.getValue();
            System.out.println(InfoPage5.password + " in");
        });

        Button continueButton = new Button("Continue");
        continueButton.addClickListener( e -> {
            System.out.println(InfoPage5.password + " cont");

            do {
                System.out.println("bluh");
                if(InfoPage5.password.length() >= 8) {
                    UI.getCurrent().navigate(InfoPage6.class);
                    break;
                } else {
                    bindToBean();
                }
            } while (InfoPage5.password.length() >= 8); 
        });
        add(continueButton);

    }

    private void bindToBean() {
        beanBinder.forField(passwordField)
        .asRequired("A password is required")
        .withValidator(passwordField -> passwordField.length() >= 8,"Your password must be at least 8 characters").bind(User::getPassword, User::setPassword);
    }

}