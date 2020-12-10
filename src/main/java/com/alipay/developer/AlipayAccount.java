package com.alipay.developer;

import java.io.File;


 class AlipayAccount {


    //回调验签公钥
     static String alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgGJor6tuy3GLdejVlwFw56xKrUsTY/krVn8qoFiDlP36wIM7VgDqW7YOp3WKODGiv1sTM5j/cGlURk7pOawYTYgldfpOoZowoFv2wfVW7v6ecMj+vJQcjcogEaPiJRnQN2EnC020rRQjZs43Cpurpd5kusNa/wWdeBFhH/X5v9/G28aIT+1PK1ApmWZBHUVzQn8T42QHiV/n8VotSeiFwdIzDhqTyTclt4FDFcC5m/ga1Exf4nPeLG+02GYEAI1YXrVzYrrR6Nc1YTFAlyODo7opNk0faW78FYrw78Xgp91KMO/bO6BI+WHqHcpkRtpT5cQFoR9OyDlUgk9JQRsnIwIDAQAB";
    
///////////////////////////////////////////////////////////////////////////
     static String appId       = "2019112969519656";
     static String signType    = "RSA2";
     static String privateKey  = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCmTJVMom6J6C1GBGL12JFTaNheE6sLoD0o90Ry6ab3ZRfaK8fluevw91+suaqY/GcYS81XEn5pu6YN1PGko0pjHTw9JTNmDvK1cQ/sre0/WQiIKb0OCzACJEBDJJ/BKcKFw4RWhiKhXIKAwmn6MjsSXMHDY/eXwnEdXQc6hbnfhSBviQoyN2uiLUmC55zVpsU2eLksITu0arBlWfiioaDsUz+sa8dWxW3OEdSpwPBRxpXlQnOLuoP/OMdauZlsopnudmQMh9jtI/GTpLX13UExaZhonJCYbT0H69WabWy19XOfp6vET5mXJbMabzswmv8ywzF/FlkMwwxiRTlfCCxPAgMBAAECggEAWyYkuwFY1wvELNlgqGGQnggcd8wN92xXuWl2QgnhMz5cyX8vrLGwKb5c2V5WrE3D8CQ0I2KGmUt546Dw5Y1+yz6N8vG971WIIH0c/lwCarNRItjFv7nQEYxvEJ41VfmenhShJ4+T0Z/UA+ELl1AK4rCmn4LehXbU6wQ/XwtG6sS519Ndw21eYJWafNI9JeTeWbOWMc83kg1+KOFRRGUEEeQqd5Nj+f/ezjOTPYSEPr2ZjpCHrrd2MzAX4Ih9hLucwDPYJTcAzDqKafmnEkIR+IlRx4u3AbEYaD3TFH6nJ478weBeCybb2yUow/4rtjcclJMl8qDfUJDeHT86m3vSSQKBgQDTTJUUwr9POR+DWIy4GSAgBpFtDJ2Nlgt0E0jeqq33gGxlkHb2N/LL44Une723GE56S6Ofals1aaS51/elxM7IpXARegGrP2K0gH24RazSgndUdZbT7UV2sCkxBmoNkV+DQ6fGAhFA51J27BJViD3k/TlT4pnNNymNNSF66aSTYwKBgQDJeuq9WXCAQahCmHGkbknS5rKuaZRrDdLAaYgjdNFM6OkQ29aEYkdQIuBrdpt+0LxNM3quFDGjrE2uyrMVwzqU8cKxv+ukUr5rPs9wQi3+TfEsO4FL8R4yGqAat06GloUhvAZInDdE/t4pOQ2vdLtMT/sQMQCMXaI6tXUpOCVVJQKBgQCJVAKohZIVCUlD8m8yz5GjfuFRgJt9hAFZpZb8sO10KJFKyUOn7uDsRqkp6jB5KWEH9tUXLOaupkSbTJP1tx22Jl/Z2/PturqKGeCbvRz/jC/GQs6OWm2FICUFaefPfaYYCAaomHtiNXXROMkJsgyYIUP7ExFm4O0ui1OBMQz3hQKBgCfSRH0CJWskDvaCnMtsBOlLMXupYG08QTBIa2DeoNN7oTz0xlRJ/GBJVGPJAHizFtSHXTL0yM7ZqkzmwTiG6pgvpFRvY0qKFBqsQmGkouSFUSp15Fs3H8m1W3mMS1fsfgmp2PAW+BGJ8izhmuPXxYESucN8e+hCRWMnJC3ua+qFAoGAJjpSYx6cmanBdwRmlVBaSEIQAf9A5MLWt9dNOMk2ilfp6z6OEw3OOS4chLpMmQuXc2IYFMXLG+9k8U39VD5wg/2invICoYAVXotZcwLP5kACMGf7EuPUUwxOVRvTwP5+NsM2LcJq3IOnhGa93x5ltF8qELvKJyS/6zJx8qSLGJY=";


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
