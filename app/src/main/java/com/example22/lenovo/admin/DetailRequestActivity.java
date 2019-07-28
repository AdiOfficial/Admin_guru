package com.example22.lenovo.admin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailRequestActivity extends BaseActivity {

    @BindView(R.id.detailName)
    TextView detailName;
    @BindView(R.id.detailpesanan)
    TextView detailjenjang;
    @BindView(R.id.detailAlamat)
    TextView detailAlamat;
    @BindView(R.id.detailHp)
    EditText detailHp;
    @BindView(R.id.detailKeterangan)
    EditText detailKeterangan;
    @BindView(R.id.detailharga)
    TextView detailHarga;
    private String id;
    private String lat;
    private String lon;
    private String jenjang;
    private String harga;
    private String packet;
    private String namelocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_request);
        ButterKnife.bind(this);


        initIntent();
        setView();
    }

    private void setView() {
        detailName.setText(sesi.getNama());
        detailHarga.setText(harga );
        detailAlamat.setText(namelocation);
        detailjenjang.setText(jenjang + " - " + packet);


    }

    private void initIntent() {

        id = getIntent().getStringExtra(Constans.id);
        namelocation = getIntent().getStringExtra(Constans.nameLocation);
        lat = getIntent().getStringExtra(Constans.lat);
        harga = getIntent().getStringExtra(Constans.harga);
        lon = getIntent().getStringExtra(Constans.lon);
        packet = getIntent().getStringExtra(Constans.packet);
        jenjang = getIntent().getStringExtra(Constans.jenjang);
    }


    @OnClick(R.id.btnRequest)
    public void onViewClicked() {


        RetrofitClient.service.actionRequest(sesi.getIdUser(), id, lat, lon, namelocation, detailHp.getText().toString(), detailKeterangan.getText().toString())
                .enqueue(new Callback<ResponseSignUp>() {
                    @Override
                    public void onResponse(Call<ResponseSignUp> call, Response<ResponseSignUp> response) {

                        if (response.isSuccessful()) {

                            boolean status = response.body().isStatus();

                            if (status) {

                                startActivity(new Intent(c, DoneActivity.class));

                            }
                        }

                        next();


                    }


                    private void next() {

                        Intent move = new Intent(DetailRequestActivity.this, DoneActivity.class);
                        move.putExtra(Constans.id, id);
                        move.putExtra(Constans.jenjang, jenjang);
                        move.putExtra(Constans.packet, packet);
                        move.putExtra(Constans.harga, harga);

                        startActivity(move);


                    }

                    @Override
                    public void onFailure(Call<ResponseSignUp> call, Throwable t) {

                    }
                });
    }
}