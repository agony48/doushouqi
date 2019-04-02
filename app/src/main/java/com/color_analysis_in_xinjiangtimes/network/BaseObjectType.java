package com.color_analysis_in_xinjiangtimes.network;

/**
 * Created by kalen on 15/8/18.
 */
public class BaseObjectType<T> extends BaseHeader {

    public T api_data;

    public  T getObject(){
        return api_data;
    }

}
