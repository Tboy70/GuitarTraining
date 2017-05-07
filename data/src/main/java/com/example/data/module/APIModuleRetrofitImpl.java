package com.example.data.module;

import com.example.data.entity.ExerciseEntity;
import com.example.data.entity.ProgramEntity;
import com.example.data.entity.TextEntity;
import com.example.data.entity.UserEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Implementation of the interface "APIModule".
 * Contains functions implementations concerning the API.
 */
@Singleton
public class APIModuleRetrofitImpl implements APIModule {

    // The base url to connect to the API.
    private static final String BASE_URL = "http://192.168.1.15/guitarAPI/web/app_dev.php/";

    // Interface declared below.
    private APIServiceInterface apiService;

    /**
     * Interface containing methods with access path to the API.
     */
    interface APIServiceInterface {

        /**
         * Method GET to retrieve all the users of the application.
         * @return Observable in JSON format.
         */
        @GET("users")
        Observable<List<UserEntity>> allUsers();

        // TODO : COMMENT
        @GET("info_text")
        Observable<DefaultRequestResponseEnvelope> appInfo();

        // TODO : CHECK PASSAGE OF PARAM ^^
        @GET("program/{idProgram}")
        Observable<ProgramEntity> getProgram(int idProgram);
    }

    @Inject
    @SuppressWarnings("WeakerAccess")
    public APIModuleRetrofitImpl() {
        Gson gson = new GsonBuilder().create();
        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(rxAdapter)
                .client(client)
                .build();
        apiService = retrofit.create(APIServiceInterface.class);
    }

    /**
     * Get all the users of the application.
     * @return Observable -> List of UserEntity.
     */
    @Override
    public Observable<List<UserEntity>> getAllUsers() {
        return apiService.allUsers();
    }

    /**
     * Get the application information.
     * @return Observable -> A TextEntity.
     */
    @Override
    public Observable<TextEntity> getApplicationAboutInformation() {
        Observable<DefaultRequestResponseEnvelope> defaultRequestResponseEnvelope = apiService.appInfo();
        return defaultRequestResponseEnvelope.map(new Func1<DefaultRequestResponseEnvelope, TextEntity>() {
            @Override
            public TextEntity call(DefaultRequestResponseEnvelope defaultRequestResponseEnvelope) {
                if (defaultRequestResponseEnvelope.results.size() == 1) {
                    return defaultRequestResponseEnvelope.results.get(0);
                } else {
                    return null;
                }
            }
        });
    }

    @Override
    public Observable<ProgramEntity> getProgramById(int idProgram) {
        return apiService.getProgram(idProgram);
    }

    /**
     * An envelope to map the JSON from the API.
     */
    //TODO : Rename.
    private class DefaultRequestResponseEnvelope {
        @SuppressWarnings("unused")
        @SerializedName("success")
        boolean success;

        @SerializedName("results")
        List<TextEntity> results;
    }
}
