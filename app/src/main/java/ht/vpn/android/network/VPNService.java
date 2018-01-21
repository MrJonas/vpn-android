package ht.vpn.android.network;

import android.util.Base64;

import ht.vpn.android.network.responses.ServersResponse;
import ht.vpn.android.network.responses.SmartDNSResponse;
import ht.vpn.android.network.responses.Status;
import ht.vpn.android.network.responses.newUser;
import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

public class VPNService {
    private static final String API_URL = "http://45.63.74.224/";
    private Client mClient;

    private VPNService(String username, String password) {
        RestAdapter.Builder adapterBuilder = new RestAdapter.Builder().setEndpoint(API_URL);

        if (username != null && password != null) {
            final String credentials = username + ":" + password;
            adapterBuilder.setRequestInterceptor(new UserAgentInterceptor() {
                @Override
                public void intercept(RequestInterceptor.RequestFacade request) {
                    super.intercept(request);
                    String string = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
                    request.addHeader("Authorization", string);
                }
            });
        }

        RestAdapter restAdapter = adapterBuilder.build();
        mClient = restAdapter.create(Client.class);
    }

    public static VPNService.Client get() {
        return new VPNService(null, null).mClient;
    }

    public static VPNService.Client get(String username, String password) {
        return new VPNService(username, password).mClient;
    }

    public interface Client {
        @GET("/servers")
        void servers(Callback<ServersResponse> callback);
        @POST("/register")
        void register(@Body newUser user, Callback<Status> callback);
        @GET("/smartdns")
        void smartdns(Callback<SmartDNSResponse> callback);
    }
}
