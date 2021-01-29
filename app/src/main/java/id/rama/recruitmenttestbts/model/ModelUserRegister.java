package id.rama.recruitmenttestbts.model;

import com.google.gson.annotations.SerializedName;

public class ModelUserRegister {
    @SerializedName("email")
    private String email;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;

    public ModelUserRegister(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

}
