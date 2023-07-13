package com.example.application.views.list.InfoViews;

import com.example.application.views.list.User;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("info2") 
@PageTitle("Info2 | macroio")
@AnonymousAllowed
public class InfoPage2 extends VerticalLayout {

    protected static String sex;
    protected static double height;
    protected static double weight;
    Binder<User> beanBinder = new Binder<User>();
    RadioButtonGroup<String> radioGroup = new RadioButtonGroup<>();
    NumberField heightField = new NumberField();
    NumberField weightField = new NumberField();

	public InfoPage2(){
        setSizeFull(); 
		setAlignItems(Alignment.CENTER);
		setJustifyContentMode(JustifyContentMode.CENTER);

        //Sex field
        radioGroup.setLabel("Sex");
        radioGroup.setItems("Female", "Male");
        radioGroup.setRequired(true);

        radioGroup.addValueChangeListener(event -> {
                InfoPage2.sex = event.getValue();
                System.out.println(InfoPage2.sex);
        });

        //Height field
        heightField.setLabel("Height");
        heightField.setValue(100.0);
        Div heightSuffix = new Div();
        heightSuffix.setText("inches");
        heightField.setSuffixComponent(heightSuffix);
        heightField.setRequired(true);

        heightField.addValueChangeListener(event -> {
                InfoPage2.height = event.getValue();
                System.out.println(InfoPage2.height);
        });

        //Weight field
        weightField.setLabel("Weight");
        weightField.setValue(100.0);
        Div weightSuffix = new Div();
        weightSuffix.setText("kilograms");
        weightField.setSuffixComponent(weightSuffix);
        weightField.setRequired(true);

        weightField.addValueChangeListener(event -> {
                InfoPage2.weight = event.getValue();
                System.out.println(InfoPage2.weight);
        });

		add(new H1("A little bit more about you..."), radioGroup, heightField, weightField);
        bindToBean();

        Button continueButton = new Button("Continue");
        continueButton.addClickListener( e -> {
            //takes in selected sex field option
            //InfoPage2.sex = radioGroup.getValue();
            System.out.println(InfoPage2.sex);

            do {
                System.out.println("bloop");
                if (InfoPage2.sex == null || InfoPage2.height == 0 || InfoPage2.weight == 0) {
                    bindToBean();
                } else {
                    UI.getCurrent().navigate(InfoPage3.class);
                    break;
                }
            } while (radioGroup == null || heightField == null || weightField == null);
        });
        add(continueButton);

    }

    private void bindToBean() {
        beanBinder.forField(radioGroup)
        .asRequired("This is required")
        .withValidator(radioGroup -> radioGroup != null, "This is required").bind(User::getSex, User::setSex);

        beanBinder.forField(heightField)
        .asRequired("Height is required")
        .withValidator(heightField -> String.valueOf(heightField).length() > 0,"Your height is required").bind(User::getHeight, User::setHeight);
        
        beanBinder.forField(weightField)
        .asRequired("Weight is required")
        .withValidator(weightField -> String.valueOf(weightField).length() > 0,"Your weight is required").bind(User::getWeight, User::setWeight);
    }

}