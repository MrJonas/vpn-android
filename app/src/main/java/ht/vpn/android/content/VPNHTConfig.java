package ht.vpn.android.content;

import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;

import ht.vpn.android.Preferences;
import ht.vpn.android.network.responses.Server;

public class VPNHTConfig {

    public static String generate(SharedPreferences preferences, Server server, Boolean firewall) {
        ArrayList<String> stringList = new ArrayList<>();

        stringList.add("client");
        stringList.add("dev tun");
        stringList.add("proto tcp-client");

        stringList.add(String.format("remote %s %s", server.hostname, "8443"));
        stringList.add("resolv-retry infinite");
        stringList.add("cipher AES-256-CBC");
        stringList.add("redirect-gateway");

        stringList.add("key-direction 1");
        stringList.add("remote-cert-tls server");

        stringList.add("<auth-user-pass>");
        Log.d("USERNAME",preferences.getString(Preferences.USERNAME, "") + " ");
        Log.d("PASSWORD",preferences.getString(Preferences.PASSWORD, "") + " ");
        stringList.add(preferences.getString(Preferences.USERNAME, ""));
        stringList.add(preferences.getString(Preferences.PASSWORD, ""));
        stringList.add("</auth-user-pass>");
        stringList.add("auth-nocache");

        stringList.add("nobind");
        stringList.add("persist-key");
        stringList.add("persist-tun");
        stringList.add("comp-lzo");
        stringList.add("verb 3");

        stringList.add("key-direction 1");

        stringList.add("<tls-auth>");
        stringList.add("-----BEGIN OpenVPN Static key V1-----");
        Log.d("length", "" + server.key.size());
        for(String line: server.key) {
            Log.d("tl-key", "" + line);
            stringList.add(line);
        }
        stringList.add("-----END OpenVPN Static key V1-----");
        stringList.add("</tls-auth>");

        stringList.add("<ca>");
        stringList.add("-----BEGIN CERTIFICATE-----");
        for(String line: server.certificate) {
            Log.d("cert", "" + line);
            stringList.add(line);
        }
        stringList.add("-----END CERTIFICATE-----");
        stringList.add("</ca>");

        StringBuilder builder = new StringBuilder();
        for(String s : stringList) {
            builder.append(s);
            builder.append('\n');
        }
        return builder.toString();
    }

    private static String[] getPortsByProtocol(String protocol) {
        ArrayList<String> stringList = new ArrayList<>();
        switch(protocol) {
            case "AES-256-CBC":
                for(int i = 1300; i < 1305; i++) {
                    stringList.add(Integer.toString(i));
                }
                break;
            case "AES-128-CBC":
                for(int i = 1194; i < 1201; i++) {
                    stringList.add(Integer.toString(i));
                }
                break;
            case "BF-CBC":
                for(int i = 1202; i < 1206; i++) {
                    stringList.add(Integer.toString(i));
                }
                break;
        }
        return stringList.toArray(new String[stringList.size()]);
    }

}
