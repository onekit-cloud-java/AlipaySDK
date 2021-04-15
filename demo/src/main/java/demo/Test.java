package demo;






import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.security.KeyFactory;
import java.security.PrivateKey;

import java.security.spec.PKCS8EncodedKeySpec;
import java.util.*;

public class Test {
    public static final String  SIGN_ALGORITHMS = "SHA1WithRSA";

    public static String sign(String content, String privateKey, String input_charset)
    {
        try
        {
            byte[] decode = Base64.decode(privateKey);
            PKCS8EncodedKeySpec priPKCS8   = new PKCS8EncodedKeySpec(decode );
            KeyFactory keyf= KeyFactory.getInstance("RSA");
            PrivateKey priKey= keyf.generatePrivate(priPKCS8);

            java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);

            signature.initSign(priKey);
            signature.update( content.getBytes(input_charset) );

            byte[] signed = signature.sign();

            return Base64.encode(signed);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }
    public static void main(String[] args) throws Exception {

      String data = "app_id=2019112969519656&charset=UTF-8&code=53c34d2909504453b0819543a0f2UX90&format=json&grant_type=authorization_code&method=alipay.system.oauth.token&sign_type=RSA&timestamp=2014-07-24 03:07:50&version=1.0";
        String sign = sign(data, AlipayAccount.privateKey, AlipayAccount.charset);
        System.out.println(sign);

    }


}
