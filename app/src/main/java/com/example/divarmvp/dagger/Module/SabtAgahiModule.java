package com.example.divarmvp.dagger.Module;

import com.example.divarmvp.ui.SabtAgahi.SabtAgahiConstract;
import com.example.divarmvp.ui.SabtAgahi.SabtAgahiPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class SabtAgahiModule {
    SabtAgahiConstract.View view;

    public SabtAgahiModule(SabtAgahiConstract.View view) {
        this.view = view;
    }

    @Provides
    public SabtAgahiPresenter provideSabtAgahiPresenter(){
        return new SabtAgahiPresenter(view);
    }
}
