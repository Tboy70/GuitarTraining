package com.example.data.module;

import com.example.data.entity.remote.ProgramRemoteEntity;
import com.example.data.entity.remote.TextRemoteEntity;
import com.example.data.entity.remote.UserRemoteEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
import rx.schedulers.Schedulers;

/**
 * Contains functions implementations concerning the API.
 */
@Singleton
public class APIModuleRetrofitImpl implements APIModule {

    // The base url to connect to the API.
    private static final String BASE_URL = "http://192.168.0.29/guitar_api/public/";

    // Interface declared below.
    private APIServiceInterface apiService;

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

    @Override
    public Observable<UserRemoteEntity> connectUser(String username, String password) {
        return apiService.connectUser(username, password);
    }

    @Override
    public Observable<TextRemoteEntity> getTextIntroProgram(int idText) {
        return apiService.getText(idText);
    }

    @Override
    public Observable<ProgramRemoteEntity> getProgramById(int idProgram) {
        return apiService.getProgram(idProgram);
    }

    @Override
    public Observable<List<ProgramRemoteEntity>> retrieveProgramsListByUserId(int userId) {
        return apiService.retrieveProgramsListByUserId(userId);
    }

    /**
     * Interface containing methods with access path to the API.
     */
    interface APIServiceInterface {

        /**
         * Method GET to retrieve a text given its id.
         *
         * @param idText Text ID.
         * @return Observable in JSON format.
         */
        @GET("text/{idText}")
        Observable<TextRemoteEntity> getText(
                @Path("idText") int idText
        );

        /**
         * Method GET to retrieve a program given its id.
         *
         * @param idProgram Program ID to be retrieved.
         * @return Observable in JSON format.
         */
        @GET("program/{idProgram}")
        Observable<ProgramRemoteEntity> getProgram(
                @Path("idProgram") int idProgram
        );

        /**
         * Method GET to retrieve all programs of one user.
         *
         * @param userId Id of the desired user.
         * @return Observable in JSON format.
         */
        @GET("programs/{userId}")
        Observable<List<ProgramRemoteEntity>> retrieveProgramsListByUserId(@Path("userId") int userId);

        /**
         * Method POST to connect user.
         *
         * @param username User login.
         * @param password User password.
         * @return Observable in JSON format.
         */
        @FormUrlEncoded
        @POST("connect")
        Observable<UserRemoteEntity> connectUser(
                @Field("username") String username,
                @Field("password") String password
        );
    }
}
