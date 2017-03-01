package com.ujikom.be.koperasi.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ujikom.be.koperasi.MainActivity;
import com.ujikom.be.koperasi.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Map;

public class SimpananFragment extends Fragment {

    TextView tvSimpanan;
    public static final String PREFERENCES = "koperasiPrefs";
    public static final String TAG = "B_Simpanan";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_simpanan, container, false);
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

        tvSimpanan = (TextView) getView().findViewById(R.id.tvSimpanan);
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);

        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);;

        tvSimpanan.setText(kursIndonesia.format(Double.parseDouble(sharedPreferences.getString("simpanan", ""))));
//        getData(getContext(), sharedPreferences.getString("id",""));
    }

//    public boolean getData(Context context, final String id){
//        String url = getString(R.string.api_simpanan);
//        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            Log.e(TAG, "response: "+response);
//                            JSONObject json = new JSONObject(response);
//
//                            if (json.getString("status").equals("success")){
//                                if (json.getString("total_simpanan") == null) tvSimpanan.setText("Rp 0");
//                                else tvSimpanan.setText("Rp "+json.getString("total_simpanan"));
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                            Toast.makeText(getActivity(), "Meminta data gagal", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        error.printStackTrace();
//                        Toast.makeText(getActivity(), "Meminta data gagal", Toast.LENGTH_SHORT).show();
//                    }
//                }
//        ) {
//            @Override
//            protected Map<String, String> getParams() {
//
//                Map<String, String> params = new HashMap<>();
//
//                params.put("id_anggota", id);
//
//                return params;
//            }
//        };
//        RequestQueue queue = Volley.newRequestQueue(context);
//        queue.add(postRequest);
//
//        return true;
//    }
}
