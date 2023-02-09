package com.example.divarmvp.ui.Register;

import com.example.divarmvp.ui.Login.LoginPresenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RegisterPresenterTest {

    RegisterPresenter presenter;

    @Mock
    RegisterConstract.View viewMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new RegisterPresenter(viewMock);
    }

    @After
    public void shutDown() {
        presenter = null;
    }

    @Test
    public void onRegisterr() {

        //Arrange
        String code = "557324";
        when(viewMock.getCode()).thenReturn(code);

        //Act
        presenter.onRegisterr();

        //Assert
        verify(viewMock).gotoHomeActivity();

    }

    @Test
    public void onRegisterr_incorrectCode() {

        //Arrange
        String code = "1234";
        when(viewMock.getCode()).thenReturn(code);

        //Act
        presenter.onRegisterr();

        //Assert
        verify(viewMock).allerdialogerror();

    }

    @Test
    public void onRegisterr_EmptyCode() {

        //Arrange
        String code = "";
        when(viewMock.getCode()).thenReturn(code);

        //Act
        presenter.onRegisterr();

        //Assert
        verify(viewMock).allerdialogerror();

    }

    @Test
    public void onsetNumberPhone() {

        //Arrange

        //Act
        presenter.onsetNumberPhone();

        //Assert
        verify(viewMock).setNumberPhone();

    }
}