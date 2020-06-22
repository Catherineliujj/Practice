package com.catherineliu.practice.main_code.aboutt_retrofit_and_rxjava;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * 项目：Practice
 * 文件描述：Retrofit 2.0 使用的接口申明
 * 作者：ljj
 * 创建时间：2020/6/18
 */
public interface InfoService {

    /**
     * Get方式
     * @param address
     * @return
     */
    @GET("v_1_0_1/Block/blockAddressInfo")
    Call<DataInfos> getInfosGet(@Query("address") String address);

    /**
     * Post方式
     * @param address
     * @return
     */
    @POST("v_1_0_1/Block/blockAddressInfo")
    Call<DataInfos> getInfosPost(@Query("address") String address);

/* 总结：
    @Path：所有在网址中的参数（URL的问号前面），如：
    http://102.10.10.132/api/Accounts/{accountId}
    @Query：URL问号后面的参数，如：
    http://102.10.10.132/api/Comments?access_token={access_token}
    @QueryMap：相当于多个@Query
    @Field：用于POST请求，提交单个数据
    @Body：相当于多个@Field，以对象的形式提交

    使用@Field时记得添加@FormUrlEncoded
    若需要重新定义接口地址，可以使用@Url，将地址以参数的形式传入即可。
    eg:
    @GET
    Call<List<Activity>> getActivityList(@Url String url, @QueryMap Map<String, String> map);
    使用:
        Call<List<Activity>> call = service.getActivityList("http://115.159.198.162:3001/api/ActivitySubjects", map);
    */





    // 一个简单的get请求
    // eg: http://102.10.10.132/api/News
/*    @GET("News")
    Call<DataInfos> getItem();*/

    // URL中有参数
    // eg: http://102.10.10.132/api/News/{资讯id}
/*    @GET("News/{newsId}")
    Call<DataInfos> getItem(@Path("newsId") String newsId);*/

    // eg2: http://102.10.10.132/api/News/{资讯id}/{类型}
/*    @GET("News/{newsId}/{type}")
    Call<DataInfos> getItem(@Path("newsId") String newsId, @Path("type") String type);*/

    // 参数在URL问号之后
    // eg: http://102.10.10.132/api/News?newsId={资讯id}
/*    @GET("News")
    Call<DataInfos> getItem(@Query("newsId") String newsId);*/

    // eg2: http://102.10.10.132/api/News?newsId={资讯id}&type={类型}
/*    @GET("News")
    Call<DataInfos> getItem(@Query("newsId") String newsId, @Query("type") String type);*/

    // 多个参数在URL问号之后，且个数不确定
    // eg: http://102.10.10.132/api/News?newsId={资讯id}&type={类型}...
/*    @GET("News")
    Call<DataInfos> getItem(@QueryMap Map<String, String> map);

    @GET("News")
    Call<DataInfos> getItem(@Query("newsId") String newsId, @QueryMap Map<String, String> map);*/


    /**
     *  Post方式
     */
    // 需要补全URL，post的数据只有一条reason
    // eg: http://102.10.10.132/api/Comments/{newsId}
/*    @FormUrlEncoded
    @POST("Comments/{newsId}")
    Call<DataInfos> reportDataInfos(@Path("newsId") String commentId, @Field("reason") String reason);*/

    // 需要补全URL，问号后加入access_token，post的数据只有一条reason
    // eg: http://102.10.10.132/api/Comments/{newsId}?access_token={access_token}
/*    @FormUrlEncoded
    @POST("Comments/{newsId}")
    Call<DataInfos> reportDataInfos(@Path("newsId") String commentId, @Query("access_token") String access_token, @Field("reason") String reason);*/

    // 需要补全URL，问号后加入access_token，post一个body（对象）
    // eg: http://102.10.10.132/api/Comments/{newsId}?access_token={access_token}
/*    @POST("Comments/{newsId}")
    Call<DataInfos> reportDataInfos(@Path("newsId") String commentId, @Query("access_token") String access_token, @Body DataInfosBean bean);*/


    /**
     * Delete方式
     */
    // 需要补全URL
    // eg: http://102.10.10.132/api/Comments/{commentId}
/*    @DELETE("Comments/{commentId}")
    Call<ResponseBody> deleteNewsCommentFromAccount(@Path("commentId") String commentId);*/

    // 需要补全URL，问号后加入access_token
    // eg: http://102.10.10.132/api/Comments/{commentId}?access_token={access_token}
/*    @DELETE("Comments/{commentId}")
    Call<ResponseBody> deleteNewsCommentFromAccount(@Path("commentId") String commentId, @Query("access_token") String access_token);*/

    // 带有body
    // eg: http://102.10.10.132/api/Comments
/*    @HTTP(method = "DELETE",path = "Comments",hasBody = true)
    Call<ResponseBody> deleteCommont(@Body CommentBody body);*/

    /**
    * PUT方式
    */
    // 这个请求很少用到
    // eg: http://102.10.10.132/api/Accounts/{accountId}
/*    @PUT("Accounts/{accountId}")
    Call<ExtrasBean> updateExtras(@Path("accountId") String accountId, @Query("access_token") String access_token, @Body ExtrasBean bean);*/

}
