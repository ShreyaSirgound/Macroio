package com.example.application.views.list.MainViews;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.component.textfield.TextField;

@Route(value = "account", layout = MainView.class) 
@PageTitle("Account | macroio")
@AnonymousAllowed
public class AccountView extends AppLayout{

    H1 title = new H1("My Account");
    TextField text = new TextField();

    public AccountView(){
        addClassName("account-page");

        Div thing = new Div(title, text);
        setContent(thing);
        
    }
}

    

