package com.example.divarmvp.ui.Login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.divarmvp.Const;
import com.example.divarmvp.R;
import com.example.divarmvp.dagger.Component.DaggerLoginComponent;
import com.example.divarmvp.dagger.Module.LoginModule;
import com.example.divarmvp.databinding.ActivityLoginBinding;
import com.example.divarmvp.ui.Home.HomeActivity;
import com.example.divarmvp.ui.Register.RegisterActivity;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginConstract.View {

    @Inject
    LoginPresenter presenter;

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DaggerLoginComponent.builder().loginModule(new LoginModule(this)).build().inject(this);

        presenter.onCheckBeforRegister();

        binding.btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onRegister();
            }
        });

    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public String getNumberPhone() {
        return binding.etNumberPhone.getText().toString();
    }

    @Override
    public void goToAnotherActivity() {
        Intent intent = new Intent(this, RegisterActivity.class);
        intent.putExtra("number",binding.etNumberPhone.getText().toString());
        startActivity(intent);

    }

    @Override
    public void goToHomeActivityy() {
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void setPrefernce(String key, String value) {
        SharedPreferences sharedPreferences=getSharedPreferences(Const.SHARED_PREF_NAME , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key , value);
        editor.apply();
    }

    @Override
    public void showNotification() {

        NotificationManager manager = (NotificationManager) getSystemService(Service.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("کد تایید دیوار:");
        builder.setContentText("557324");
        builder.setSmallIcon(R.drawable.divar);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            builder.setChannelId("chanelId");
            NotificationChannel channel = new NotificationChannel("chanelId", "name", NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(channel);
        }

        Notification notification = builder.build();
        manager.notify(1,notification);
    }

    @Override
    public void showAlerDialogError() {
        AlertDialog alertDialogl;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("خطا");
        builder.setIcon(R.drawable.ic_baseline_error_24);
        builder.setMessage("شماره موبایل نامعتبر است.");
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
    public String getSharedPreference(String key) {

        SharedPreferences sharedPreferences = getSharedPreferences(Const.SHARED_PREF_NAME,MODE_PRIVATE);
        if(!sharedPreferences.contains(key)){
            return null;
        }
        return sharedPreferences.getString(key,null);
    }
}