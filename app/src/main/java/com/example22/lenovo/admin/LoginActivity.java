package com.example22.lenovo.admin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example22.lenovo.admin.chat_package.UserDetails;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {


    Button btnSignIn;
    TextView textLink;
    EditText signInHp, signInPass;
    String user, pass, nohp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {

        btnSignIn = findViewById(R.id.btnLogin);
        textLink = findViewById(R.id.linkSignUp);
        signInHp = findViewById(R.id.loginHp);
        signInPass = findViewById(R.id.loginPassword);
//        nohp = signInHp.getText().toString();
//        pass = signInPass.getText().toString();


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionLogin();

            }
        });

        textLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));

                finish();
            }
        });


    }


    private void actionMove() {

        startActivity(new Intent(LoginActivity.this,HomeActivity.class));

        finish();


    }

    private void showToast(String pesan) {
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
    }


    private void actionLogin() {

        RetrofitClient.service.actionLogin(signInHp.getText().toString(),signInPass.getText().toString()).enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {

                if(response.isSuccessful()){

                    Boolean status  = response.body().isStatus();
                    String pesan = response.body().getPesan();

                    if(status){

                        actionMove();

                        Data data = response.body().getData();
                        sesi.setEmail(data.getUserEmail());
                        sesi.setNama(data.getUserNama());
                        sesi.setIduser(data.getUserId());
                        sesi.setPhone(data.getUserTelpon());
                        sesi.cerateLoginSession("2");

                        user = data.getUserNama();
                        pass = data.getUserPassword();
                        UserDetails.username = user;
                        UserDetails.password = pass;



                    }
                    else {

                        showToast(pesan);




                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {

            }
        });
    }

    private void login_chat(){
        String url = "https://guruku2-572b2.firebaseio.com/admin.json";
        final ProgressDialog pd = new ProgressDialog(LoginActivity.this);
        pd.setMessage("Loading...");
        pd.show();

        StringRequest request = new StringRequest(Request.Method.GET, url, new com.android.volley.Response.Listener<String>(){
            @Override
            public void onResponse(String s) {
                if(s.equals("null")){
                    Toast.makeText(LoginActivity.this, "user not found", Toast.LENGTH_LONG).show();
                }
                else{
                    try {
                        JSONObject obj = new JSONObject(s);

                        if(!obj.has(nohp)){
                            Toast.makeText(LoginActivity.this, "user not found", Toast.LENGTH_LONG).show();
                        }
                        else if(obj.getJSONObject(nohp).getString("password").equals(pass)){
                            UserDetails.noHp = nohp;
                            UserDetails.password = pass;


//                            startActivity(new Intent(LoginActivity.this, Lis.class));
                        }
                        else {
                            Toast.makeText(LoginActivity.this, "incorrect password", Toast.LENGTH_LONG).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                pd.dismiss();
            }
        },new com.android.volley.Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                System.out.println("" + volleyError);
                pd.dismiss();
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(LoginActivity.this);
        rQueue.add(request);
    }
}