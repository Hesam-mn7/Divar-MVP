package com.example.divarmvp.ui.Register;

public class RegisterPresenter implements RegisterConstract.Presenter {

    RegisterConstract.View view;

    public RegisterPresenter(RegisterConstract.View view) {
        this.view = view;
    }

    @Override
    public void onRegisterr() {

        String code = view.getCode();
        if(code.equals("557324")){
            view.gotoHomeActivity();
        }
        else{
            view.allerdialogerror();
        }

    }

    @Override
    public void onDestroy() {
        view=null;
    }


    public void onDarkhast() {

        view.showMessageDarkhastCode();
    }

    public void onsetNumberPhone() {
        view.setNumberPhone();
    }
}
