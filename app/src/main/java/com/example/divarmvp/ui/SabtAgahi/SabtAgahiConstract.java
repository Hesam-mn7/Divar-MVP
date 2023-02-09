package com.example.divarmvp.ui.SabtAgahi;

import android.app.Application;

import com.example.divarmvp.room.entity.Product;

public interface SabtAgahiConstract {

    interface View {

        Product getDetails();

        void errorName();
        void errorValue();
        void errorTime();
        void errorNumberPhone();
        void errorDetails();

        Application getcontext();

        void showMessage(String msg);

        void finishSabtAgahi();
    }

    interface Presenter {

        void onAddProduct();

        void onClickBack();

        void onDestroy();
    }


}
