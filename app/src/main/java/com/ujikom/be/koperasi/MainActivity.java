package com.ujikom.be.koperasi;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.ujikom.be.koperasi.fragment.HomeFragment;
import com.ujikom.be.koperasi.fragment.SignInFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String PREFERENCES = "koperasiPrefs";
    public ArrayList<Fragment> fragmentHistory;
    int pos = 0, clientPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        toolbar.setNavigationIcon(R.drawable.settings);

        fragmentHistory = new ArrayList<>();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TextView tvNama = (TextView) navigationView.getHeaderView(0).findViewById(R.id.tvName);

        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
        // ini bener cuma belum ada fragmentnya
        if (sharedPreferences.contains("username")){
            tvNama.setText(sharedPreferences.getString("name",""));
            displaySelectedScreen(R.id.nav_my_checklist);
        }
        else {
            Fragment f = new SignInFragment();
            showFragment(f);
        }
    }

    public void setName(){
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        TextView tvNama = (TextView) navigationView.getHeaderView(0).findViewById(R.id.tvName);

        SharedPreferences sharedPreferences = getSharedPreferences("koperasiPrefs", Context.MODE_PRIVATE);
        if (sharedPreferences.contains("username")){
            tvNama.setText(sharedPreferences.getString("name",""));
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (fragmentHistory.size() > 0){
                fragmentHistory.remove(fragmentHistory.size() - 1);
            }

            if (fragmentHistory.size() <= 0) {
                final Dialog dialog = new Dialog(this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_exit);
                dialog.getWindow().setLayout(AppBarLayout.LayoutParams.MATCH_PARENT, AppBarLayout.LayoutParams.WRAP_CONTENT);

                ImageView btnCancel = (ImageView) dialog.findViewById(R.id.btnCancel);
                ImageView btnYes = (ImageView) dialog.findViewById(R.id.btnYes);

                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                btnYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        finish();
                    }
                });

                dialog.show();
                dialog.setCancelable(false);

            } else {
                // ini bener cuma belum ada fragmentnya
//                if (fragmentHistory.get(fragmentHistory.size()-1).getClass().toString().equals(MyChecklistFragment.class.toString())){
//                    Fragment fragment = new MyChecklistFragment().newInstance(pos);
//                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//                    ft.replace(R.id.content_frame, fragment);
//                    ft.commit();
//                } else if (fragmentHistory.get(fragmentHistory.size()-1).getClass().toString().equals(ClientListFragment.class.toString())){
//                    Fragment fragment = new ClientListFragment().newInstance(clientPos);
//                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//                    ft.replace(R.id.content_frame, fragment);
//                    ft.commit();
//                } else{
//                    showFragment(fragmentHistory.get(fragmentHistory.size()-1));
//                }

            }
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        displaySelectedScreen(item.getItemId());
        if (item.isCheckable()) {
            item.setChecked(true);
        }
        return true;
    }

    public void setPos(int pos){
        this.pos=pos;
    }

    public void setClientPos(int pos){
        this.clientPos=pos;
    }

    private void displaySelectedScreen(int itemId) {

        Fragment fragment = null;

        switch (itemId) {
            // ini bener cuma belum ada fragmentnya
//            case R.id.nav_my_checklist:
//                fragment = new MyChecklistFragment().newInstance(0);
//                break;
//            case R.id.nav_done_list:
//                fragment = new DoneListFragment();
//                break;
//            case R.id.nav_client_list:
//                fragment = new ClientListFragment().newInstance(0);
//                break;
//            case R.id.nav_add_client:
//                fragment = new AddClientFragment();
//                break;
//            case R.id.nav_add_list:
//                fragment = new AddChecklistFragment();
//                break;
//            case R.id.nav_logout:
//                final Dialog dialog = new Dialog(this);
//                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//                dialog.setContentView(R.layout.dialog_logout);
//                dialog.getWindow().setLayout(AppBarLayout.LayoutParams.MATCH_PARENT, AppBarLayout.LayoutParams.WRAP_CONTENT);
//
//                ImageView btnCancel = (ImageView) dialog.findViewById(R.id.btnCancel);
//                ImageView btnYes = (ImageView) dialog.findViewById(R.id.btnYes);
//
//                btnCancel.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        dialog.dismiss();
//                    }
//                });
//
//                btnYes.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
//                        SharedPreferences.Editor editor = sharedPreferences.edit();
//                        editor.clear();
//                        editor.commit();
//                        Fragment fragment;
//                        fragment = new SignInFragment();
//                        showFragment(fragment);
//                        dialog.dismiss();
//                    }
//                });
//
//                dialog.show();
//                dialog.setCancelable(false);
//
//                break;
        }

        showFragment(fragment);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    public void clearHistory(){
        fragmentHistory.clear();
    }

    public void showFragment(Fragment fragment) {
        if (fragment != null) {
            if (fragment.getClass().toString().equals(HomeFragment.class.toString())){
                fragmentHistory.clear();
            }

            if (fragmentHistory.size() == 0) {
                fragmentHistory.add(fragment);
            } else if (!fragment.getClass().toString().equals(fragmentHistory.get(fragmentHistory.size()-1).getClass().toString())) {
                fragmentHistory.add(fragment);
            }

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }
    }
}
