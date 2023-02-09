package com.example.divarmvp.dagger.Component;

import com.example.divarmvp.dagger.Module.SabtAgahiModule;
import com.example.divarmvp.ui.SabtAgahi.SabtAgahiActivity;

import dagger.Component;

@Component(modules = SabtAgahiModule.class)
public interface SabtAgahiComponent {

    void inject(SabtAgahiActivity activity);
}
