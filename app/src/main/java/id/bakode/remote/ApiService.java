package id.bakode.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by A. A. Sumitro on 6/21/2019
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */
interface ApiService {

    @GET("teams")
    Call<List<Team>> getData();

}