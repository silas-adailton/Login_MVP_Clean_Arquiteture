package com.example.autodoc.login;

/**
 * Created by autodoc on 09/02/17.
 */

public class LoginPresenterImpl implements LoginContract.LoginContractPresenter, LoginInteractor.OnLoginFinishedListener {
    private LoginContract.LoginContractWiew loginContractWiew;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginContract.LoginContractWiew loginContractWiew) {
        this.loginContractWiew = loginContractWiew;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String userName, String password) {
        if (loginContractWiew != null) {
            loginContractWiew.showProgress();
        }

        loginInteractor.login(userName, password, this);

    }

    @Override
    public void onDestroy() {
        loginContractWiew = null;
    }

    @Override
    public void onUsernameError() {
        if (loginContractWiew != null) {
            loginContractWiew.setUserNameError();
            loginContractWiew.hideProgress();
        }

    }

    @Override
    public void onPasswordError() {
        if (loginContractWiew != null) {
            loginContractWiew.setPasswordError();
            loginContractWiew.hideProgress();
        }

    }

    @Override
    public void onSucess() {
        if (loginContractWiew != null) {
            loginContractWiew.navigateToHome();
        }

    }
}
