package id.rama.recruitmenttestbts.api;

import id.rama.recruitmenttestbts.model.ModelUserLogin;
import id.rama.recruitmenttestbts.model.ModelUserRegister;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiService {
    //untuk login
    @FormUrlEncoded
    @POST("login")
    Call<ModelUserLogin> postLogin(
            @Field("username") String username,
            @Field("password") String password
    );

    //untuk register
    @FormUrlEncoded
    @POST("register")
    Call<ModelUserRegister> postRegister(
            @Header("Content-Type") String contentType,
            @Field("email") String email,
            @Field("username") String username,
            @Field("password") String password
    );

}
