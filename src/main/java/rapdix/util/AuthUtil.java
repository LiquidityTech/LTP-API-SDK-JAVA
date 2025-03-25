package rapdix.util;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.*;

public class AuthUtil {
    /**
     * Get the current time, in seconds
     */
    public static String gmtNow() {
        return String.valueOf(Instant.now().getEpochSecond());
    }

    /**
     * Generate signature for HTTP requests
     */
    public static String getSign(String jsonRequest, String secretKey, String nonce) {
        String payload = getPayloadForSign(jsonRequest);
        payload += "&" + nonce;
        try {
            String MAC_NAME = "HmacSHA256";
            String ENCODING = "UTF-8";
            byte[] data = secretKey.getBytes(ENCODING);
            SecretKey secretKeySpec = new SecretKeySpec(data, MAC_NAME);
            Mac mac = Mac.getInstance(MAC_NAME);
            mac.init(secretKeySpec);
            byte[] text = payload.getBytes(ENCODING);
            byte[] textFinal = mac.doFinal(text);

            String result;
            try (Formatter formatter = new Formatter()) {
                for (byte b : textFinal) {
                    formatter.format("%02x", b);
                }
                result = formatter.toString();
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Error generating sign", e);
        }
    }

    /**
     * Generate signature for WebSocket requests
     */
    public static String getWebSocketSign(String jsonRequest, String secretKey) {
        try {
            String MAC_NAME = "HmacSHA256";
            String ENCODING = "UTF-8";
            
            // Use the same parameter formatting method as HTTP requests
            String payload = getPayloadForSign(jsonRequest);
            System.out.println("WebSocket payload before signing: " + payload);
            
            byte[] data = secretKey.getBytes(ENCODING);
            SecretKey secretKeySpec = new SecretKeySpec(data, MAC_NAME);
            Mac mac = Mac.getInstance(MAC_NAME);
            mac.init(secretKeySpec);
            byte[] text = payload.getBytes(ENCODING);
            byte[] textFinal = mac.doFinal(text);

            String result;
            try (Formatter formatter = new Formatter()) {
                for (byte b : textFinal) {
                    formatter.format("%02x", b);
                }
                result = formatter.toString();
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Error generating WebSocket sign", e);
        }
    }

    /**
     * Generate payload
     */
    public static String getPayload(Map<String, Object> paramMap) {
        StringBuilder queryString = new StringBuilder();
        try {
            for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                if (queryString.length() > 0) {
                    queryString.append("&");
                }
                queryString.append(URLEncoder.encode(entry.getKey(), "UTF-8"))
                        .append("=")
                        .append(URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return queryString.toString();
    }

    /**
     * Generate payload for sign
     */
    public static String getPayloadForSign(String jsonRequest) {
        if (jsonRequest == null || jsonRequest.trim().isEmpty()) {
            return "";
        }
        
        StringBuilder queryString = new StringBuilder();
        try {
            JSONObject jsonObject = JSONObject.parseObject(jsonRequest);

            List<String> keys = new ArrayList<>(jsonObject.keySet());
            Collections.sort(keys);

            for (String key : keys) {
                if (queryString.length() > 0) {
                    queryString.append("&");
                }
                Object value = jsonObject.get(key);
                if (value instanceof JSONArray) {
                    JSONArray array = (JSONArray) value;
                    for (int i = 0; i < array.size(); i++) {
                        if (i > 0) {
                            queryString.append(",");
                        }
                        queryString.append(array.getString(i));
                    }
                } else {
                    queryString.append(key).append("=").append(value);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error generating payload for sign", e);
        }
        return queryString.toString();
    }

    /**
     * WebSocket-specific signature method
     */
    public static String getWebSocketLoginSign(String message, String secretKey) {
        try {
            byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
            byte[] messageBytes = message.getBytes();
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "HmacSHA256");
            sha256_HMAC.init(secretKeySpec);
            return Hex.encodeHexString(sha256_HMAC.doFinal(messageBytes));
        } catch (Exception e) {
            throw new RuntimeException("Error generating WebSocket login sign", e);
        }
    }
}
