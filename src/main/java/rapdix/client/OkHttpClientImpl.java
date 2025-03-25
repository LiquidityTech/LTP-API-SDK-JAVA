package rapdix.client;


import rapdix.util.AuthUtil;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OkHttpClientImpl implements HttpClient {

    private final OkHttpClient httpClient;
    private static final MediaType JSON_TYPE = MediaType.parse("application/json");
    private RequestTimingInterceptor.RequestTimingListener timingListener;

    public OkHttpClientImpl() {
        this(null);
    }

    public OkHttpClientImpl(RequestTimingInterceptor.RequestTimingListener listener) {
        this.timingListener = listener;
        this.httpClient = new OkHttpClient.Builder()
                .connectionPool(new ConnectionPool(200, 10, TimeUnit.SECONDS))
                .addInterceptor(new RequestTimingInterceptor(listener))
                .build();
    }

    public void setTimingListener(RequestTimingInterceptor.RequestTimingListener listener) {
        this.timingListener = listener;
    }

    public OkHttpClientImpl getInstance() {
        return new OkHttpClientImpl(this.timingListener);
    }

    @Override
    public String doGet(String url, String jsonBody, String apiKey, String secretKey) {
        String nonce = AuthUtil.gmtNow();
        String signature = AuthUtil.getSign(jsonBody, secretKey, nonce);
        if (jsonBody != null && !jsonBody.isEmpty()) {
            url = url + "?" + AuthUtil.getPayloadForSign(jsonBody);
        }
        Request request = new Request.Builder()
                .url(url)
                .header("Content-Type", "application/json")
                .header("nonce", nonce)
                .header("signature", signature)
                .header("X-MBX-APIKEY", apiKey)
                .get()
                .build();
        try (Response response = httpClient.newCall(request).execute()) {
            if (response.code() == 429)
                return "{\"code\":429, \"message\":\"Too Many Request\", \"data\":null}";
            else
                return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String doPost(String url, String jsonBody, String apiKey, String secretKey) {
        String nonce = AuthUtil.gmtNow();
        String signature = AuthUtil.getSign(jsonBody, secretKey, nonce);
        RequestBody body = RequestBody.create(JSON_TYPE, jsonBody);

        Request request = new Request.Builder()
                .url(url)
                .header("Content-Type", "application/json")
                .header("nonce", nonce)
                .header("signature", signature)
                .header("X-MBX-APIKEY", apiKey)
                .post(body)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (response.code() == 429)
                return "{\"code\":429, \"message\":\"Too Many Request\", \"data\":null}";
            else
                return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String doPut(String url, String jsonBody, String apiKey, String secretKey) {
        String nonce = AuthUtil.gmtNow();
        String signature = AuthUtil.getSign(jsonBody, secretKey, nonce);
        RequestBody body = RequestBody.create(JSON_TYPE, jsonBody);

        Request request = new Request.Builder()
                .url(url)
                .header("Content-Type", "application/json")
                .header("nonce", nonce)
                .header("signature", signature)
                .header("X-MBX-APIKEY", apiKey)
                .put(body)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (response.code() == 429)
                return "{\"code\":429, \"message\":\"Too Many Request\", \"data\":null}";
            else
                return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String doDelete(String url, String jsonBody, String apiKey, String secretKey) {
        String nonce = AuthUtil.gmtNow();
        String signature = AuthUtil.getSign(jsonBody, secretKey, nonce);
        RequestBody body = jsonBody == null ? RequestBody.create(JSON_TYPE, "") : RequestBody.create(JSON_TYPE, jsonBody);

        Request request = new Request.Builder()
                .url(url)
                .header("Content-Type", "application/json")
                .header("nonce", nonce)
                .header("signature", signature)
                .header("X-MBX-APIKEY", apiKey)
                .delete(body)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (response.code() == 429)
                return "{\"code\":429, \"message\":\"Too Many Request\", \"data\":null}";
            else
                return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
