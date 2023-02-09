package com.example.divarmvp.ui.Edit;

import com.example.divarmvp.room.AppDatabase;
import com.example.divarmvp.room.entity.Product;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class EditPresenter implements EditConstact.Presenter {

    EditConstact.View view;

    public EditPresenter(EditConstact.View view) {
        this.view = view;
    }

    @Override
    public void setDetailstoEdittext() {
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
    public void onEditAgahi() {

        Product product = view.getnewDetails();

        int id = product.getId();
        String name = product.getName();
        String value = product.getValue();
        String details = product.getDetails();
        String numberPhone = product.getNumberPhone();
        String time = product.getTime();
        int imgid = product.getImgId();

        if (name.length()<3){
            view.errorName();
        }
        else if(value.isEmpty()){
            view.errorValue();
        }
        else if(time.isEmpty()){
            view.errorTime();
        }
        else if ((numberPhone.length() != 11) || !numberPhone.startsWith("0")){
            view.errorNumberPhone();
        }
        else if(details.length()<10){
            view.errorDetails();
        }
        else {
            AppDatabase.getInstance(view.getcontext()).getProductDao().update(product)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new CompletableObserver() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onComplete() {
                            view.showMessage("ویرایش مشخصات با موفقیت انجام شد.");
                            view.gotoHomeActivity();
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            view.showMessage("ویرایش مشخصات انجام نشد.");

                        }
                    });
        }

    }

    @Override
    public void onClickBack() {
        view.finishActivity();
    }

    @Override
    public void onDestroy() {
        view = null;
    }
}
