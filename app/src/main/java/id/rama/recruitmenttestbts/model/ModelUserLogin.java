package id.rama.recruitmenttestbts.model;

import com.google.gson.annotations.SerializedName;

public class ModelUserLogin {
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;

    public ModelUserLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
