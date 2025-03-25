package rapdix.client;


public interface HttpClient {

    public HttpClient getInstance();
    String doGet(String url, String jsonBody, String apiKey, String secretKey);
    String doPost(String url, String jsonBody,String apiKey, String secretKey);
    String doPut(String url, String jsonBody,String apiKey, String secretKey);
    String doDelete(String url, String jsonBody,String apiKey, String secretKey);

}
