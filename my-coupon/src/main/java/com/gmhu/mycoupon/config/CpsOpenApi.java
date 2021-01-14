package com.gmhu.mycoupon.config;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @Description:
 * @Author: huguangmiao
 * @Date: 2020/12/23
 */
public class CpsOpenApi {
    private final String logTag;
    private boolean isShowLog;
    private final String CHARSET;
    private final String BaseUrl;
    private String appKey;
    private String appSecret;

    public CpsOpenApi(String appKey, String appSecret) {
        this(appKey, appSecret, true);
    }

    public CpsOpenApi(String appKey, String appSecret, boolean isShowLog) {
        this.logTag = "CpsOpenApi";
        this.CHARSET = "UTF-8";
        this.BaseUrl = "https://open.duomai.com/apis";
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.isShowLog = isShowLog;
    }

    public String doReq(String service, Map<String, Object> params) throws IOException {
        Map<String, Object> comm = this.getQueryMap(service);
        String commStr = this.toSimpleString(comm);
        String paramsJsonStr = "";
        if (params != null && params.size() > 0) {
            paramsJsonStr = this.toJsonString(params);
        }

        String toMd5Str = this.appSecret + commStr + paramsJsonStr + this.appSecret;
        String sign = this.toMD5(toMd5Str).toUpperCase();
        comm.put("sign", sign);
        String httpUrl = "https://open.duomai.com/apis?" + this.toQueryString(comm, "UTF-8");
        return this.sendPost(httpUrl, paramsJsonStr);
    }

    private Map<String, Object> getQueryMap(String service) {
        String timestamp = "" + System.currentTimeMillis() / 1000L;
        Map<String, Object> comm = new HashMap();
        comm.put("app_key", this.appKey);
        comm.put("timestamp", timestamp);
        comm.put("service", service);
        return comm;
    }

    private String sendPost(String url, String param) throws IOException {
        this.logMsg("sendPost url : " + url + " , param : " + param);
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";

        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("Content-type", "application/json");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setReadTimeout(15000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            out.print(param);
            out.flush();

            String line;
            for(in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8")); (line = in.readLine()) != null; result = result + line) {
            }
        } catch (Exception var16) {
            this.logMsg("send POST Exception:" + var16);
            var16.printStackTrace();
            throw var16;
        } finally {
            try {
                if (out != null) {
                    out.close();
                }

                if (in != null) {
                    in.close();
                }
            } catch (IOException var15) {
                var15.printStackTrace();
                throw var15;
            }

        }

        return result;
    }

    private String sendGet(String url) {
        this.logMsg("sendGet url : " + url);
        String result = "";
        BufferedReader in = null;

        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.connect();

            String line;
            for(in = new BufferedReader(new InputStreamReader(conn.getInputStream())); (line = in.readLine()) != null; result = result + line) {
            }
        } catch (Exception var16) {
            this.logMsg("send GET Exception:" + var16);
            var16.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception var15) {
                var15.printStackTrace();
            }

        }

        return result;
    }

    protected void logMsg(String msg) {
        if (this.isShowLog) {
            System.out.println("CpsOpenApi : " + msg);
        }

    }

    protected String toMD5(String text) {
        this.logMsg("stringToMD5 text:" + text);
        Object var2 = null;

        byte[] secretBytes;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(text.getBytes());
        } catch (NoSuchAlgorithmException var5) {
            throw new RuntimeException("没有这个md5算法！");
        }

        String md5code = (new BigInteger(1, secretBytes)).toString(16);

        for(int i = 0; i < 32 - md5code.length(); ++i) {
            md5code = "0" + md5code;
        }

        this.logMsg("stringToMD5 res:" + md5code);
        return md5code;
    }

    protected String toSimpleString(Map<String, Object> mapData) {
        String res = "";
        if (mapData != null && !mapData.isEmpty()) {
            mapData = this.sortMapByKey(mapData);

            try {
                StringBuffer sb = new StringBuffer();
                Iterator var4 = mapData.entrySet().iterator();

                while(var4.hasNext()) {
                    Map.Entry<String, Object> entry = (Map.Entry)var4.next();
                    sb.append((String)entry.getKey() + entry.getValue());
                }

                res = sb.toString();
            } catch (Exception var6) {
                var6.printStackTrace();
            }
        }

        return res;
    }

    protected String toJsonString(Map<String, Object> map) {
        String res = "";
        if (map != null && !map.isEmpty()) {
            try {
                map = this.sortMapByKey(map);
                JSONObject params = new JSONObject();
                Iterator var4 = map.keySet().iterator();

                while(var4.hasNext()) {
                    String k = (String)var4.next();
                    if (k != null && !"".equals(k)) {
                        Object v = map.get(k);
                        if (v == null) {
                            v = "null";
                        }

                        params.put(k, v);
                    }
                }

                res = params.toString();
            } catch (Exception var7) {
                var7.printStackTrace();
            }
        }

        return res;
    }

    protected String toQueryString(Map<String, Object> map, String charset) {
        String res = "";
        if (map != null && !map.isEmpty()) {
            try {
                StringBuffer sb = new StringBuffer();
                Iterator var5 = map.keySet().iterator();

                while(var5.hasNext()) {
                    String k = (String)var5.next();
                    if (k != null && !"".equals(k)) {
                        String v = map.get(k).toString();
                        if (v == null) {
                            v = "null";
                        }

                        sb.append("&").append(k).append("=").append(URLEncoder.encode(v, charset));
                    }
                }

                res = sb.toString().substring(1);
            } catch (Exception var8) {
                var8.printStackTrace();
            }
        }

        return res;
    }

    protected Map<String, Object> sortMapByKey(Map<String, Object> map) {
        Map<String, Object> treeMap = new TreeMap(map);
        List<Map.Entry<String, Object>> list = new ArrayList(treeMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Object>>() {
            @Override
            public int compare(Map.Entry<String, Object> o1, Map.Entry<String, Object> o2) {
                return ((String)o1.getKey()).compareTo((String)o2.getKey());
            }
        });
        return treeMap;
    }
}
