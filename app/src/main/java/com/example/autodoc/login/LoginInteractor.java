package com.example.autodoc.login;

/**
 * Created by autodoc on 09/02/17.
 */

public interface LoginInteractor {
    interface OnLoginFinishedListener {

        void onUsernameError();

        void onPasswordError();

        void onSucess();

    }

    void login(String userName,String password,OnLoginFinishedListener listener);
}
