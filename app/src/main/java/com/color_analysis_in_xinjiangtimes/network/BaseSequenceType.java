package com.color_analysis_in_xinjiangtimes.network;

import java.util.List;

/**
 * Created by kalen on 15/7/25.
 */
public class BaseSequenceType <T>  extends BaseHeader {


    private List<T> data;

    public List<T> getList(){
        return data;
    }

    public int getSize(){
        return data == null ? 0 : data.size();
    }


}
