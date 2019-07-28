package com.example22.lenovo.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DoneActivity extends BaseActivity {

    @BindView(R.id.detailpesanan)
    TextView detailjenjang;
    @BindView(R.id.detailharga)
    TextView detailharga;

    private String jenjang;
    private String packet;
    private String harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);
        ButterKnife.bind(this);


        initIntent();
        setView();
    }

    private void setView() {
        detailharga.setText(harga);

        detailjenjang.setText(jenjang + " - " + packet);


    }

    private void initIntent() {

        packet = getIntent().getStringExtra(Constans.packet);
        jenjang = getIntent().getStringExtra(Constans.jenjang);
        harga = getIntent().getStringExtra(Constans.harga);
    }

///////////////////////////////////////////////////////////////////


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_done,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.home2 :
                startActivity(new Intent(c,HomeActivity.class));
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}