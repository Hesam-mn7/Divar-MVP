package com.example.divarmvp.dagger.Component;

import com.example.divarmvp.dagger.Module.EditModule;
import com.example.divarmvp.ui.Edit.EditActivity;

import dagger.Component;

@Component(modules = EditModule.class)
public interface EditComponent {

    void inject(EditActivity activity);
}
