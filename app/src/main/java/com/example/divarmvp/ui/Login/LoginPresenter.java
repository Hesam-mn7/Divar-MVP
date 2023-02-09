package com.example.divarmvp.ui.Login;

import com.example.divarmvp.Const;

public class LoginPresenter implements LoginConstract.Presenter {

    LoginConstract.View view;


    public LoginPresenter(LoginConstract.View view) {
        this.view = view;
    }

    @Override
    public void onRegister() {

        String numberPhone = view.getNumberPhone();

        if( numberPhone.length()==11 && numberPhone.startsWith("0") || numberPhone.length()==10 && !numberPhone.startsWith("0") ){
            view.setPrefernce(Const.SHARED_PERF_KEY_REGISTER , numberPhone);
            view.goToAnotherActivity();
            view.showNotification();
        }
        else{
            view.showAlerDialogError();
        }

        }

    @Override
    public void onCheckBeforRegister() {
        String result = view.getSharedPreference(Const.SHARED_PERF_KEY_REGISTER);
        if (result != null){
            view.goToHomeActivityy();
        }
    }

    @Override
    public void onDestroy() {
        view = null;
    }
}
