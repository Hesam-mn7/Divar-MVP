package com.example.divarmvp.dagger.Component;

import com.example.divarmvp.dagger.Module.DetailModule;
import com.example.divarmvp.ui.Detail.DetailActivity;

import dagger.Component;

@Component(modules = DetailModule.class)
public interface DetailComponent {

    void inject(DetailActivity activity);
}
