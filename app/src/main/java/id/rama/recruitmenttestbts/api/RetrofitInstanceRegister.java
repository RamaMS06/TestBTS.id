package id.rama.recruitmenttestbts.api;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstanceRegister {

    public static final String BASE_URL = "http://18.139.50.74:8080/";
    private static Retrofit retrofitRegister = null;

    public static Retrofit getRetrofitRegister(final Context context) {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder requestBuilder = chain.request().newBuilder();
                requestBuilder.header("Accept", "*/*");
                requestBuilder.header("Content-Type", "application/json");
                return chain.proceed(requestBuilder.build());
            }
        }).build();

        if (retrofitRegister == null) {
            Gson gson = new GsonBuilder().setLenient().create();
            retrofitRegister = new Retrofit.Builder().baseUrl(BASE_URL).
                    client(okHttpClient).
                    addConverterFactory(GsonConverterFactory.create(gson)).
                    build();
        }
        return retrofitRegister;
    }
}
