package com.stanny.zxmvpdemo.api.service;

import com.stanny.zxmvpdemo.bean.BeautyEntity;
import com.stanny.zxmvpdemo.bean.CodeSorceEntity;
import com.stanny.zxmvpdemo.bean.NewsEntity;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Create By Xiangb On 2017/7/11
 * 功能：接口列表
 */
public interface ApiService {

    /**
     * 这里我使用的是全地址，因为我用的接口不是一个来源的。
     * 一般的开发，全面的地址都是一样的，可以采用提前设置baseurl的方式
     * 即在ApiConstant中设置RELEASE_URL的值
     * 然后在GlobalConfiguration中先设置builder.baseurl(ApiConstants.RELEASE_URL)
     * 最后回到这个文件，@POST()中就只需要写baseurl之后的，如下：
     *
     * @POST("toutiao/index") Observable<NewsEntity> getNewsList(@QueryMap Map<String, String> map);
     **/


    @POST("http://v.juhe.cn/toutiao/index")
    Observable<NewsEntity> getNewsList(@QueryMap Map<String, String> map);

    //这一条的用法其实并不常见，只是我找的接口好像必须这样。。。
    //一般来说的请求模式，应该是上面的那种
    @GET
    Observable<BeautyEntity> getBeautyList(@Url String url);

    @GET
    Observable<CodeSorceEntity> getSourceList(@Url String url);

}
