package com.example.divarmvp.dagger.Module;

import com.example.divarmvp.ui.Home.HomeConstract;
import com.example.divarmvp.ui.Home.HomePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {
    HomeConstract.View view;

    public HomeModule(HomeConstract.View view) {
        this.view = view;
    }
    @Provides
    public HomePresenter ProvideHomePresener(){
        return new HomePresenter(view);
    }

}
