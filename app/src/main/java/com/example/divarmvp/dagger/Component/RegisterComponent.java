package com.example.divarmvp.dagger.Component;

import com.example.divarmvp.dagger.Module.RegisterModule;
import com.example.divarmvp.ui.Register.RegisterActivity;

import dagger.Component;

@Component(modules = RegisterModule.class)
public interface RegisterComponent {

    void inject(RegisterActivity registerActivity);
}
