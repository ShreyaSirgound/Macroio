package com.example.application.views.list.InfoViews;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("info1") 
@PageTitle("Info1 | macroio")
@AnonymousAllowed
public class InfoPage1 extends VerticalLayout {

	public InfoPage1(){
		setSizeFull(); 
		setAlignItems(Alignment.CENTER);
		setJustifyContentMode(JustifyContentMode.CENTER);

        ComboBox<String> comboBox = new ComboBox<>("Enter birth year");
        comboBox.setAllowCustomValue(true);
        add(comboBox);
        comboBox.setItems("2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006");
        comboBox.getStyle().set("--vaadin-combo-box-width", "550px");

		add(new H1("What year were you born?"), comboBox);

        Button continueButton = new Button("Continue");
        continueButton.addClickListener( e -> UI.getCurrent().navigate(InfoPage2.class));
        add(continueButton);
	}

}