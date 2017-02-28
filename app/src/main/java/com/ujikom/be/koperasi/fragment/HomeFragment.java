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
import android.widget.EditText;
import android.widget.ListView;
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
    }

//    public boolean getData(Context context, final String id){
//        String url = "http://www.jstax.co.id/be_checklists";
//        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        // response
//                        try {
//                            Log.e("LogOnF5", "checklist response: "+response);
//                            JSONArray json = new JSONArray(response);
//                            List<CheckList> checkList = new ArrayList<>();
//                            dataMyCheckList.clear();
//
//                            if (json.length() > 0){
//
//                                for (int j = 0; j < json.length(); j++) {
//                                    JSONObject object = new JSONObject(json.get(j).toString());
//                                    String isdone = object.getString("isdone");
//                                    if (isdone.equals("false")){
//                                        CheckList u = new CheckList(object.getString("id"), object.getString("pic"), object.getString("default_pic"), object.getString("isdone"), object.getString("client"), object.getString("tipe_pekerjaan"), object.getString("spt_masa"), object.getString("jenis_spt"), object.getString("periode"), object.getString("note"), object.getString("detail_pajak"), object.getString("status"));
//                                        checkList.add(u);
//                                    }
//                                }
//
//                                for (CheckList cL : checkList){
//                                    dataMyCheckList.add(cL);
//                                }
//
//                                final MyCheckListAdapter adapter = new MyCheckListAdapter(getContext(), dataMyCheckList, pos);
//
//                                listView.setAdapter(adapter);
//                                listView.post(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        listView.setSelection(pos);
//                                    }
//                                });
////                                listView.setExpanded(true);
//
//                                etSearch.addTextChangedListener(new TextWatcher() {
//                                    @Override
//                                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//                                    }
//
//                                    @Override
//                                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                                        adapter.getFilter().filter(charSequence);
//                                    }
//
//                                    @Override
//                                    public void afterTextChanged(Editable editable) {
//
//                                    }
//                                });
//                            }
//
//
//                            swipeRefreshLayout.setRefreshing(false);
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                            Toast.makeText(getActivity(), "Meminta data gagal", Toast.LENGTH_SHORT).show();
//                            swipeRefreshLayout.setRefreshing(false);
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        error.printStackTrace();
//                        Toast.makeText(getActivity(), "Meminta data gagal", Toast.LENGTH_SHORT).show();
//                        swipeRefreshLayout.setRefreshing(false);
//                    }
//                }
//        ) {
//            @Override
//            protected Map<String, String> getParams() {
//
//                Map<String, String> params = new HashMap<String, String>();
//
//                params.put("userId", id);
//
//                return params;
//            }
//        };
//        RequestQueue queue = Volley.newRequestQueue(context);
//        queue.add(postRequest);
//
//        return true;
//    }
//
//    public static MyChecklistFragment newInstance(int pos) {
//        MyChecklistFragment myChecklistFragment = new MyChecklistFragment();
//
//        Bundle args = new Bundle();
//        args.putInt("pos", pos);
//        myChecklistFragment.setArguments(args);
//
//        return myChecklistFragment;
//    }
}
