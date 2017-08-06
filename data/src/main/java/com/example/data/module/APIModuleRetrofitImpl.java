package com.example.data.module;

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
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
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
    private static final String BASE_URL = "http://192.168.1.15/guitar_api/public/";

    // Interface declared below.
    private APIServiceInterface apiService;

    /**
     * Interface containing methods with access path to the API.
     */
    interface APIServiceInterface {

        /**
         * Method GET to retrieve all the users of the application.
         *
         * @return Observable in JSON format.
         */
        @GET("users")
        Observable<List<UserEntity>> allUsers();

        /**
         * Method GET to retrieve the information text about the application.
         *
         * @return Observable in JSON format.
         */
        @GET("info_text")
        Observable<ApplicationInformationTextEnvelope> appInfo();

        /**
         * Method GET to retrieve a text given its id.
         *
         * @param idText Text ID.
         * @return Observable in JSON format
         */
        @GET("text/{idText}")
        Observable<TextEntity> getText(
                @Path("idText") int idText
        );

        /**
         * Method GET to retrieve a program given its id.
         *
         * @param idProgram Program ID to be retrieved.
         * @return Observable in JSON format.
         */
        @GET("program/{idProgram}")
        Observable<ProgramEntity> getProgram(
                @Path("idProgram") int idProgram
        );

        @FormUrlEncoded
        @POST("connect")
        Observable<UserEntity> connectUser(
                @Field("username") String username,
                @Field("password") String password
        );
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
     *
     * @return Observable -> List of UserEntity.
     */
    @Override
    public Observable<List<UserEntity>> getAllUsers() {
        return apiService.allUsers();
    }

    /**
     * Get the application information.
     *
     * @return Observable -> A TextEntity.
     */
    @Override
    public Observable<TextEntity> getInformationTextAboutApplication() {
        Observable<ApplicationInformationTextEnvelope> defaultRequestResponseEnvelope = apiService.appInfo();
        return defaultRequestResponseEnvelope.map(new Func1<ApplicationInformationTextEnvelope, TextEntity>() {
            @Override
            public TextEntity call(ApplicationInformationTextEnvelope applicationInformationTextEnvelope) {
                if (applicationInformationTextEnvelope.results.size() == 1) {
                    return applicationInformationTextEnvelope.results.get(0);
                } else {
                    return null;
                }
            }
        });
    }

    /**
     * Get a program given an ID.
     *
     * @param idProgram Program ID to be retrieved.
     * @return Observable -> A ProgramEntity.
     */
    @Override
    public Observable<ProgramEntity> getProgramById(int idProgram) {
        return apiService.getProgram(idProgram);
    }

    @Override
    public Observable<TextEntity> getTextIntroProgram(int idText) {
        return apiService.getText(idText);
    }

    @Override
    public Observable<UserEntity> connectUser(String username, String password) {
        return apiService.connectUser(username, password);
    }

    /**
     * An envelope to map the JSON from the API.
     */
    private class ApplicationInformationTextEnvelope {
        @SuppressWarnings("unused")
        @SerializedName("success")
        boolean success;

        @SerializedName("results")
        List<TextEntity> results;
    }
}
