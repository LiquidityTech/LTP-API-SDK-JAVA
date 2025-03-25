package rapdix.client;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class RequestTimingInterceptor implements Interceptor {
    private final RequestTimingListener listener;

    public RequestTimingInterceptor(RequestTimingListener listener) {
        this.listener = listener;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long startTime = System.nanoTime();
        
        // 在发送请求之前通知监听器
        if (listener != null) {
            listener.onRequestStart(request.url().toString(), startTime);
        }
        
        return chain.proceed(request);
    }

    public interface RequestTimingListener {
        void onRequestStart(String url, long startTimeNanos);
    }
} 