package com.example.divarmvp.ui.Login;

public interface LoginConstract {

    interface View {

        String getNumberPhone();

        void goToAnotherActivity();
        void goToHomeActivityy();

        void setPrefernce(String key, String value);

        void showNotification();

        void showAlerDialogError();

        String getSharedPreference(String key);
    }

    interface Presenter{

        void onRegister();
        void onCheckBeforRegister();
        void onDestroy();

    }
}
