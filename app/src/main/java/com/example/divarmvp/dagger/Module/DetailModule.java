package com.example.divarmvp.dagger.Module;

import com.example.divarmvp.ui.Detail.DetailConstract;
import com.example.divarmvp.ui.Detail.DetailPresenter;
import com.example.divarmvp.ui.Login.LoginPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailModule {

    DetailConstract.View view;

    public DetailModule(DetailConstract.View view) {
        this.view = view;
    }

    @Provides
    public DetailPresenter ProvideDetailPresenter(){
        return new DetailPresenter(view);
    }
}
