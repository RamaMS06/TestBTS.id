package id.rama.recruitmenttestbts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import id.rama.recruitmenttestbts.api.ApiService;
import id.rama.recruitmenttestbts.api.RetrofitInstanceRegister;
import id.rama.recruitmenttestbts.model.ModelUserLogin;
import id.rama.recruitmenttestbts.model.ModelUserRegister;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    AppCompatButton btnLogin;
    TextView txtRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.edt_username_login);
        edtPassword = findViewById(R.id.edt_password_login);
        txtRegister = findViewById(R.id.txt_register);

        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postLogin();
            }
        });
    }

    private void postLogin() {
        String username = edtUsername.getText().toString();
        String password= edtPassword.getText().toString();

        ApiService apiServiceRegister = RetrofitInstanceRegister.getRetrofitRegister(getApplicationContext()).create(ApiService.class);
        Call<ModelUserLogin> callLogin = apiServiceRegister.postLogin(username,password);
        callLogin.enqueue(new Callback<ModelUserLogin>() {
            @Override
            public void onResponse(Call<ModelUserLogin> call, Response<ModelUserLogin> response) {
                Toast.makeText(Login.this, "Berhasil Post Data", Toast.LENGTH_SHORT).show();
                Log.d("Berhasil", "Berhasil Registrasi");
            }

            @Override
            public void onFailure(Call<ModelUserLogin> call, Throwable t) {
                Toast.makeText(Login.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}