package com.example.divarmvp.dagger.Component;

import com.example.divarmvp.dagger.Module.HomeModule;
import com.example.divarmvp.ui.Home.HomeActivity;

import dagger.Component;

@Component(modules = HomeModule.class)
public interface HomeComponent {
    void inject(HomeActivity activity);
}
