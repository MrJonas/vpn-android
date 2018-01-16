package ht.vpn.android.network.responses;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Server {
    @SerializedName("h")
    public String hostname;
    @SerializedName("l")
    public String location;
    @SerializedName("c")
    public String country;
    @SerializedName("cc")
    public String countryCode;
    @SerializedName("ca")
    public List<String> certificate;
    @SerializedName("ta")
    public List<String> key;
    @SerializedName("ll")
    public double[] longlat;
    @SerializedName("lat")
    public Double latitude;
    @SerializedName("lon")
    public Double longitude;

    public LatLng getCoordinates() {
        if(latitude == null ||   longitude  == null)
            return null;
        return new LatLng(latitude, longitude);
    }
}
