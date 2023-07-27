package com.example.application.views.list.MainViews;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route(value = "dashboard", layout = MainView.class) 
@PageTitle("Dashboard | macroio")
@AnonymousAllowed
public class DashboardView extends AppLayout{

    public DashboardView() {
    }
}
