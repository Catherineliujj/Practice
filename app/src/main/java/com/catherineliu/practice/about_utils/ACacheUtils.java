package com.catherineliu.practice.about_utils;

import android.content.Context;

public class ACacheUtils {
    public static ACache aCache;
    static Context mContext;
    private static ACache getaCache(){
        if (aCache==null)
        {
            aCache =  ACache.get(mContext);
        }
        return aCache;
    }
    public static String getAcString(Context mCContext,String key){
        mContext=mCContext;
        getaCache();
        String asString = aCache.getAsString(key);
        return asString;
    }

}
