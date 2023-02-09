package com.example.divarmvp.dagger.Component;


import com.example.divarmvp.dagger.Module.LoginModule;
import com.example.divarmvp.ui.Login.LoginActivity;

import dagger.Component;

@Component(modules = LoginModule.class)
public interface LoginComponent {

    void inject(LoginActivity activity);
}
