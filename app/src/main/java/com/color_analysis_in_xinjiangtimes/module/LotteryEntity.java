package com.color_analysis_in_xinjiangtimes.module;

/**
 * Created by Administrator on 2017/12/4.
 */

public class LotteryEntity {
    public String expect;
    public String opencode;
    public String opentime;
    public String opentimestamp;
    @Override
    public String toString() {
        return "LotteryEntity{" +
                "expect='" + expect + '\'' +
                ", opencode='" + opencode + '\'' +
                ", opentime='" + opentime + '\'' +
                ", opentimestamp='" + opentimestamp + '\'' +
                '}';
    }
}
