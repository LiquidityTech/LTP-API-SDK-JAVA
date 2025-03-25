package rapdix.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private int code;
    private String message = "";
    private T data;

    @SuppressWarnings("unchecked")
    public static <T> ApiResponse<T> success(T data) {
        ApiResponse<T> result = new ApiResponse<>();
        result.setCode(200000);
        result.setMessage("Success");
        result.setData(data == null ? (T) Collections.emptyMap() : data);
        return result;
    }

    @SuppressWarnings("unchecked")
    public static <T> ApiResponse<T> fail(int code, String message) {
        ApiResponse<T> result = new ApiResponse<>();
        result.setCode(code);
        result.setData((T) Collections.emptyMap());
        result.setMessage(message);
        return result;
    }

    @SuppressWarnings("unchecked")
    public static <T> ApiResponse<T> fail(String message) {
        ApiResponse<T> result = new ApiResponse<>();
        result.setCode(400000);
        result.setData((T) Collections.emptyMap());
        result.setMessage(message);
        return result;
    }
}