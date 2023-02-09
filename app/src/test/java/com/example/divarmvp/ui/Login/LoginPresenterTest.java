package com.example.divarmvp.ui.Login;

import com.example.divarmvp.Const;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginPresenterTest {

    LoginPresenter presenter;

    @Mock
    LoginConstract.View viewMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new LoginPresenter(viewMock);
    }

    @After
    public void shutDown() {
        presenter = null;
    }

    @Test
    public void onRegister() {

        //Arange
        String numberPhone = "09198067831";
        when(viewMock.getNumberPhone()).thenReturn(numberPhone);

        //Act
        presenter.onRegister();

        //Assert
        verify(viewMock).goToAnotherActivity();
    }

    @Test
    public void onRegister_incorrectValue() {

        //Arange
        String numberPhone = "09198067";
        when(viewMock.getNumberPhone()).thenReturn(numberPhone);

        //Act
        presenter.onRegister();

        //Assert
        verify(viewMock).showAlerDialogError();
    }

    @Test
    public void onRegister_Empty() {

        //Arange
        String numberPhone = "";
        when(viewMock.getNumberPhone()).thenReturn(numberPhone);

        //Act
        presenter.onRegister();

        //Assert
        verify(viewMock).showAlerDialogError();
    }

    @Test
    public void onCheckBeforRegister() {

        //Arange
        when(viewMock.getSharedPreference(Const.SHARED_PERF_KEY_REGISTER)).thenReturn("sasa");

        //Act
        presenter.onCheckBeforRegister();

        //Assert
        verify(viewMock).goToHomeActivityy();
    }
}