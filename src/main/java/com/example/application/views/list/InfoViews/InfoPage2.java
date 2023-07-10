package com.example.application.views.list.InfoViews;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("info2") 
@PageTitle("Info2 | macroio")
@AnonymousAllowed
public class InfoPage2 extends VerticalLayout {

	public InfoPage2(){
        setSizeFull(); 
		setAlignItems(Alignment.CENTER);
		setJustifyContentMode(JustifyContentMode.CENTER);

        //Sex field
        RadioButtonGroup<String> radioGroup = new RadioButtonGroup<>();
        radioGroup.setLabel("Sex");
        radioGroup.setItems("Female", "Male");

        //Height field
        NumberField heightField = new NumberField();
        heightField.setLabel("Height");
        heightField.setValue(100.0);
        Div heightSuffix = new Div();
        heightSuffix.setText("inches");
        heightField.setSuffixComponent(heightSuffix);

        //Weight field
        NumberField weightField = new NumberField();
        weightField.setLabel("Weight");
        weightField.setValue(100.0);
        Div weightSuffix = new Div();
        weightSuffix.setText("kilograms");
        weightField.setSuffixComponent(weightSuffix);

		add(new H1("A little bit more about you"), radioGroup, heightField, weightField);

        Button continueButton = new Button("Continue");
        continueButton.addClickListener( e -> UI.getCurrent().navigate(InfoPage3.class));
        add(continueButton);

    }
}