package com.samboy.shaadoow.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.samboy.shaadoow.consts.SC;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {

    private static Retrofit rf = null;
    private static ApiService api = null;

    private static Retrofit getRetroInstance() {
        if (rf == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .registerTypeAdapter(int.class, new IntTypeAdapter())
                    .registerTypeAdapter(Integer.class, new IntTypeAdapter()).create();

            rf = new Retrofit.Builder()
                    .baseUrl(SC.BASE_URL)
                    .client(getClient())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return rf;

    }

    /***** ADDING TIMEOUT AND HOST VERIFIER ******/
    private static OkHttpClient getClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.protocols(Arrays.asList(Protocol.HTTP_2, Protocol.HTTP_1_1, Protocol.SPDY_3));
        httpClient.connectTimeout(20, TimeUnit.SECONDS);
        httpClient.readTimeout(20000, TimeUnit.SECONDS);
        httpClient.writeTimeout(10000, TimeUnit.SECONDS);
        httpClient.retryOnConnectionFailure(true);
        httpClient.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        });
        return httpClient.build();
    }

    public static ApiService getApiService() {
        if (api == null){
            api = getRetroInstance().create(ApiService.class);
        }
        return api;
    }

    /***** TO AVOID INT MISMATCH ******/
    public static class IntTypeAdapter extends TypeAdapter<Number> {
        @Override
        public void write(JsonWriter out, Number value)
                throws IOException {
            out.value(value);
        }

        @Override
        public Number read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            try {
                String result = in.nextString();
                if ("".equals(result)) {
                    return null;
                }
                return Integer.parseInt(result);
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }
    }
}
