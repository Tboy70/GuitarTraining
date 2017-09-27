package com.example.data.module;

import com.example.data.entity.remote.ExerciseRemoteEntity;
import com.example.data.entity.remote.ProgramRemoteEntity;
import com.example.data.entity.remote.TextRemoteEntity;
import com.example.data.entity.remote.UserRemoteEntity;
import com.example.data.entity.remote.program.ProgramResponseRemoteEntity;
import com.example.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;
import rx.functions.Func1;
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
    public Observable<UserRemoteEntity> connectUser(UserRemoteEntity userRemoteEntity) {
        return apiService.connectUser(userRemoteEntity);
    }

    @Override
    public Observable<TextRemoteEntity> getTextIntroProgram(int idText) {
        return apiService.getText(idText);
    }

    @Override
    public Observable<ProgramRemoteEntity> getProgramById(String idProgram) {
        return apiService.getProgram(idProgram);
    }

    @Override
    public Observable<List<ProgramRemoteEntity>> retrieveProgramsListByUserId(String userId) {
        return apiService.retrieveProgramsListByUserId(userId);
    }

    @Override
    public Observable<String> createProgram(ProgramRemoteEntity programRemoteEntity) {
        return apiService.createProgram(programRemoteEntity).map(new Func1<Response<ProgramResponseRemoteEntity>, String>() {
            @Override
            public String call(Response<ProgramResponseRemoteEntity> programResponseRemoteEntityResponse) {
                if (programResponseRemoteEntityResponse.isSuccessful() && programResponseRemoteEntityResponse.body() != null) {
                    return programResponseRemoteEntityResponse.body().getCreatedId();
                } else {
                    return null;
                }
            }
        });
    }

    @Override
    public Observable<Boolean> createExercise(List<ExerciseRemoteEntity> exerciseRemoteEntity) {
        return apiService.createExercise(exerciseRemoteEntity).map(new Func1<Response<Void>, Boolean>() {
            @Override
            public Boolean call(Response<Void> voidResponse) {
                return voidResponse.isSuccessful();
            }
        });
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
                @Path("idProgram") String idProgram
        );

        /**
         * Method GET to retrieve all programs of one user.
         *
         * @param userId Id of the desired user.
         * @return Observable in JSON format.
         */
        @GET("programs/{userId}")
        Observable<List<ProgramRemoteEntity>> retrieveProgramsListByUserId(@Path("userId") String userId);

        @POST("connect")
        Observable<UserRemoteEntity> connectUser(@Body UserRemoteEntity userRemoteEntity);

        @POST("program")
        Observable<Response<ProgramResponseRemoteEntity>> createProgram(@Body ProgramRemoteEntity programRemoteEntity);

        @POST("exercise")
        Observable<Response<Void>> createExercise(@Body List<ExerciseRemoteEntity> exerciseRemoteEntity);
    }
}
