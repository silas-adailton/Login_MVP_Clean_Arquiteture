package com.example.autodoc.login;

/**
 * Created by autodoc on 09/02/17.
 */

public interface LoginContract {

    interface LoginContractWiew {

        void showProgress();

        void hideProgress();

        void setUserNameError();

        void setPasswordError();

        void navigateToHome();

        void setPresenter(LoginContractPresenter presenter);

    }

    interface LoginContractPresenter {

        void validateCredentials(String userName, String password);

        void onDestroy();

    }
}
