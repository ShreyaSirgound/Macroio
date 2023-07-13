package com.example.application.views.list.InfoViews;

import com.example.application.views.list.User;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("info4") 
@PageTitle("Info4 | macroio")
@AnonymousAllowed
public class InfoPage4 extends VerticalLayout {

    protected static String activity = "";
    Binder<User> beanBinder = new Binder<>();
    ListBox<String> activityList = new ListBox<>();

	public InfoPage4(){
		setSizeFull(); 
		setAlignItems(Alignment.CENTER);
		setJustifyContentMode(JustifyContentMode.CENTER);

        activityList.setItems("Little to no excercise", "Little excercise (1-3 times/week)", "Moderate excercise (3-5 times/week)", "Heavy excercise (6-7 times/week)");
        activityList.setValue("Little to no excercise");
        add(new H1("How active are you?"), activityList);

        Button continueButton = new Button("Continue");
        continueButton.addClickListener( e -> {
            //takes in the user's selected activity level
            InfoPage4.activity = activityList.getValue();
            System.out.println(activity);

            do {
                System.out.println("bleep");
                if (InfoPage4.activity == null) {
                    bindToBean();
                } else {
                    UI.getCurrent().navigate(InfoPage5.class);
                    break;
                }
            } while (activityList == null);
        });
        add(continueButton);
	}

    private void bindToBean() {
        beanBinder.forField(activityList)
        .asRequired("Your activity level is required")
        .withValidator(activityList -> activity == null,"Your activity level is required").bind(User::getActivity, User::setActivity);
    }   

}