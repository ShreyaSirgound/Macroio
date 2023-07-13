package com.example.application.views.list.InfoViews;

import java.util.Set;

import com.example.application.views.list.User;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("info3") 
@PageTitle("Info3 | macroio")
@AnonymousAllowed
public class InfoPage3 extends VerticalLayout {

    protected static Set<String> diets;
    CheckboxGroup<String> dietCheck = new CheckboxGroup<>();
    Binder<User> beanBinder = new Binder<>();

	public InfoPage3(){
		setSizeFull(); 
		setAlignItems(Alignment.CENTER);
		setJustifyContentMode(JustifyContentMode.CENTER);

        dietCheck.setLabel("Please select all that apply");
        dietCheck.setItems("Vegan", "Vegetarian", "Non-Vegetarian", "Keto", "Pescatarian" );
        dietCheck.setRequired(true);

		add(new H1("What are your dietary preferences?"), dietCheck);
        bindToBean();

        Button continueButton = new Button("Continue");
        continueButton.addClickListener( e -> {
            //takes in selected diet preferences from the user
            InfoPage3.diets = dietCheck.getSelectedItems();
            System.out.println(diets);

            do {
                System.out.println("blap");
                if (InfoPage3.diets.isEmpty()) {
                    bindToBean();
                } else {
                    UI.getCurrent().navigate(InfoPage4.class);
                    break;
                }
            } while (dietCheck == null);
        });
        add(continueButton);
	}

    private void bindToBean() {
        beanBinder.forField(dietCheck)
        .asRequired("Your dietary preferences are required")
        .withValidator(dietcheck -> dietCheck.isEmpty(),"Your dietary preferences are required").bind(User::getDiet, User::setDiet);
    }                               //String.valueOf(dietCheck).length() > 0
}