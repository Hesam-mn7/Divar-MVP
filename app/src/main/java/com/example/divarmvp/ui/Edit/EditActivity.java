package com.example.divarmvp.ui.Edit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.divarmvp.R;
import com.example.divarmvp.dagger.Component.DaggerEditComponent;
import com.example.divarmvp.dagger.Module.EditModule;
import com.example.divarmvp.databinding.ActivityDetailBinding;
import com.example.divarmvp.databinding.ActivityEditBinding;
import com.example.divarmvp.room.entity.Product;
import com.example.divarmvp.ui.Home.HomeActivity;

import javax.inject.Inject;

public class EditActivity extends AppCompatActivity implements EditConstact.View {

    @Inject
    EditPresenter presenter;
    ActivityEditBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DaggerEditComponent.builder().editModule(new EditModule(this)).build().inject(this);

        presenter.setDetailstoEdittext();

        binding.btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onEditAgahi();
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
        final Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String value = intent.getStringExtra("value");
        String time = intent.getStringExtra("time");
        String numberPhone = intent.getStringExtra("numberPhone");
        String details = intent.getStringExtra("details");
        int imgId = intent.getIntExtra("imgId",0);
        int id = intent.getIntExtra("id",0);

        return new Product(id,name,value,time,imgId,details,numberPhone);
    }

    @Override
    public void setDetails(int id, String name, String value, String details, String numberPhone, String time, int imgid) {
        binding.etname.setText(name);
        binding.etdetails.setText(details);
        binding.etvalue.setText(value);
        binding.ettime.setText(time);
        binding.etnumberPhone.setText(numberPhone);
    }

    @Override
    public Product getnewDetails() {

        final Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);

        String name = binding.etname.getText().toString();
        String value = binding.etvalue.getText().toString();
        String time = binding.ettime.getText().toString();
        String numberPhone = binding.etnumberPhone.getText().toString();
        String details = binding.etdetails.getText().toString();

        return new Product(id,name,value,time,R.drawable.nophoto,details,numberPhone);
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
    public void showMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void gotoHomeActivity() {

        startActivity(new Intent(this, HomeActivity.class));
    }

    @Override
    public void finishActivity() {
        finish();
    }
}