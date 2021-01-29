package id.rama.recruitmenttestbts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import id.rama.recruitmenttestbts.api.ApiService;
import id.rama.recruitmenttestbts.api.RetrofitInstanceRegister;
import id.rama.recruitmenttestbts.model.ModelUserLogin;
import id.rama.recruitmenttestbts.model.ModelUserRegister;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {
    EditText edtEmail, edtUsername, edtPassword;
    AppCompatButton btnRegister;
    ImageView btnKembali;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);

        edtEmail = findViewById(R.id.edt_email_register);
        edtUsername = findViewById(R.id.edt_username_register);
        edtPassword = findViewById(R.id.edt_password_register);
        btnRegister = findViewById(R.id.btn_register);
        btnKembali = findViewById(R.id.btn_kembali_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postRegister();
            }
        });

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void postRegister() {
        String email = edtEmail.getText().toString();
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        ApiService apiServiceRegister = RetrofitInstanceRegister.getRetrofitRegister(getApplicationContext()).create(ApiService.class);
        Call<ModelUserRegister> callLogin = apiServiceRegister.postRegister("application/json",email,username,password);
        callLogin.enqueue(new Callback<ModelUserRegister>() {
            @Override
            public void onResponse(Call<ModelUserRegister> call, Response<ModelUserRegister> response) {
                Toast.makeText(Register.this, "Berhasil Post Data", Toast.LENGTH_SHORT).show();
                Log.d("Berhasil", "Berhasil Registrasi");
            }

            @Override
            public void onFailure(Call<ModelUserRegister> call, Throwable t) {
                Toast.makeText(Register.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}