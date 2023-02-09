package com.example.divarmvp.ui.Detail;

import android.view.View;

import com.example.divarmvp.room.AppDatabase;
import com.example.divarmvp.room.entity.Product;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class DetailPresenter implements DetailConstract.Presenter {

    DetailConstract.View view;

    public DetailPresenter(DetailConstract.View view) {
        this.view = view;
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void setDetailsFromHomeActivity() {
        Product product = view.getDetails();

        int id = product.getId();
        String name = product.getName();
        String value = product.getValue();
        String details = product.getDetails();
        String numberPhone = product.getNumberPhone();
        String time = product.getTime();
        int imgid = product.getImgId();
        view.setDetails(id , name , value , details , numberPhone , time , imgid);
    }

    @Override
    public void onclickCall() {
        String numberPhone = view.getNumberPhonefromHomeActivity();
        view.gotoCall(numberPhone);

    }

    @Override
    public void onclickChat() {
        String numberPhone = view.getNumberPhonefromHomeActivity();
        view.gotoChat(numberPhone);
    }

    @Override
    public void onclickProduct() {

        view.allertdilodDelete();

    }

    @Override
    public void deleteProduct() {

        int id = view.getId();

        AppDatabase.getInstance(view.getContext()).getProductDao().deleteById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        view.showMessage("آگهی شما با موفقیت حذف شد");
                        view.finishActivity();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.showMessage("آگهی شما حذف نشد");

                    }
                });

    }

    @Override
    public void onclickEdit() {
        Product product = view.getDetails();
        int id = product.getId();
        String name = product.getName();
        String value = product.getValue();
        String details = product.getDetails();
        String numberPhone = product.getNumberPhone();
        String time = product.getTime();
        int imgid = product.getImgId();

        view.intentDetailtoEditActivity(id , name , value , details , numberPhone , time , imgid);
    }

    @Override
    public void onClickBack() {
        view.finishActivity();
    }

    @Override
    public void onClickRahnama(View v) {
        view.showMessageWithSnackBar("راهنمای خرید امن",v);
    }

    public void onClickgozaresh(View v) {
        view.showMessageWithSnackBar("گزارش مشکل آگهی",v);
    }
}
