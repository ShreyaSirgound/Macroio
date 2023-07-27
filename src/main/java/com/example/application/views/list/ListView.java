package com.example.application.views.list;

import com.example.application.views.list.InfoViews.IntroPage;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("macroio | title")
@Route(value = "")
public class ListView extends VerticalLayout {

    public ListView() {
        setSpacing(false);

        /*
        Image img = new Image("images/empty-plant.png", "placeholder plant");
        img.setWidth("200px");
        add(img);
        
        Button button = new Button("I'm a Button");
        add(button);
        */

        H1 logo = new H1("Macroio");
        logo.addClassNames(Margin.Top.MEDIUM, Margin.Bottom.SMALL);
        add(logo);
        add(new Paragraph("Empower Your Fitness Journey with Precision and Balance!"));

        HorizontalLayout layout = new HorizontalLayout();

        Button loginButton = new Button("Login");
        loginButton.addClickListener( e -> UI.getCurrent().navigate(LoginView.class));
        Button signupButton = new Button("Create an account");
        signupButton.addClickListener( e -> UI.getCurrent().navigate(IntroPage.class));
        layout.add(loginButton);
        layout.add(signupButton);
        add(layout);
    

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }
}
