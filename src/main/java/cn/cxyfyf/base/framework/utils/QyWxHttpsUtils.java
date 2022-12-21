package cn.cxyfyf.base.framework.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import okhttp3.*;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ObjectUtils;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 请求工具类
 */
public class QyWxHttpsUtils {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static OkHttpClient okHttpClient = null;

    /**
     * 构造 GET请求
     * @param url url
     * @param params params
     * @param token token
     * @return 响应流
     * @throws IOException io异常
     */
    public static Response doGet(String url, String token, Map<String, Object> params) throws IOException {
        //构造请求参数
        HttpUrl.Builder builder = Objects.requireNonNull(HttpUrl.parse(url)).newBuilder();
        builder.addQueryParameter("access_token", token);
        if(ObjectUtils.isNotEmpty(params)){
            params.forEach((k, v) -> {
                try {
                    builder.addQueryParameter(k,v instanceof String ? (String) v : mapper.writeValueAsString(v));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            });
        }
        Request request = new Request.Builder().header("Content-Type", "application/json").url(builder.build().toString()).get().build();

        //发出同步请求
        return getHttpClient().newCall(request).execute();
    }
    /**
     * 构造 GET请求
     * @param url url
     * @param params params
     * @return 响应流
     * @throws IOException io异常
     */
    public static Response doGet(String url, Map<String, Object> params) throws IOException {
        //构造请求参数
        HttpUrl.Builder builder = Objects.requireNonNull(HttpUrl.parse(url)).newBuilder();
        if(ObjectUtils.isNotEmpty(params)){
            params.forEach((k, v) -> {
                try {
                    builder.addQueryParameter(k,v instanceof String ? (String) v : mapper.writeValueAsString(v));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            });
        }
        Request request = new Request.Builder().header("Content-Type", "application/json").url(builder.build().toString()).get().build();

        //发出同步请求
        return getHttpClient().newCall(request).execute();
    }

    /**
     * 构造携带accessToken POST 请求
     * @param url url
     * @param token token
     * @param fromParam query请求参数 例：?userId=1&userName=张三
     * @param bodyParam 传参 raw格式
     * @return 响应流
     * @throws IOException io异常
     */
    public static Response doPost(String url, String token, Map<String, Object> fromParam, Map<String, Object> bodyParam) throws IOException {
        //构造请求参数
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(url)).newBuilder();
        urlBuilder.addQueryParameter("access_token", token);
        if(ObjectUtils.isNotEmpty(fromParam)){
            fromParam.forEach((k, v) -> {
                try {
                    urlBuilder.addQueryParameter(k,v instanceof String ? (String) v : mapper.writeValueAsString(v));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            });
        }
        //构造请求体
        RequestBody requestBody = RequestBody.
                create(MediaType.parse("application/json;charset=utf-8"), JSON.toJSONString(bodyParam));
        Request.Builder builder  = new Request.Builder();
        Request request = builder.url(urlBuilder.build().toString()).post(requestBody).build();
        //发出同步请求
        return getHttpClient().newCall(request).execute();
    }
    /**
     * 构造携带accessToken POST 请求
     * @param url url
     * @param fromParam query请求参数 例：?userId=1&userName=张三
     * @param bodyParam 传参 raw格式
     * @return 响应流
     * @throws IOException io异常
     */
    public static Response doPost(String url, Map<String, Object> fromParam, Map<String, Object> bodyParam) throws IOException {
        //构造请求参数
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(url)).newBuilder();
        if(ObjectUtils.isNotEmpty(fromParam)){
            fromParam.forEach((k, v) -> {
                try {
                    urlBuilder.addQueryParameter(k,v instanceof String ? (String) v : mapper.writeValueAsString(v));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            });
        }
        //构造请求体
        RequestBody requestBody = RequestBody.
                create(MediaType.parse("application/json;charset=utf-8"), JSON.toJSONString(bodyParam));
        Request.Builder builder  = new Request.Builder();
        Request request = builder.url(urlBuilder.build().toString()).post(requestBody).build();
        //发出同步请求
        return getHttpClient().newCall(request).execute();
    }

    /**
     * 构造携带accessToken POST 请求
     * @param url url
     * @param fromParam form 表单参数
     * @param headers 自定义请求头
     * @return 响应流
     */
    @SneakyThrows
    public static Response doPostForm(String url, Map<String, Object> fromParam, Map<String, Object> headers) {
        //构造请求参数
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(url)).newBuilder();
        //构造请求体
        MultipartBody.Builder mBuilder = new MultipartBody.Builder();
        mBuilder.setType(MultipartBody.FORM);
        if (MapUtils.isNotEmpty(fromParam))
            fromParam.forEach((k, v) -> mBuilder.addFormDataPart(k, String.valueOf(v)));
        MultipartBody multipartBody = mBuilder.build();

        Request.Builder builder  = new Request.Builder();
        if (MapUtils.isNotEmpty(headers))
            headers.forEach((k, v) -> builder.addHeader(k, String.valueOf(v)));
        Request request = builder.url(urlBuilder.build().toString()).post(multipartBody).build();

        //发出同步请求
        return getHttpClient().newCall(request).execute();
    }

    /**
     * okhttp3 响应处理,返回jsonObject
     * @param response 响应流
     * @return JSONObject
     */
    public static JSONObject getResponseObject(Response response){
        try {
            if (response != null && response.body() != null) {
                return JSON.parseObject(response.body().byteStream(), JSONObject.class, Feature.OrderedField);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * okhttp3 响应处理
     * @param response 响应流
     * @param cls class
     * @return class
     */
    public static <T> T getResponseObject(Response response, Class<T> cls){
        try {
            if (response != null && response.body() != null) {
                return JSON.parseObject(response.body().byteStream(), cls, Feature.OrderedField);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * okhttp3 响应处理
     * @param response 响应流
     * @param cls class
     * @param feature feature
     * @return class
     */
    public static <T> T getResponseObject(Response response, Class<T> cls, Feature feature){
        try {
            if (response != null && response.body() != null) {
                return JSON.parseObject(response.body().byteStream(), cls, feature);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 创建ssl 单例http client
     * @return 忽略证书的https请求
     */
    public static synchronized OkHttpClient getHttpClient() {

        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder()
                    .sslSocketFactory(SSLSocketClient.getSSLSocketFactory(), SSLSocketClient.getX509TrustManager())
                    .hostnameVerifier(SSLSocketClient.getHostnameVerifier())
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60,TimeUnit.SECONDS)
                    .connectTimeout(60,TimeUnit.SECONDS)
                    .build();
        }

        return okHttpClient;
    }

}