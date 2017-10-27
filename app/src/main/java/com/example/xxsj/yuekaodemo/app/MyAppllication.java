package com.example.xxsj.yuekaodemo.app;

import android.app.Application;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by xxsj on 2017/9/26.
 */

public class MyAppllication extends Application {

    private static OkHttpClient okHttpClient;

    @Override
    public void onCreate() {
        super.onCreate();
        okHttpClient = new OkHttpClient();
        okHttpClient = okHttpClient.newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new MyLogInterceptor())//拦截器
                .build();

//使用Imageloader加载图片
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .memoryCacheExtraOptions(50, 50)//配置内存缓存图片的尺寸
                .memoryCacheSize(2 * 1024 * 1024)//配置内存缓存的大小
                .threadPoolSize(3)//配置加载图片的线程数
                .threadPriority(100)//配置线程的优先级
                .diskCacheSize(50 * 50)//在sdcard缓存50MB
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())//MD5这种方式生成缓存文件的名字
                .diskCacheFileCount(20)//配置sdcard缓存文件的数量
                .build();//配置构建完成

        //加载图片
        ImageLoader.getInstance().init(config);

    }

    public static OkHttpClient okHttpClient() {
        return okHttpClient;
    }

    //拦截器,可以修改header,可以通过拦截器打印日志
    public class MyLogInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request().newBuilder()
                    .header("hello", "lisi")
                    .build();
            HttpUrl url = request.url();
            String httpUrl = url.url().toString();
            Response response = chain.proceed(request);
            int code = response.code();
            return response;
        }
    }
}
