package com.example.divarmvp.ui.Detail;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.divarmvp.dagger.Component.DaggerDetailComponent;
import com.example.divarmvp.dagger.Module.DetailModule;
import com.example.divarmvp.databinding.ActivityDetailBinding;
import com.example.divarmvp.room.entity.Product;
import com.example.divarmvp.ui.Edit.EditActivity;
import com.google.android.material.snackbar.Snackbar;

import javax.inject.Inject;

public class DetailActivity extends AppCompatActivity implements DetailConstract.View {

    @Inject
    DetailPresenter presenter;
    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DaggerDetailComponent.builder().detailModule(new DetailModule(this)).build().inject(this);

        presenter.setDetailsFromHomeActivity();

        onClickItems();

    }

    private void onClickItems() {
        binding.btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onclickCall();
            }
        });
        binding.btnchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onclickChat();
            }
        });
        binding.imgdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onclickProduct();
            }
        });
        binding.imgedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onclickEdit();
            }
        });
        binding.imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickBack();
            }
        });
        binding.linergozaresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickgozaresh(v);
            }
        });
        binding.linerrahnama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickRahnama(v);
            }
        });
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void setDetails(int id, String name, String value, String details, String numberPhone, String time, int imgid) {

        binding.tvtitlename.setText(name);
        binding.imgdetail.setImageResource(imgid);
        binding.tvnamedetail.setText(name);
        binding.tvvaluedetail.setText(value);
        binding.tvtimedetail.setText(time);
        binding.tvdetails.setText(details);

    }

    @Override
    public String getNumberPhonefromHomeActivity() {
        Intent intent = getIntent();
        return intent.getStringExtra("numberPhone");
    }

    @Override
    public void gotoCall(String numberPhone) {
        Intent intent1 = new Intent();
        intent1.setAction(Intent.ACTION_VIEW);
        intent1.setData(Uri.parse("tel:+" + numberPhone));
        startActivity(intent1);
    }

    @Override
    public void gotoChat(String numberPhone) {
        Intent intent1 = new Intent();
        intent1.setAction(Intent.ACTION_VIEW);
        intent1.setData(Uri.parse("sms:+" + numberPhone));
        startActivity(intent1);
    }

    @Override
    public Product getDetails() {
        final Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String value = intent.getStringExtra("value");
        String time = intent.getStringExtra("time");
        String numberPhone = intent.getStringExtra("numberPhone");
        String details = intent.getStringExtra("details");
        int imgId = intent.getIntExtra("imgId", 0);
        int id = intent.getIntExtra("id", 0);

        return new Product(id, name, value, time, imgId, details, numberPhone);
    }


    @Override
    public int getId() {
        Intent intent = getIntent();
        return intent.getIntExtra("id", 0);
    }

    @Override
    public Application getContext() {
        return getApplication();
    }

    @Override
    public void showMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void finishActivity() {
        finish();
    }

    @Override
    public void allertdilodDelete() {
        AlertDialog alertDialog;
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("آیا مطمئنید که آگهی حذف شود ؟");
        builder.setPositiveButton("بله", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.deleteProduct();
            }
        });
        builder.setNegativeButton("خیر", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public void intentDetailtoEditActivity(int id, String name, String value, String details, String numberPhone, String time, int imgid) {

        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("value", value);
        intent.putExtra("time", time);
        intent.putExtra("numberPhone", numberPhone);
        intent.putExtra("details", details);
        intent.putExtra("imgId", imgid);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    @Override
    public void showMessageWithSnackBar(String msg, View view) {
        Snackbar.make(view , msg , Snackbar.LENGTH_SHORT).show();
    }


}