package com.example.divarmvp.ui.SabtAgahi;

import com.example.divarmvp.Const;
import com.example.divarmvp.R;
import com.example.divarmvp.room.AppDatabase;
import com.example.divarmvp.room.entity.Product;
import com.example.divarmvp.ui.Login.LoginPresenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SabtAgahiPresenterTest {

    SabtAgahiPresenter presenter;

    @Mock
    SabtAgahiConstract.View viewMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new SabtAgahiPresenter(viewMock);
    }

    @After
    public void shutDown() {
        presenter = null;
    }

    @Test
    public void onAddProduct_incorrectName() {

        //Arrange
        String name = "";
        String value = "توافقی";
        String details = "ارزان و کارکرده در حد نو و سالم و تمیز";
        String numberPhone = "09198067831";
        String time = "لحظاتی پیش در سعادت آباد";
        Product product = new Product(0,name,value,time, R.drawable.nophoto,details,numberPhone);

        when(viewMock.getDetails()).thenReturn(product);

        //Art
        presenter.onAddProduct();

        //Assert
        verify(viewMock).errorName();

    }
    @Test
    public void onAddProduct_EmptyValue() {

        //Arrange
        String name = "موبایل اپل";
        String value = "";
        String details = "ارزان و کارکرده در حد نو و سالم و تمیز";
        String numberPhone = "09198067831";
        String time = "لحظاتی پیش در سعادت آباد";
        Product product = new Product(0,name,value,time, R.drawable.nophoto,details,numberPhone);

        when(viewMock.getDetails()).thenReturn(product);

        //Art
        presenter.onAddProduct();

        //Assert
        verify(viewMock).errorValue();

    }
    @Test
    public void onAddProduct_EmptyTime() {

        //Arrange
        String name = "موبایل اپل";
        String value = "توافقی";
        String details = "ارزان و کارکرده در حد نو و سالم و تمیز";
        String numberPhone = "09198067831";
        String time = "";
        Product product = new Product(0,name,value,time, R.drawable.nophoto,details,numberPhone);

        when(viewMock.getDetails()).thenReturn(product);

        //Art
        presenter.onAddProduct();

        //Assert
        verify(viewMock).errorTime();

    }
    @Test
    public void onAddProduct_incorrectNumberphone() {

        //Arrange
        String name = "موبایل اپل";
        String value = "توافقی";
        String details = "ارزان و کارکرده در حد نو و سالم و تمیز";
        String numberPhone = "1234";
        String time = "لحظاتی پیش در سعادت آباد";
        Product product = new Product(0,name,value,time, R.drawable.nophoto,details,numberPhone);

        when(viewMock.getDetails()).thenReturn(product);

        //Art
        presenter.onAddProduct();

        //Assert
        verify(viewMock).errorNumberPhone();

    }
    @Test
    public void onAddProduct_incorrectDetail() {

        //Arrange
        String name = "موبایل اپل";
        String value = "توافقی";
        String details = "ارزان";
        String numberPhone = "09198067831";
        String time = "لحظاتی پیش در سعادت آباد";
        Product product = new Product(0,name,value,time, R.drawable.nophoto,details,numberPhone);

        when(viewMock.getDetails()).thenReturn(product);

        //Art
        presenter.onAddProduct();

        //Assert
        verify(viewMock).errorDetails();

    }

}