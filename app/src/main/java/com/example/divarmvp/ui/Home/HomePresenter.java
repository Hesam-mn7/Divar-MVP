package com.example.divarmvp.ui.Home;

import android.view.View;

import com.example.divarmvp.R;
import com.example.divarmvp.room.AppDatabase;
import com.example.divarmvp.room.entity.Product;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HomePresenter implements HomeConstract.Presenter
{

    HomeConstract.View view;

    public HomePresenter(HomeConstract.View view) {
        this.view = view;
    }

    @Override
    public void onclickSabtAgahi() {
        view.gotoSabtAgahiActivity();
    }

    @Override
    public void onLoadRecycleView() {
        AppDatabase.getInstance(view.getContext()).getProductDao().select()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Product>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<Product> products) {
                        view.refreshRecyclerView(products);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    public void onChangeEditSearch(CharSequence s) {
        view.changeSearch(s);
    }

    public void onclickButtons(View v) {
        view.showMessage("این قسمت در دست ساخت می باشد!",v);
    }
}
