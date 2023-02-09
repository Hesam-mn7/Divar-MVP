package com.example.divarmvp.ui.Register;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.divarmvp.R;
import com.example.divarmvp.dagger.Component.DaggerRegisterComponent;
import com.example.divarmvp.dagger.Module.RegisterModule;
import com.example.divarmvp.databinding.ActivityRegisterBinding;
import com.example.divarmvp.ui.Home.HomeActivity;

import javax.inject.Inject;

public class RegisterActivity extends AppCompatActivity implements RegisterConstract.View {

    @Inject
    RegisterPresenter presenter;

    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //presenter = new RegisterPresenter(this);
        DaggerRegisterComponent .builder().registerModule(new RegisterModule(this)).build().inject(this);

        presenter.onsetNumberPhone();

        binding.btnvorod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onRegisterr();
            }
        });
        binding.btndarkhast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onDarkhast();
            }
        });
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public String getCode() {
        return binding.etCode.getText().toString();
    }

    @Override
    public void gotoHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void allerdialogerror() {
        AlertDialog alertDialogl;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("خطا");
        builder.setIcon(R.drawable.ic_baseline_error_24);
        builder.setMessage("کد تایید معتبر نیست.");
        builder.setCancelable(true);
        builder.setPositiveButton("تایید", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialogl = builder.create();
        alertDialogl.show();
    }

    @Override
    public void showMessageDarkhastCode() {
        Toast.makeText(this, "درخواست کد برای شما ارسال شد.", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void setNumberPhone() {
        final Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        final String number = intent.getStringExtra("number");
        binding.tozihat.setText(" لطفا کد تاییدی که به شماره "+number+" ارسال شده است را وارد کنید. ");
    }

}