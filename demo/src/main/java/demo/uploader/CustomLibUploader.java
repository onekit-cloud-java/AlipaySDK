package demo.uploader;


import javax.activation.MimetypesFileTypeMap;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * 用于自定义图库上传图片
 */
@SuppressWarnings("unused")
public class CustomLibUploader {


    public String uploadFile(String host, String uploadFolder, String ossAccessKeyId,
                             String policy, String signature,
                             String filepath) throws Exception {
        LinkedHashMap<String, String> textMap = new LinkedHashMap<>();
        // key
        String objectName = uploadFolder + "/imglib_" + UUID.randomUUID().toString() + ".jpg";
        textMap.put("key", objectName);
        // Content-Disposition
        textMap.put("Content-Disposition", "attachment;filename="+filepath);
        // OSSAccessKeyId
        textMap.put("OSSAccessKeyId", ossAccessKeyId);
        // policy
        textMap.put("policy", policy);
        // Signature
        textMap.put("Signature", signature);

        Map<String, String> fileMap = new HashMap<>();
        fileMap.put("file", filepath);

        String ret = formUpload(host, textMap, fileMap);
        System.out.println("[" + host + "] post_object:" + objectName);
        System.out.println("post reponse:" + ret);
        return objectName;
    }

    private static String formUpload(String urlStr, Map<String, String> textMap, Map<String, String> fileMap) throws Exception {
        String res;
        HttpURLConnection conn = null;
        String BOUNDARY = "9431149156168";
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(10000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
            conn.setRequestProperty("Content-Type",
                    "multipart/form-data; boundary=" + BOUNDARY);

            OutputStream out = new DataOutputStream(conn.getOutputStream());
            // text
            if (textMap != null) {
                StringBuilder strBuf = new StringBuilder();
                Iterator iter = textMap.entrySet().iterator();
                int i = 0;
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    String inputName = (String) entry.getKey();
                    String inputValue = (String) entry.getValue();
                    if (inputValue == null) {
                        continue;
                    }
                    if (i == 0) {
                        strBuf.append("--").append(BOUNDARY).append(
                                "\r\n");
                        strBuf.append("Content-Disposition: form-data; name=\"").append(inputName).append("\"\r\n\r\n");
                        strBuf.append(inputValue);
                    } else {
                        strBuf.append("\r\n").append("--").append(BOUNDARY).append(
                                "\r\n");
                        strBuf.append("Content-Disposition: form-data; name=\"").append(inputName).append("\"\r\n\r\n");

                        strBuf.append(inputValue);
                    }

                    i++;
                }
                out.write(strBuf.toString().getBytes());
            }

            // file
            if (fileMap != null) {
                for (Map.Entry<String, String> stringStringEntry : fileMap.entrySet()) {
                    String inputName = (String) ((Map.Entry) stringStringEntry).getKey();
                    String inputValue = (String) ((Map.Entry) stringStringEntry).getValue();
                    if (inputValue == null) {
                        continue;
                    }
                    File file = new File(inputValue);
                    String filename = file.getName();
                    String contentType = new MimetypesFileTypeMap().getContentType(file);
                    if (contentType == null || contentType.equals("")) {
                        contentType = "application/octet-stream";
                    }

                    String strBuf = "\r\n" + "--" + BOUNDARY +
                            "\r\n" +
                            "Content-Disposition: form-data; name=\""
                            + inputName + "\"; filename=\"" + filename
                            + "\"\r\n" +
                            "Content-Type: " + contentType + "\r\n\r\n";
                    out.write(strBuf.getBytes());

                    DataInputStream in = new DataInputStream(new FileInputStream(file));
                    int bytes;
                    byte[] bufferOut = new byte[1024];
                    while ((bytes = in.read(bufferOut)) != -1) {
                        out.write(bufferOut, 0, bytes);
                    }
                    in.close();
                }
                out.write("".getBytes());
            }

            byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
            out.write(endData);
            out.flush();
            out.close();

            // 读取返回数据
            StringBuilder strBuf = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                strBuf.append(line).append("\n");
            }
            res = strBuf.toString();
            reader.close();
        } catch (Exception e) {
            System.err.println("发送POST请求出错: " + urlStr);
            throw e;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return res;
    }


}