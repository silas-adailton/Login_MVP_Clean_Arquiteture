package com.example.autodoc.login;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by autodoc on 09/02/17.
 */

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void login(final String userName, final String password, final OnLoginFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if(TextUtils.isEmpty(userName)){
                    listener.onUsernameError();
                    error = true;
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    error = true;
                    return;
                }
                if (!error){
                    listener.onSucess();
                }
            }
        },2000);

    }
}
