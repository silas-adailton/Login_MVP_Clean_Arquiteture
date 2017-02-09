package com.example.autodoc.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginContract.LoginContractWiew {
    @BindView(R.id.editTextLogin)
    EditText editTextLogin;
    @BindView(R.id.editTextSenha)
    EditText editTextSenha;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private LoginContract.LoginContractPresenter presenter;

    @OnClick(R.id.btnLogar)
    void logar() {
        presenter.validateCredentials(editTextLogin.getText().toString(), editTextSenha.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        presenter = new LoginPresenterImpl(this);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void setUserNameError() {
        editTextLogin.setError(getString(R.string.username_error));

    }

    @Override
    public void setPasswordError() {
        editTextSenha.setError(getString(R.string.passwordError));

    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();

    }

    @Override
    public void setPresenter(LoginContract.LoginContractPresenter presenter) {
        this.presenter = presenter;
    }
}
