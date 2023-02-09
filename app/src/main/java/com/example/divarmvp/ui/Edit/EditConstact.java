package com.example.divarmvp.ui.Edit;

import android.app.Application;

import com.example.divarmvp.room.entity.Product;

public interface EditConstact {

    interface View {

        Product getDetails();

        void setDetails(int id, String name, String value, String details, String numberPhone, String time, int imgid);
        
        Product getnewDetails();

        void errorName();

        void errorValue();

        void errorTime();

        void errorNumberPhone();

        void errorDetails();

        Application getcontext();

        void showMessage(String s);

        void gotoHomeActivity();

        void finishActivity();
    }

    interface Presenter {

        void setDetailstoEdittext();

        void onEditAgahi();

        void onClickBack();

        void onDestroy();
    }
}
