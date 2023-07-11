package com.example.application.views.list.InfoViews;

import com.example.application.views.list.DashboardView;
import com.example.application.views.list.User;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("info5") 
@PageTitle("Info5 | macroio")
@AnonymousAllowed
public class InfoPage5 extends VerticalLayout {

	public InfoPage5(){
		setSizeFull(); 
		setAlignItems(Alignment.CENTER);
		setJustifyContentMode(JustifyContentMode.CENTER);

		add(new H1("Woohoo! Your account has been created."));

        Button continueButton = new Button("Time to start on your fitness journey!");
        continueButton.addClickListener( e -> {
			//creates the user account
			User curUser = new User(IntroPage.username, InfoPage1.age, InfoPage2.height, InfoPage2.weight, InfoPage2.sex, InfoPage3.diets, InfoPage4.activity);
			System.out.println(User.userToString(curUser));
			
			//redirects to the dashboard view
			UI.getCurrent().navigate(DashboardView.class);
		});
        add(continueButton);
	}

}