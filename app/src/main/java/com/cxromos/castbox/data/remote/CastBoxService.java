package com.cxromos.castbox.data.remote;

import android.content.Context;

import com.cxromos.castbox.BuildConfig;
import com.cxromos.castbox.data.model.Casts;
import com.cxromos.castbox.data.model.Tracks;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface CastBoxService {
    String ENDPOINT = "https://data.castbox.fm/";

    @GET("top")
    Observable<Casts> getMedia(@Query("country") String country, @Query("skip") int skip, @Query("limit") int limit);
    @GET("track")
    Observable<Tracks> getTracks(@Query("key") String key);

    class Factory {
        private final OkHttpClient okHttpClient;
        private final HttpLoggingInterceptor httpLoggingInterceptor;

        @Inject
        public Factory(OkHttpClient okHttpClient, HttpLoggingInterceptor httpLoggingInterceptor) {
            this.okHttpClient = okHttpClient;
            this.httpLoggingInterceptor = httpLoggingInterceptor;
        }
    }
}
