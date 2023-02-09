package com.example.divarmvp.dagger.Module;

import com.example.divarmvp.ui.Login.LoginConstract;
import com.example.divarmvp.ui.Login.LoginPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    LoginConstract.View view;

    public LoginModule(LoginConstract.View view) {
        this.view = view;
    }

    @Provides
    public LoginPresenter ProvideLoginPresenter(){
        return new LoginPresenter(view);
    }
}
