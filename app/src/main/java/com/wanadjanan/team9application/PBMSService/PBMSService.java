package com.wanadjanan.team9application.PBMSService;

import com.wanadjanan.team9application.PBMSService.PBMSDAO.work57160016;
import com.wanadjanan.team9application.PBMSService.PBMSDAO.work57160017;
import com.wanadjanan.team9application.PBMSService.PBMSDAO.work57160074;
import com.wanadjanan.team9application.PBMSService.PBMSDAO.work57160092;
import com.wanadjanan.team9application.PBMSService.PBMSDAO.work57160136;
import com.wanadjanan.team9application.PBMSService.PBMSDAO.work57160142;
import com.wanadjanan.team9application.PBMSService.PBMSDAO.work57160145;
import com.wanadjanan.team9application.PBMSService.PBMSDAO.work57160159;
import com.wanadjanan.team9application.PBMSService.PBMSDAO.work57160280;
import com.wanadjanan.team9application.PBMSService.PBMSDAO.work57160387;
import com.wanadjanan.team9application.PBMSService.PBMSDAO.work57160691;
import com.wanadjanan.team9application.PBMSService.PBMSDAO.work57160692;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by computer on 8/5/2560.
 */

public interface PBMSService {
    @FormUrlEncoded
    @POST("C_57160387/get_budget_Statuspj")
    Call<work57160387> sendData0387(@Field("bgy_id") String bgy_id);

    @FormUrlEncoded
    @POST("index.php/C_571600162/Pie_chart/")
    Call<work57160016> sendData0016(@Field("year") String year);

    @FormUrlEncoded
    @POST("index.php/C_57160692/Graph")
    Call<work57160692> sendData0692(@Field("year") String year);

    @FormUrlEncoded
    @POST("index.php/C_57160142/get_name_byid")
    Call<work57160142> sendData0142(@Field("bgy_id") String year);

    @FormUrlEncoded
    @POST("index.php/C_57160017/Graph/")
    Call<work57160017> sendData0017(@Field("year") String year);

    @FormUrlEncoded
    @POST("index.php/C_57160145/Graph/")
    Call<work57160145> sendData0145(@Field("year") String year);

    @FormUrlEncoded
    @POST("index.php/C_57160691/get_all_by_ms_C")
    Call<work57160691> sendData0691(@Field("bgy_id") String bgy_id);

    @FormUrlEncoded
    @POST("C_57160159/Graph")
    Call<work57160159> sendData0159(@Field("bgy_id") String bgy_id);

    @FormUrlEncoded
    @POST("C_57160092/Graph")
    Call<work57160092> sendData0092(@Field("bgy_id") String bgy_id);

    @FormUrlEncoded
    @POST("index.php/C_57160074/get_name_byid")
    Call<work57160074> sendData0074(@Field("year") String year);

    @FormUrlEncoded
    @POST("C_57160280/Barchart")
    Call<work57160280> sendData0280(@Field("bgy_id") String bgy_id);

    @FormUrlEncoded
    @POST("index.php/C_57160136/get_budget_Statuspj") // จองเก่า
    Call<work57160136> sendData0136(@Field("year") String year);
}
