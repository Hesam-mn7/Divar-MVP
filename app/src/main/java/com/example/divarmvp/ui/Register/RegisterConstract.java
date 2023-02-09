package com.example.divarmvp.ui.Register;

public interface RegisterConstract {

    interface View {

        String getCode();

        void gotoHomeActivity();

        void allerdialogerror();

        void showMessageDarkhastCode();

        void setNumberPhone();
    }

    interface Presenter {

        void onRegisterr();
        void onDestroy();

    }
}
