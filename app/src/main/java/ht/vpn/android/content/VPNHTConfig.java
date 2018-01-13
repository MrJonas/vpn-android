package ht.vpn.android.content;

import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;

import ht.vpn.android.Preferences;
import ht.vpn.android.network.responses.Certificate;
import ht.vpn.android.network.responses.Server;

public class VPNHTConfig {

    public static String generate(SharedPreferences preferences, Server server, Boolean firewall) {
        ArrayList<String> stringList = new ArrayList<>();

        stringList.add("client");
        stringList.add("dev tun");

        stringList.add("proto tcp-client");

        stringList.add("remote 207.246.96.153 8443");
        stringList.add("resolv-retry infinite");
        stringList.add("cipher AES-256-CBC");
        stringList.add("redirect-gateway");

        stringList.add("key-direction 1");
        stringList.add("remote-cert-tls server");
        stringList.add("auth-nocache");


        stringList.add("<auth-user-pass>");
        stringList.add("jonas");
        stringList.add("jonas");
        stringList.add("</auth-user-pass>");


        stringList.add("<ca>");
        stringList.add("-----BEGIN CERTIFICATE-----");
        for(String line: server.certificate) {
            stringList.add(line);
        }
//        stringList.add("MIIDHjCCAgagAwIBAgIJAJzsqTQrGC/WMA0GCSqGSIb3DQEBCwUAMA8xDTALBgNV");
//        stringList.add("BAMTBHZwbjEwHhcNMTcxMjI0MTQyNDIxWhcNMjcxMjIyMTQyNDIxWjAPMQ0wCwYD");
//        stringList.add("VQQDEwR2cG4xMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2SwSUUWS");
//        stringList.add("6F527fcVtpacbuoU+h9okyDLMbU1rmgucOcEQdXKmuj4UrBVVT/6JqrCBW3ORhlt");
//        stringList.add("RbM/Vbawzzm9WX3rxSlUTUnHrz643hLHzV9W1mgH8aaPmu/BB5TgMQmxz3rhSzoS");
//        stringList.add("adK5mHZ7adZD0wcrboVsYnFtu7rHRyvz07GdCt+KWgVL9O60CCz1cZdKNdnqFS0i");
//        stringList.add("m6uFA8A56i85Yhddv638w3cqv8udiklXk+502JX8wXtP3+OzIpgu0bKzwJkXylAi");
//        stringList.add("pdPfcioaaqUpz2I2a+lO0eeiQ78WkpDDg0az3RLEt7YHdPSqnojV22s7YB32FgTM");
//        stringList.add("pWjlVq2VU+fPjQIDAQABo30wezAdBgNVHQ4EFgQUHNAB3qC0/kQZzUWMc3eQtN+n");
//        stringList.add("3ygwPwYDVR0jBDgwNoAUHNAB3qC0/kQZzUWMc3eQtN+n3yihE6QRMA8xDTALBgNV");
//        stringList.add("BAMTBHZwbjGCCQCc7Kk0Kxgv1jAMBgNVHRMEBTADAQH/MAsGA1UdDwQEAwIBBjAN");
//        stringList.add("BgkqhkiG9w0BAQsFAAOCAQEANgEllt7XzvBkcwx6a5rUwZtqemYRc+pJWZc7hHIr");
//        stringList.add("+2geRva5ZJaAc/dB31AEFyDF9HT8KTYzDmICTOLYXDJPHQocHN6drZ2HsnDnW2d1");
//        stringList.add("5djFk0oGieBVBmPpxu9v90cxejHgUjZId8baSPEo/ka0HTaP6EXbX7acn5219HwE");
//        stringList.add("4IfNHcacZzb3soB2Tl7QggpvKYuU7+WZmfV0iOKqFPaSNXFqcyOQBzhpoY6QLPm3");
//        stringList.add("vUIqZ2MTexIBs0MLgqzcLeufzSJeIdxaBxJK/7St77pe1oLVcvwsj8Tw4ZymVU3X");
//        stringList.add("8zp8puMN75tn6fzeA+CUfLV2WpBOl/bxgV3Ckjt8HF2RpA==");
        stringList.add("-----END CERTIFICATE-----");
        stringList.add("</ca>");

        stringList.add("<tls-auth>");
        stringList.add("-----BEGIN OpenVPN Static key V1-----");
        stringList.add("111a5aa8d57865ebf1f7a5de3fcada59");
        stringList.add("dd3e6ab94890c9326659cc5158904d93");
        stringList.add("02c05c8c62d30c0bcf54d6849959cc73");
        stringList.add("f7b27deecb3e2e878f8cc137223cd00c");
        stringList.add("4ad14e8f6afc768ee8abe7dcc21d72eb");
        stringList.add("3284d3d632a8a6037eecc79a31840c45");
        stringList.add("6170ace59b9d28aaf85e2c9d2d50eb07");
        stringList.add("f8e6ccc6206136ba5ebeeea37cb7f3e6");
        stringList.add("1e4829ae3e0ed526b03dccb8c865251f");
        stringList.add("7452fb54db6f098c3f7fea403672ea9b");
        stringList.add("04745cad7a51fa6cd1a4c4df1f0be9b8");
        stringList.add("8bcd46e8160aee614b8f72c548985056");
        stringList.add("b7a2860e9c8e941d6ed32c6d2b34f106");
        stringList.add("884263bfa2af75eb87b9b161764559ac");
        stringList.add("17246b27e0c4a9721a45081eae40bc15");
        stringList.add("b23e449fda48be07ebed019331f39ceb");
        stringList.add("-----END OpenVPN Static key V1-----");
        stringList.add("</tls-auth>");

        stringList.add("nobind");
        stringList.add("persist-key");
        stringList.add("persist-tun");
        stringList.add("comp-lzo");
        stringList.add("verb 3");


        // Test server:
        // stringList.add(String.format("remote %s %s", "188.226.230.75", "1194"));

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
