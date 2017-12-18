package com.utad.danieliglesia.milib.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.utad.danieliglesia.milib.R;

public class LoginFragment extends Fragment {
    private Button btnRegistrar, btnLogin;
    TextView lblEmail,lblPass;
    public EditText editConstrasena,editUsuario;
    LoginFragmentListener loginFragmentListener;
    LoginFragmentEvents loginFragmentEvents;

    public void setListener(LoginFragmentListener loginFragmentListener) {
        this.loginFragmentListener = loginFragmentListener;
    }
    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        this.setListener(loginFragmentListener);
        loginFragmentEvents=new LoginFragmentEvents(this);

        lblEmail = v.findViewById(R.id.lblEmail);


        lblPass = v.findViewById(R.id.lblPass);


        editUsuario= v.findViewById(R.id.editUsuario);
        editConstrasena = v.findViewById(R.id.editConstrasena);

        btnRegistrar=v.findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(loginFragmentEvents);

        btnLogin=v.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(loginFragmentEvents);


        return v;
    }
}
class LoginFragmentEvents implements View.OnClickListener{
    LoginFragment loginFragment;
    public LoginFragmentEvents(LoginFragment loginFragment){
        this.loginFragment=loginFragment;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnRegistrar){
            if (this.loginFragment.loginFragmentListener!=null);
            this.loginFragment.loginFragmentListener.OnRegisterClicked();
        }else if (v.getId()==R.id.btnLogin){
            if (this.loginFragment.loginFragmentListener!=null);
            this.loginFragment.loginFragmentListener.OnLoginClicked(this.loginFragment.editUsuario.getText().toString(),this.loginFragment.editConstrasena.getText().toString());
        }

    }
}
