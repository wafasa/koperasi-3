package com.ujikom.be.koperasi.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ujikom.be.koperasi.MainActivity;
import com.ujikom.be.koperasi.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignInFragment extends Fragment {

    EditText etUser, etPass;
    Button btnSignIn;
    public static final String PREFERENCES = "koperasiPrefs";
    public static final String TAG = "B_Login";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_signin, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Sign in");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        etUser = (EditText) getView().findViewById(R.id.etEmail);
        etPass = (EditText) getView().findViewById(R.id.etPass);
        btnSignIn = (Button) getView().findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etUser.getText().toString();
                String pass = etPass.getText().toString();

                getData(getContext(), email, pass);
            }
        });
    }

    public boolean getData(Context context, final String username, final String password){
        String url = getString(R.string.api_login);
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // response
                        try {
                            Log.e(TAG,"response: "+response);
                            if (response.length() > 0){
                                JSONObject json = new JSONObject(response);

                                if (json.getString("status").equals("success")){
                                    Log.e(TAG, "sukses "+json.getString("status"));
                                    SharedPreferences sharedpreferences = getContext().getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedpreferences.edit();
                                    editor.putString("id", json.getString("id"));
                                    editor.putString("nama", json.getString("nama"));
                                    editor.putString("alamat", json.getString("alamat"));
                                    editor.putString("no_telp", json.getString("no_telp"));
                                    editor.putString("ttl", json.getString("ttl"));
                                    editor.putString("jkel", json.getString("jkel"));
                                    editor.putString("status", json.getString("status_user"));
                                    editor.putString("keterangan", json.getString("keterangan"));
                                    editor.putString("username", json.getString("username"));
                                    editor.putString("password", json.getString("password"));
                                    editor.putString("last_updated", json.getString("last_updated"));
                                    editor.putString("deleted", json.getString("deleted"));
                                    editor.commit();

                                    MainActivity mainActivity = (MainActivity) getActivity();
                                    Fragment f = new HomeFragment();
                                    mainActivity.showFragment(f);
                                    mainActivity.clearHistory();
                                    mainActivity.setName();
                                } else{
                                    Log.e(TAG, "gagal "+json.getString("status"));
                                    Toast.makeText(getActivity(), "Login Failed", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(getActivity(), "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getActivity(), "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(getActivity(), "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<String, String>();

                params.put("username", username);
                params.put("password", password);

                return params;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(postRequest);

        return true;
    }
}
