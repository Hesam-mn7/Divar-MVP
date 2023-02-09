package com.example.divarmvp.ui.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.divarmvp.Adapter.ProductAdapter;
import com.example.divarmvp.dagger.Component.DaggerHomeComponent;
import com.example.divarmvp.dagger.Module.HomeModule;
import com.example.divarmvp.databinding.ActivityHomeBinding;
import com.example.divarmvp.room.entity.Product;
import com.example.divarmvp.ui.SabtAgahi.SabtAgahiActivity;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import javax.inject.Inject;

public class HomeActivity extends AppCompatActivity implements HomeConstract.View {

    @Inject
    HomePresenter presenter;

    ActivityHomeBinding binding;


    ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new ProductAdapter(this);

        binding.recycleview.setLayoutManager(new LinearLayoutManager(this));
        binding.recycleview.setAdapter(adapter);


        presenter.onLoadRecycleView();

        onClickNavigation();

        onclcketSearch();

    }

    private void onClickNavigation() {
        binding.btsabt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onclickSabtAgahi();
            }
        });
        binding.btchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onclickButtons(v);
            }
        });
        binding.btdasteha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onclickButtons(v);
            }
        });
        binding.btdivareman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onclickButtons(v);
            }
        });
    }

    private void onclcketSearch() {

        binding.etsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.onChangeEditSearch(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void gotoSabtAgahiActivity() {
        startActivity(new Intent(this, SabtAgahiActivity.class));
    }

    @Override
    public Application getContext() {
        return getApplication();
    }

    @Override
    public void refreshRecyclerView(List<Product> products) {
        adapter.setList(products);
    }

    @Override
    public void changeSearch(CharSequence s) {
        adapter.getFilter().filter(s);
    }

    @Override
    public void showMessage(String msg, View v) {
        Snackbar.make(v,msg, Snackbar.LENGTH_SHORT).show();
    }

}