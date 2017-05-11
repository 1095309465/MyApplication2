package com.chuangrong.tourism.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ZhouChengHua on 2016-10-12.
 */

public interface RetrofitApi {
    @GET("api/allScenicSpot")
    Call<ResponseBody> getAllScenicSpot(@Query("pageNum") String pageNum, @Query("pageSize") String pageSize);


}
