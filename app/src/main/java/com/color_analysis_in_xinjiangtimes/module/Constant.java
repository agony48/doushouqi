package com.color_analysis_in_xinjiangtimes.module;
public class Constant {
    //成功
    public static final String SUCCESS_CODE = "1";
    //失败
    public static final String FAILURE_CODE = "2";

    public static final String MESSAGE_BROADCASET_ACTION = "message.action";

    public static final String KICK = "kick";

    public static final String TYPE = "TYPE";
    public static String Account = "";

    public static final String STRING_EXTRA = "STRING_EXTRA";
    public static final String STRING_EXTRA2 = "STRING_EXTRA2";

    public static String MESSAGE_EXTRA = "THIRDCITY.MESSAGE_EXTRA";

    /**
     * 彩票
     */
    public enum Lottery{
        SSC,FC3D,DLT,PL3,PL5,QLC,QXC,ZCBQC,ZCJQC,DF6J1,FJTC22X5,GDFC36X5
    }

    public enum WebType {
        //用户注册、关于我们、秒杀秘籍、积分说明、优惠券使用说明、Banner广告,商贸城
        REGISTER, ABOUT, LIMITE_SALES, INTEGRAL, COUPON, BANNER,LEVEL,MERCHANT,SHOPPINGMALL,GROWTH,SHOPPINGMALL2
    }
}
