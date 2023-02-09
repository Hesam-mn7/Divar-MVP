package com.example.divarmvp.dagger.Module;

import com.example.divarmvp.ui.Login.LoginPresenter;
import com.example.divarmvp.ui.Register.RegisterConstract;
import com.example.divarmvp.ui.Register.RegisterPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class RegisterModule {

    RegisterConstract.View  view;

    public RegisterModule(RegisterConstract.View view) {
        this.view = view;
    }

    @Provides
    public RegisterPresenter ProvideRegisterPresenter(){
        return new RegisterPresenter(view);
    }
}
