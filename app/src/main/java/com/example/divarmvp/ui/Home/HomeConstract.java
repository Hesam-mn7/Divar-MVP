package com.example.divarmvp.ui.Home;

import android.app.Application;
import android.view.View;

import com.example.divarmvp.room.entity.Product;

import java.util.List;

public interface HomeConstract {

    interface View {

        void gotoSabtAgahiActivity();

        Application getContext();

        void refreshRecyclerView(List<Product> products);

        void changeSearch(CharSequence s);

        void showMessage(String msg , android.view.View v);
    }

    interface Presenter{

        void onclickSabtAgahi();

        void onLoadRecycleView();

        void onDestroy();

    }
}
