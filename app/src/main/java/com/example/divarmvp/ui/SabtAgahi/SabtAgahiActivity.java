package com.example.divarmvp.ui.SabtAgahi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.divarmvp.R;
import com.example.divarmvp.dagger.Component.DaggerSabtAgahiComponent;
import com.example.divarmvp.dagger.Module.SabtAgahiModule;
import com.example.divarmvp.databinding.ActivityHomeBinding;
import com.example.divarmvp.databinding.ActivitySabtAgahiBinding;
import com.example.divarmvp.room.entity.Product;

import javax.inject.Inject;

public class SabtAgahiActivity extends AppCompatActivity implements SabtAgahiConstract.View {

    @Inject
    SabtAgahiPresenter presenter;

    ActivitySabtAgahiBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySabtAgahiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DaggerSabtAgahiComponent.builder().sabtAgahiModule(new SabtAgahiModule(this)).build().inject(this);

        binding.btnsabt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onAddProduct();
            }
        });
        binding.imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickBack();
            }
        });
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public Product getDetails() {

        String name = binding.etname.getText().toString();
        String value = binding.etvalue.getText().toString();
        String time = binding.ettime.getText().toString();
        String numberPhone = binding.etnumberPhone.getText().toString();
        String details = binding.etdetails.getText().toString();

        return new Product(0,name,value,time,R.drawable.nophoto,details,numberPhone);
    }

    @Override
    public void errorName() {
        binding.etname.setError("?????? ?????????? ???????? ???????? ?????????? 3 ?????? ????????.");
    }

    @Override
    public void errorValue() {
        binding.etvalue.setError("???????? ???? ???????? ????????.");

    }

    @Override
    public void errorTime() {
        binding.ettime.setError("?????? ???????? ???? ???????? ????????.");

    }

    @Override
    public void errorNumberPhone() {
        binding.etnumberPhone.setError("?????????? ???????????? ???? ???????? ???????? ????????." + "\n" + "??????????: 09121234567");

    }

    @Override
    public void errorDetails() {
        binding.etdetails.setError("?????? ???????????? ???????? ???????? ?????????? 10 ?????? ????????.");

    }

    @Override
    public Application getcontext() {
        return getApplication();
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void finishSabtAgahi() {
        finish();
    }
}