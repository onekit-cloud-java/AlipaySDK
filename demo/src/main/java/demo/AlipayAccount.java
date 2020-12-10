package demo;

import java.io.File;

 class AlipayAccount {


///////////////////////////////////////////////////////////////////////////
     static String appId       = "2019112969519656";
      static String signType    = "RSA2";
     static String version     = "1.0";
     static String fromat      = "json";
     static String charset      = "UTF-8";

    static {
    	String path = System.getProperty("user.home")+"\\AlipayApp\\alipay\\";
    	File file = new File(path);
    	if(!file.exists()) {
            //noinspection ResultOfMethodCallIgnored
            file.mkdir();
    	}
    }
    
 }
