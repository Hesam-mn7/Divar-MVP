package com.example.divarmvp.ui.Detail;

import android.app.Application;
import android.view.View;

import com.example.divarmvp.room.entity.Product;

public interface DetailConstract {

    interface View {

        void setDetails(int id, String name, String value, String details, String numberPhone, String time, int imgid);

        String getNumberPhonefromHomeActivity();

        void gotoCall(String numberPhone);

        void gotoChat(String numberPhone);

        Product getDetails();

        int getId();

        Application getContext();

        void showMessage(String s);

        void finishActivity();

        void allertdilodDelete();

        void intentDetailtoEditActivity(int id, String name, String value, String details, String numberPhone, String time, int imgid);

        void showMessageWithSnackBar(String msg , android.view.View view);
    }

    interface Presenter{

        void onDestroy();

        void setDetailsFromHomeActivity();

        void onclickCall();

        void onclickChat();

        void onclickProduct();

        void deleteProduct();

        void onclickEdit();

        void onClickBack();

        void onClickgozaresh(android.view.View v);

        void onClickRahnama(android.view.View v);
    }
}
