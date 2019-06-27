package id.bakode.remote;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static id.bakode.remote.ApiConstant.API_URL;

/**
 * Created by A. A. Sumitro on 6/21/2019
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */
class ApiClient {

     private OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    private Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(provideOkHttpClient())
                .build();
    }

    ApiService apiServices() {
        return provideRetrofit()
                .create(ApiService.class);
    }

}
