package wss.com.mystudysolutions.application;

import android.app.Application;
import android.support.v4.app.FragmentTransaction;

import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import wss.com.mystudysolutions.R;

/**
 * Created by Chiranjit Jana on 20/10/2017.
 */

public class SingletoneApp extends Application {

    public static SingletoneApp intances=null;


    @Override
    public void onCreate() {
        super.onCreate();

        // UNIVERSAL IMAGE LOADER SETUP
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                .memoryCacheSize(2 * 1024 * 1024)
                .discCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP
    }

    public static ImageLoader getImageLoaderInstance()
    {
        return ImageLoader.getInstance();
    }

    public static DisplayImageOptions getImageLoaderOptions()
    {
        return new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri( R.drawable.ic_not_found)
                .showImageOnFail(R.drawable.ic_not_found)
                .showImageOnLoading(R.drawable.ic_not_found).build();
    }

    public static  SingletoneApp getIntances()
    {
        if(intances==null)
        {
            intances=new SingletoneApp();
        }

        return intances;
    }


}
