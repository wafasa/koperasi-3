package com.ujikom.be.koperasi.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ujikom.be.koperasi.R;

public class HomeFragment extends Fragment {

    TextView tvNama, tvUsername, tvAlamat, tvTelp, tvTtl, tvStatus;
    String nama, username, alamat, telp, ttl, status;
    public static final String PREFERENCES = "koperasiPrefs";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(getString(R.string.app_name));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();

        tvNama = (TextView) getView().findViewById(R.id.tvNama);
        tvUsername = (TextView) getView().findViewById(R.id.tvUsername);
        tvAlamat = (TextView) getView().findViewById(R.id.tvAlamat);
        tvTelp = (TextView) getView().findViewById(R.id.tvTelp);
        tvTtl = (TextView) getView().findViewById(R.id.tvTtl);
        tvStatus = (TextView) getView().findViewById(R.id.tvStatus);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
        nama = sharedPreferences.getString("nama","");
        username = sharedPreferences.getString("username","");
        alamat = sharedPreferences.getString("alamat","");
        telp = sharedPreferences.getString("no_telp","");
        ttl = sharedPreferences.getString("ttl","");
        status = sharedPreferences.getString("status","");

        tvNama.setText(nama);
        tvUsername.setText(username);
        tvAlamat.setText(alamat);
        tvTelp.setText(telp);
        tvTtl.setText(ttl);
        tvStatus.setText(status);
    }
}
