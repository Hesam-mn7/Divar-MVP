package com.example.divarmvp.dagger.Module;

import com.example.divarmvp.ui.Edit.EditConstact;
import com.example.divarmvp.ui.Edit.EditPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class EditModule {
    EditConstact.View view;

    public EditModule(EditConstact.View view) {
        this.view = view;
    }

    @Provides
    public EditPresenter ProvideEditPresenter(){
        return new EditPresenter(view);
    }
}
