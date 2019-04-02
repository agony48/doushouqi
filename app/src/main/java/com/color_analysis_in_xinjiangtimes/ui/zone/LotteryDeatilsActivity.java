package com.color_analysis_in_xinjiangtimes.ui.zone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.module.Constant;
import com.color_analysis_in_xinjiangtimes.module.LotteryEntity;
import com.color_analysis_in_xinjiangtimes.ui.TextHeaderActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * author 万强
 * date 16/5/24 上午9:46
 * desc ${热卖专区}
 */
public class LotteryDeatilsActivity extends TextHeaderActivity {
    private int type;
    private List<LotteryEntity> lotteryEntityList = new ArrayList<>();
    @Override
    public void setContentLayout() {
        setContentView(R.layout.activity_hotsales_zone);
        type = getIntent().getIntExtra(Constant.TYPE, Constant.WebType.REGISTER.ordinal());
    }
    @Override
    public void initTitleBar() {
        initHeaderStyle(HeaderStyle.LEFT, getString(R.string.zone_hotsales_title));
    }
    @Override
    public void initView() {
        if (type == Constant.Lottery.SSC.ordinal()) {
            title.setText("双色球历史开奖信息");
            getData("[{\"expect\":\"2017143\",\"opencode\":\"04,06,09,14,20,29+14\",\"opentime\":\"2017-12-05 21:18:20\",\"opentimestamp\":1512479900},{\"expect\":\"2017142\",\"opencode\":\"08,13,14,18,23,33+06\",\"opentime\":\"2017-12-03 21:18:20\",\"opentimestamp\":1512307100},{\"expect\":\"2017141\",\"opencode\":\"01,06,07,11,13,15+05\",\"opentime\":\"2017-11-30 21:18:20\",\"opentimestamp\":1512047900},{\"expect\":\"2017140\",\"opencode\":\"21,22,25,28,29,30+08\",\"opentime\":\"2017-11-28 21:18:20\",\"opentimestamp\":1511875100},{\"expect\":\"2017139\",\"opencode\":\"02,14,20,24,28,32+16\",\"opentime\":\"2017-11-26 21:18:20\",\"opentimestamp\":1511702300},{\"expect\":\"2017138\",\"opencode\":\"01,17,24,28,32,33+02\",\"opentime\":\"2017-11-23 21:18:20\",\"opentimestamp\":1511443100},{\"expect\":\"2017137\",\"opencode\":\"05,10,20,23,26,31+03\",\"opentime\":\"2017-11-21 21:18:20\",\"opentimestamp\":1511270300},{\"expect\":\"2017136\",\"opencode\":\"03,07,10,18,21,24+12\",\"opentime\":\"2017-11-19 21:18:20\",\"opentimestamp\":1511097500},{\"expect\":\"2017135\",\"opencode\":\"01,06,07,14,18,26+16\",\"opentime\":\"2017-11-16 21:18:20\",\"opentimestamp\":1510838300},{\"expect\":\"2017134\",\"opencode\":\"04,05,11,14,28,32+04\",\"opentime\":\"2017-11-14 21:18:20\",\"opentimestamp\":1510665500},{\"expect\":\"2017133\",\"opencode\":\"06,15,17,18,23,30+11\",\"opentime\":\"2017-11-12 21:18:20\",\"opentimestamp\":1510492700},{\"expect\":\"2017132\",\"opencode\":\"02,03,05,09,13,28+11\",\"opentime\":\"2017-11-09 21:18:20\",\"opentimestamp\":1510233500},{\"expect\":\"2017131\",\"opencode\":\"01,07,10,11,26,27+11\",\"opentime\":\"2017-11-07 21:18:20\",\"opentimestamp\":1510060700},{\"expect\":\"2017130\",\"opencode\":\"05,13,14,23,25,31+02\",\"opentime\":\"2017-11-05 21:18:20\",\"opentimestamp\":1509887900},{\"expect\":\"2017129\",\"opencode\":\"05,06,09,14,21,33+02\",\"opentime\":\"2017-11-02 21:18:20\",\"opentimestamp\":1509628700}]");
        } else if (type == Constant.Lottery.FC3D.ordinal()) {
            title.setText("福彩3D历史开奖信息");
            getData("[{\"expect\":\"2017333\",\"opencode\":\"4,4,2\",\"opentime\":\"2017-12-06 21:20:00\",\"opentimestamp\":1512566400},{\"expect\":\"2017332\",\"opencode\":\"8,0,4\",\"opentime\":\"2017-12-05 21:20:00\",\"opentimestamp\":1512480000},{\"expect\":\"2017331\",\"opencode\":\"7,8,2\",\"opentime\":\"2017-12-04 21:20:00\",\"opentimestamp\":1512393600},{\"expect\":\"2017330\",\"opencode\":\"4,3,0\",\"opentime\":\"2017-12-03 21:20:00\",\"opentimestamp\":1512307200},{\"expect\":\"2017329\",\"opencode\":\"9,1,3\",\"opentime\":\"2017-12-02 21:20:00\",\"opentimestamp\":1512220800},{\"expect\":\"2017328\",\"opencode\":\"0,3,0\",\"opentime\":\"2017-12-01 21:20:00\",\"opentimestamp\":1512134400},{\"expect\":\"2017327\",\"opencode\":\"3,5,1\",\"opentime\":\"2017-11-30 21:20:00\",\"opentimestamp\":1512048000},{\"expect\":\"2017326\",\"opencode\":\"4,9,0\",\"opentime\":\"2017-11-29 21:20:00\",\"opentimestamp\":1511961600},{\"expect\":\"2017325\",\"opencode\":\"4,0,6\",\"opentime\":\"2017-11-28 21:20:00\",\"opentimestamp\":1511875200},{\"expect\":\"2017324\",\"opencode\":\"6,3,7\",\"opentime\":\"2017-11-27 21:20:00\",\"opentimestamp\":1511788800},{\"expect\":\"2017323\",\"opencode\":\"2,8,0\",\"opentime\":\"2017-11-26 21:20:00\",\"opentimestamp\":1511702400},{\"expect\":\"2017322\",\"opencode\":\"4,1,9\",\"opentime\":\"2017-11-25 21:20:00\",\"opentimestamp\":1511616000},{\"expect\":\"2017321\",\"opencode\":\"1,8,8\",\"opentime\":\"2017-11-24 21:20:00\",\"opentimestamp\":1511529600},{\"expect\":\"2017320\",\"opencode\":\"5,4,3\",\"opentime\":\"2017-11-23 21:20:00\",\"opentimestamp\":1511443200},{\"expect\":\"2017319\",\"opencode\":\"1,0,5\",\"opentime\":\"2017-11-22 21:20:00\",\"opentimestamp\":1511356800}]");
        } else if (type == Constant.Lottery.DLT.ordinal()) {
            title.setText("大乐透历史开奖信息");
            getData("[{\"expect\":\"2017143\",\"opencode\":\"06,09,24,29,32+02,07\",\"opentime\":\"2017-12-06 20:33:20\",\"opentimestamp\":1512563600},{\"expect\":\"2017142\",\"opencode\":\"01,05,16,19,28+02,10\",\"opentime\":\"2017-12-04 20:33:20\",\"opentimestamp\":1512390800},{\"expect\":\"2017141\",\"opencode\":\"02,08,21,22,29+03,05\",\"opentime\":\"2017-12-02 20:33:20\",\"opentimestamp\":1512218000},{\"expect\":\"2017140\",\"opencode\":\"10,16,25,26,29+01,05\",\"opentime\":\"2017-11-29 20:33:20\",\"opentimestamp\":1511958800},{\"expect\":\"2017139\",\"opencode\":\"02,06,19,25,32+09,12\",\"opentime\":\"2017-11-27 20:33:20\",\"opentimestamp\":1511786000},{\"expect\":\"2017138\",\"opencode\":\"04,07,09,20,25+02,11\",\"opentime\":\"2017-11-25 20:33:20\",\"opentimestamp\":1511613200},{\"expect\":\"2017137\",\"opencode\":\"01,20,22,28,29+05,07\",\"opentime\":\"2017-11-22 20:33:20\",\"opentimestamp\":1511354000},{\"expect\":\"2017136\",\"opencode\":\"01,11,20,21,22+03,04\",\"opentime\":\"2017-11-20 20:33:20\",\"opentimestamp\":1511181200},{\"expect\":\"2017135\",\"opencode\":\"01,12,15,19,22+02,04\",\"opentime\":\"2017-11-18 20:33:20\",\"opentimestamp\":1511008400},{\"expect\":\"2017134\",\"opencode\":\"07,18,19,32,34+02,10\",\"opentime\":\"2017-11-15 20:33:20\",\"opentimestamp\":1510749200},{\"expect\":\"2017133\",\"opencode\":\"15,17,19,32,33+01,03\",\"opentime\":\"2017-11-13 20:33:20\",\"opentimestamp\":1510576400},{\"expect\":\"2017132\",\"opencode\":\"11,17,23,26,27+01,10\",\"opentime\":\"2017-11-11 20:33:20\",\"opentimestamp\":1510403600},{\"expect\":\"2017131\",\"opencode\":\"03,05,08,19,34+01,12\",\"opentime\":\"2017-11-08 20:33:20\",\"opentimestamp\":1510144400},{\"expect\":\"2017130\",\"opencode\":\"05,18,28,33,34+03,04\",\"opentime\":\"2017-11-06 20:33:20\",\"opentimestamp\":1509971600},{\"expect\":\"2017129\",\"opencode\":\"05,17,20,32,33+04,09\",\"opentime\":\"2017-11-04 20:33:20\",\"opentimestamp\":1509798800}]");
        } else if (type == Constant.Lottery.PL3.ordinal()) {
            title.setText("排列3历史开奖信息");
            getData("[{\"expect\":\"2017333\",\"opencode\":\"4,2,7\",\"opentime\":\"2017-12-06 20:32:00\",\"opentimestamp\":1512563520},{\"expect\":\"2017332\",\"opencode\":\"3,2,1\",\"opentime\":\"2017-12-05 20:32:00\",\"opentimestamp\":1512477120},{\"expect\":\"2017331\",\"opencode\":\"0,9,8\",\"opentime\":\"2017-12-04 20:32:00\",\"opentimestamp\":1512390720},{\"expect\":\"2017330\",\"opencode\":\"3,8,5\",\"opentime\":\"2017-12-03 20:32:00\",\"opentimestamp\":1512304320},{\"expect\":\"2017329\",\"opencode\":\"5,3,5\",\"opentime\":\"2017-12-02 20:32:00\",\"opentimestamp\":1512217920},{\"expect\":\"2017328\",\"opencode\":\"6,2,1\",\"opentime\":\"2017-12-01 20:32:00\",\"opentimestamp\":1512131520},{\"expect\":\"2017327\",\"opencode\":\"1,4,5\",\"opentime\":\"2017-11-30 20:32:00\",\"opentimestamp\":1512045120},{\"expect\":\"2017326\",\"opencode\":\"7,2,3\",\"opentime\":\"2017-11-29 20:32:00\",\"opentimestamp\":1511958720},{\"expect\":\"2017325\",\"opencode\":\"5,0,9\",\"opentime\":\"2017-11-28 20:32:00\",\"opentimestamp\":1511872320},{\"expect\":\"2017324\",\"opencode\":\"8,2,8\",\"opentime\":\"2017-11-27 20:32:00\",\"opentimestamp\":1511785920},{\"expect\":\"2017323\",\"opencode\":\"5,7,2\",\"opentime\":\"2017-11-26 20:32:00\",\"opentimestamp\":1511699520},{\"expect\":\"2017322\",\"opencode\":\"1,7,3\",\"opentime\":\"2017-11-25 20:32:00\",\"opentimestamp\":1511613120},{\"expect\":\"2017321\",\"opencode\":\"4,3,5\",\"opentime\":\"2017-11-24 20:32:00\",\"opentimestamp\":1511526720},{\"expect\":\"2017320\",\"opencode\":\"0,3,6\",\"opentime\":\"2017-11-23 20:32:00\",\"opentimestamp\":1511440320},{\"expect\":\"2017319\",\"opencode\":\"9,3,9\",\"opentime\":\"2017-11-22 20:32:00\",\"opentimestamp\":1511353920}]");
        }else if (type == Constant.Lottery.PL5.ordinal()) {
            title.setText("排列5历史开奖信息");
            getData("[{\"expect\":\"2017333\",\"opencode\":\"4,2,7,4,9\",\"opentime\":\"2017-12-06 20:32:00\",\"opentimestamp\":1512563520},{\"expect\":\"2017332\",\"opencode\":\"3,2,1,5,8\",\"opentime\":\"2017-12-05 20:32:00\",\"opentimestamp\":1512477120},{\"expect\":\"2017331\",\"opencode\":\"0,9,8,5,9\",\"opentime\":\"2017-12-04 20:32:00\",\"opentimestamp\":1512390720},{\"expect\":\"2017330\",\"opencode\":\"3,8,5,7,8\",\"opentime\":\"2017-12-03 20:32:00\",\"opentimestamp\":1512304320},{\"expect\":\"2017329\",\"opencode\":\"5,3,5,7,6\",\"opentime\":\"2017-12-02 20:32:00\",\"opentimestamp\":1512217920},{\"expect\":\"2017328\",\"opencode\":\"6,2,1,2,1\",\"opentime\":\"2017-12-01 20:32:00\",\"opentimestamp\":1512131520},{\"expect\":\"2017327\",\"opencode\":\"1,4,5,4,3\",\"opentime\":\"2017-11-30 20:32:00\",\"opentimestamp\":1512045120},{\"expect\":\"2017326\",\"opencode\":\"7,2,3,1,4\",\"opentime\":\"2017-11-29 20:32:00\",\"opentimestamp\":1511958720},{\"expect\":\"2017325\",\"opencode\":\"5,0,9,0,8\",\"opentime\":\"2017-11-28 20:32:00\",\"opentimestamp\":1511872320},{\"expect\":\"2017324\",\"opencode\":\"8,2,8,5,8\",\"opentime\":\"2017-11-27 20:32:00\",\"opentimestamp\":1511785920},{\"expect\":\"2017323\",\"opencode\":\"5,7,2,3,6\",\"opentime\":\"2017-11-26 20:32:00\",\"opentimestamp\":1511699520},{\"expect\":\"2017322\",\"opencode\":\"1,7,3,8,3\",\"opentime\":\"2017-11-25 20:32:00\",\"opentimestamp\":1511613120},{\"expect\":\"2017321\",\"opencode\":\"4,3,5,0,2\",\"opentime\":\"2017-11-24 20:32:00\",\"opentimestamp\":1511526720},{\"expect\":\"2017320\",\"opencode\":\"0,3,6,3,7\",\"opentime\":\"2017-11-23 20:32:00\",\"opentimestamp\":1511440320},{\"expect\":\"2017319\",\"opencode\":\"9,3,9,5,4\",\"opentime\":\"2017-11-22 20:32:00\",\"opentimestamp\":1511353920}]");
        }else if (type == Constant.Lottery.QLC.ordinal()) {
            title.setText("七乐彩历史开奖信息");
            getData("[{\"expect\":\"2017143\",\"opencode\":\"03,07,09,16,19,27,28+14\",\"opentime\":\"2017-12-06 21:19:10\",\"opentimestamp\":1512566350},{\"expect\":\"2017142\",\"opencode\":\"03,11,12,14,18,24,28+13\",\"opentime\":\"2017-12-04 21:19:10\",\"opentimestamp\":1512393550},{\"expect\":\"2017141\",\"opencode\":\"02,04,10,12,17,23,28+24\",\"opentime\":\"2017-12-01 21:19:10\",\"opentimestamp\":1512134350},{\"expect\":\"2017140\",\"opencode\":\"01,13,20,23,25,26,28+18\",\"opentime\":\"2017-11-29 21:19:10\",\"opentimestamp\":1511961550},{\"expect\":\"2017139\",\"opencode\":\"01,03,05,06,12,13,30+27\",\"opentime\":\"2017-11-27 21:19:10\",\"opentimestamp\":1511788750},{\"expect\":\"2017138\",\"opencode\":\"02,03,04,06,08,09,18+12\",\"opentime\":\"2017-11-24 21:19:10\",\"opentimestamp\":1511529550},{\"expect\":\"2017137\",\"opencode\":\"01,13,15,16,24,25,29+19\",\"opentime\":\"2017-11-22 21:19:10\",\"opentimestamp\":1511356750},{\"expect\":\"2017136\",\"opencode\":\"07,09,11,18,19,21,27+25\",\"opentime\":\"2017-11-20 21:19:10\",\"opentimestamp\":1511183950},{\"expect\":\"2017135\",\"opencode\":\"06,08,19,20,21,25,27+23\",\"opentime\":\"2017-11-17 21:19:10\",\"opentimestamp\":1510924750},{\"expect\":\"2017134\",\"opencode\":\"01,02,04,07,10,16,27+06\",\"opentime\":\"2017-11-15 21:19:10\",\"opentimestamp\":1510751950},{\"expect\":\"2017133\",\"opencode\":\"01,07,11,12,26,27,29+09\",\"opentime\":\"2017-11-13 21:19:10\",\"opentimestamp\":1510579150},{\"expect\":\"2017132\",\"opencode\":\"02,08,16,17,20,23,25+11\",\"opentime\":\"2017-11-10 21:19:10\",\"opentimestamp\":1510319950},{\"expect\":\"2017131\",\"opencode\":\"05,06,07,09,12,17,19+14\",\"opentime\":\"2017-11-08 21:19:10\",\"opentimestamp\":1510147150},{\"expect\":\"2017130\",\"opencode\":\"03,09,19,22,23,27,30+12\",\"opentime\":\"2017-11-06 21:19:10\",\"opentimestamp\":1509974350},{\"expect\":\"2017129\",\"opencode\":\"01,05,08,15,22,23,30+24\",\"opentime\":\"2017-11-03 21:19:10\",\"opentimestamp\":1509715150}]");
        }else if (type == Constant.Lottery.QXC.ordinal()) {
            title.setText("七星彩历史开奖信息");
            getData("[{\"expect\":\"2017143\",\"opencode\":\"4,7,6,3,7,6,6\",\"opentime\":\"2017-12-05 20:31:40\",\"opentimestamp\":1512477100},{\"expect\":\"2017142\",\"opencode\":\"5,1,9,9,8,2,5\",\"opentime\":\"2017-12-03 20:31:40\",\"opentimestamp\":1512304300},{\"expect\":\"2017141\",\"opencode\":\"4,4,6,0,5,0,7\",\"opentime\":\"2017-12-01 20:31:40\",\"opentimestamp\":1512131500},{\"expect\":\"2017140\",\"opencode\":\"0,6,9,1,1,0,7\",\"opentime\":\"2017-11-28 20:31:40\",\"opentimestamp\":1511872300},{\"expect\":\"2017139\",\"opencode\":\"9,1,7,6,3,1,8\",\"opentime\":\"2017-11-26 20:31:40\",\"opentimestamp\":1511699500},{\"expect\":\"2017138\",\"opencode\":\"0,2,6,8,6,5,5\",\"opentime\":\"2017-11-24 20:31:40\",\"opentimestamp\":1511526700},{\"expect\":\"2017137\",\"opencode\":\"3,7,2,9,0,5,4\",\"opentime\":\"2017-11-21 20:31:40\",\"opentimestamp\":1511267500},{\"expect\":\"2017136\",\"opencode\":\"9,0,4,3,1,8,1\",\"opentime\":\"2017-11-19 20:31:40\",\"opentimestamp\":1511094700},{\"expect\":\"2017135\",\"opencode\":\"2,3,4,6,9,6,4\",\"opentime\":\"2017-11-17 20:31:40\",\"opentimestamp\":1510921900},{\"expect\":\"2017134\",\"opencode\":\"1,8,3,7,2,2,6\",\"opentime\":\"2017-11-14 20:31:40\",\"opentimestamp\":1510662700},{\"expect\":\"2017133\",\"opencode\":\"4,6,2,9,0,9,4\",\"opentime\":\"2017-11-12 20:31:40\",\"opentimestamp\":1510489900},{\"expect\":\"2017132\",\"opencode\":\"8,5,8,2,6,6,3\",\"opentime\":\"2017-11-10 20:31:40\",\"opentimestamp\":1510317100},{\"expect\":\"2017131\",\"opencode\":\"6,5,9,3,4,9,7\",\"opentime\":\"2017-11-07 20:31:40\",\"opentimestamp\":1510057900},{\"expect\":\"2017130\",\"opencode\":\"9,4,1,4,1,9,6\",\"opentime\":\"2017-11-05 20:31:40\",\"opentimestamp\":1509885100},{\"expect\":\"2017129\",\"opencode\":\"4,8,0,7,0,3,8\",\"opentime\":\"2017-11-03 20:31:40\",\"opentimestamp\":1509712300}]");
        }else if (type == Constant.Lottery.ZCBQC.ordinal()) {
            title.setText("六场半全场历史开奖信息");
            getData("[{\"expect\":\"2017182\",\"opencode\":\"0,3,1,0,3,3,1,3,1,1,3,3\",\"opentime\":\"2017-12-07 14:00:01\",\"opentimestamp\":1512626401},{\"expect\":\"2017181\",\"opencode\":\"3,3,0,1,3,3,1,0,1,3,3,3\",\"opentime\":\"2017-12-04 14:00:01\",\"opentimestamp\":1512367201},{\"expect\":\"2017180\",\"opencode\":\"0,0,1,3,3,3,3,3,1,1,0,0\",\"opentime\":\"2017-12-03 14:00:03\",\"opentimestamp\":1512280803},{\"expect\":\"2017179\",\"opencode\":\"1,3,3,3,3,3,1,0,1,1,0,0\",\"opentime\":\"2017-12-02 14:00:01\",\"opentimestamp\":1512194401},{\"expect\":\"2017178\",\"opencode\":\"0,0,3,3,1,3,3,3,1,3,0,0\",\"opentime\":\"2017-11-30 14:00:02\",\"opentimestamp\":1512021602},{\"expect\":\"2017177\",\"opencode\":\"1,1,3,3,0,0,3,1,1,3,3,3\",\"opentime\":\"2017-11-29 14:00:03\",\"opentimestamp\":1511935203},{\"expect\":\"2017176\",\"opencode\":\"1,1,1,1,0,0,3,1,1,3,1,1\",\"opentime\":\"2017-11-27 14:00:01\",\"opentimestamp\":1511762401},{\"expect\":\"2017175\",\"opencode\":\"1,3,1,3,0,0,1,1,0,1,1,1\",\"opentime\":\"2017-11-26 14:00:02\",\"opentimestamp\":1511676002},{\"expect\":\"2017174\",\"opencode\":\"1,0,3,1,3,3,3,3,3,3,3,3\",\"opentime\":\"2017-11-25 14:00:01\",\"opentimestamp\":1511589601},{\"expect\":\"2017173\",\"opencode\":\"1,0,1,3,0,3,1,1,3,3,0,0\",\"opentime\":\"2017-11-24 14:00:03\",\"opentimestamp\":1511503203},{\"expect\":\"2017172\",\"opencode\":\"1,3,0,0,0,0,3,0,1,3,1,1\",\"opentime\":\"2017-11-23 14:00:02\",\"opentimestamp\":1511416802},{\"expect\":\"2017171\",\"opencode\":\"1,1,3,1,1,3,1,0,1,0,1,3\",\"opentime\":\"2017-11-20 14:00:04\",\"opentimestamp\":1511157604},{\"expect\":\"2017170\",\"opencode\":\"3,3,3,3,1,1,0,0,3,3,0,0\",\"opentime\":\"2017-11-19 14:00:00\",\"opentimestamp\":1511071200},{\"expect\":\"2017169\",\"opencode\":\"3,1,3,1,1,0,1,3,1,3,1,3\",\"opentime\":\"2017-11-18 14:00:02\",\"opentimestamp\":1510984802},{\"expect\":\"2017168\",\"opencode\":\"1,1,0,0,1,0,3,3,1,3,1,1\",\"opentime\":\"2017-11-11 14:00:02\",\"opentimestamp\":1510380002}]");
        }else if (type == Constant.Lottery.ZCJQC.ordinal()) {
            title.setText("四场进球彩历史开奖信息");
            getData("[{\"expect\":\"2017182\",\"opencode\":\"2,1,3,1,1,1,3,2\",\"opentime\":\"2017-12-07 14:00:01\",\"opentimestamp\":1512626401},{\"expect\":\"2017181\",\"opencode\":\"3,0,1,1,3,0,1,2\",\"opentime\":\"2017-12-04 14:00:01\",\"opentimestamp\":1512367201},{\"expect\":\"2017180\",\"opencode\":\"1,3,1,0,1,1,1,3\",\"opentime\":\"2017-12-03 14:00:04\",\"opentimestamp\":1512280804},{\"expect\":\"2017179\",\"opencode\":\"2,1,1,0,3,0,1,3\",\"opentime\":\"2017-12-02 14:00:01\",\"opentimestamp\":1512194401},{\"expect\":\"2017178\",\"opencode\":\"3,0,1,0,3,0,2,1\",\"opentime\":\"2017-11-30 14:00:02\",\"opentimestamp\":1512021602},{\"expect\":\"2017177\",\"opencode\":\"0,0,2,1,2,3,2,2\",\"opentime\":\"2017-11-29 14:00:03\",\"opentimestamp\":1511935203},{\"expect\":\"2017176\",\"opencode\":\"0,0,1,1,0,1,3,0\",\"opentime\":\"2017-11-27 14:00:01\",\"opentimestamp\":1511762401},{\"expect\":\"2017175\",\"opencode\":\"1,0,0,3,1,1,1,1\",\"opentime\":\"2017-11-26 14:00:02\",\"opentimestamp\":1511676002},{\"expect\":\"2017174\",\"opencode\":\"0,1,1,1,2,1,3,0\",\"opentime\":\"2017-11-25 14:00:01\",\"opentimestamp\":1511589601},{\"expect\":\"2017173\",\"opencode\":\"2,3,1,0,3,2,1,3\",\"opentime\":\"2017-11-24 14:00:03\",\"opentimestamp\":1511503203},{\"expect\":\"2017172\",\"opencode\":\"0,3,1,2,2,0,0,0\",\"opentime\":\"2017-11-23 14:00:03\",\"opentimestamp\":1511416803},{\"expect\":\"2017171\",\"opencode\":\"1,1,3,2,0,1,2,0\",\"opentime\":\"2017-11-20 14:00:04\",\"opentimestamp\":1511157604},{\"expect\":\"2017170\",\"opencode\":\"2,2,0,2,3,0,0,3\",\"opentime\":\"2017-11-19 14:00:00\",\"opentimestamp\":1511071200},{\"expect\":\"2017169\",\"opencode\":\"1,1,2,2,1,3,1,0\",\"opentime\":\"2017-11-18 14:00:02\",\"opentimestamp\":1510984802},{\"expect\":\"2017168\",\"opencode\":\"0,1,3,1,1,0,0,0\",\"opentime\":\"2017-11-11 14:00:02\",\"opentimestamp\":1510380002}]");
        }else if (type == Constant.Lottery.DF6J1.ordinal()) {
            title.setText("七省东方6+1历史开奖信息");
            getData("[{\"expect\":\"2017142\",\"opencode\":\"8,8,4,9,3,6+龙\",\"opentime\":\"2017-12-04 21:00:00\",\"opentimestamp\":1512392400},{\"expect\":\"2017141\",\"opencode\":\"3,9,9,8,9,3+鸡\",\"opentime\":\"2017-12-02 21:00:00\",\"opentimestamp\":1512219600},{\"expect\":\"2017140\",\"opencode\":\"4,7,7,9,9,2+羊\",\"opentime\":\"2017-11-29 21:00:00\",\"opentimestamp\":1511960400},{\"expect\":\"2017139\",\"opencode\":\"2,3,9,5,9,7+兔\",\"opentime\":\"2017-11-27 21:00:00\",\"opentimestamp\":1511787600},{\"expect\":\"2017138\",\"opencode\":\"8,3,6,4,9,4+猪\",\"opentime\":\"2017-11-25 21:00:00\",\"opentimestamp\":1511614800},{\"expect\":\"2017137\",\"opencode\":\"5,5,1,6,6,8+鼠\",\"opentime\":\"2017-11-22 21:00:00\",\"opentimestamp\":1511355600},{\"expect\":\"2017136\",\"opencode\":\"6,0,2,7,6,8+牛\",\"opentime\":\"2017-11-20 21:00:00\",\"opentimestamp\":1511182800},{\"expect\":\"2017135\",\"opencode\":\"6,4,1,8,1,2+狗\",\"opentime\":\"2017-11-18 21:00:00\",\"opentimestamp\":1511010000},{\"expect\":\"2017134\",\"opencode\":\"1,1,4,4,4,7+狗\",\"opentime\":\"2017-11-15 21:00:00\",\"opentimestamp\":1510750800},{\"expect\":\"2017133\",\"opencode\":\"4,5,3,3,2,0+猪\",\"opentime\":\"2017-11-13 21:00:00\",\"opentimestamp\":1510578000},{\"expect\":\"2017132\",\"opencode\":\"0,2,0,6,7,5+虎\",\"opentime\":\"2017-11-11 21:00:00\",\"opentimestamp\":1510405200},{\"expect\":\"2017131\",\"opencode\":\"6,1,9,9,9,3+猴\",\"opentime\":\"2017-11-08 21:00:00\",\"opentimestamp\":1510146000},{\"expect\":\"2017130\",\"opencode\":\"4,6,5,3,6,7+鼠\",\"opentime\":\"2017-11-06 21:00:00\",\"opentimestamp\":1509973200},{\"expect\":\"2017129\",\"opencode\":\"8,4,2,2,5,5+猪\",\"opentime\":\"2017-11-04 21:00:00\",\"opentimestamp\":1509800400},{\"expect\":\"2017128\",\"opencode\":\"7,2,4,2,3,8+猴\",\"opentime\":\"2017-11-01 21:00:00\",\"opentimestamp\":1509541200}]");
        }else if (type == Constant.Lottery.FJTC22X5.ordinal()) {
            title.setText("福建体彩22选5历史开奖信息");
            getData("[{\"expect\":\"2017333\",\"opencode\":\"05,06,09,12,21\",\"opentime\":\"2017-12-06 20:00:00\",\"opentimestamp\":1512561600},{\"expect\":\"2017332\",\"opencode\":\"10,14,15,17,22\",\"opentime\":\"2017-12-05 20:00:00\",\"opentimestamp\":1512475200},{\"expect\":\"2017331\",\"opencode\":\"04,09,10,13,19\",\"opentime\":\"2017-12-04 20:00:00\",\"opentimestamp\":1512388800},{\"expect\":\"2017330\",\"opencode\":\"02,04,16,19,21\",\"opentime\":\"2017-12-03 20:00:00\",\"opentimestamp\":1512302400},{\"expect\":\"2017329\",\"opencode\":\"01,06,07,13,20\",\"opentime\":\"2017-12-02 20:00:00\",\"opentimestamp\":1512216000},{\"expect\":\"2017328\",\"opencode\":\"03,11,13,18,20\",\"opentime\":\"2017-12-01 20:00:00\",\"opentimestamp\":1512129600},{\"expect\":\"2017327\",\"opencode\":\"02,10,16,20,22\",\"opentime\":\"2017-11-30 20:00:00\",\"opentimestamp\":1512043200},{\"expect\":\"2017324\",\"opencode\":\"03,14,19,20,22\",\"opentime\":\"2017-11-27 20:00:00\",\"opentimestamp\":1511784000},{\"expect\":\"2017323\",\"opencode\":\"01,05,07,11,14\",\"opentime\":\"2017-11-26 20:00:00\",\"opentimestamp\":1511697600},{\"expect\":\"2017322\",\"opencode\":\"10,12,14,18,19\",\"opentime\":\"2017-11-25 20:00:00\",\"opentimestamp\":1511611200},{\"expect\":\"2017321\",\"opencode\":\"03,06,10,16,19\",\"opentime\":\"2017-11-24 20:00:00\",\"opentimestamp\":1511524800},{\"expect\":\"2017320\",\"opencode\":\"01,02,03,11,15\",\"opentime\":\"2017-11-23 20:00:00\",\"opentimestamp\":1511438400},{\"expect\":\"2017319\",\"opencode\":\"03,06,07,17,19\",\"opentime\":\"2017-11-22 20:00:00\",\"opentimestamp\":1511352000},{\"expect\":\"2017318\",\"opencode\":\"01,08,16,18,22\",\"opentime\":\"2017-11-21 20:00:00\",\"opentimestamp\":1511265600},{\"expect\":\"2017313\",\"opencode\":\"04,14,17,19,20\",\"opentime\":\"2017-11-16 20:00:00\",\"opentimestamp\":1510833600}]");
        }else if (type == Constant.Lottery.GDFC36X5.ordinal()) {
            title.setText("广东南粤风采36选7历史开奖信息");
            getData("[{\"expect\":\"2017333\",\"opencode\":\"02,07,11,15,21,29+24\",\"opentime\":\"2017-12-06 20:30:00\",\"opentimestamp\":1512563400},{\"expect\":\"2017331\",\"opencode\":\"01,06,08,10,13,15+23\",\"opentime\":\"2017-12-04 20:30:00\",\"opentimestamp\":1512390600},{\"expect\":\"2017329\",\"opencode\":\"05,08,15,19,21,25+10\",\"opentime\":\"2017-12-02 20:30:00\",\"opentimestamp\":1512217800},{\"expect\":\"2017328\",\"opencode\":\"02,05,11,12,20,30+36\",\"opentime\":\"2017-12-01 20:30:00\",\"opentimestamp\":1512131400},{\"expect\":\"2017327\",\"opencode\":\"05,14,21,23,32,36+02\",\"opentime\":\"2017-11-30 20:30:00\",\"opentimestamp\":1512045000},{\"expect\":\"2017326\",\"opencode\":\"12,16,28,29,30,31+09\",\"opentime\":\"2017-11-29 20:30:00\",\"opentimestamp\":1511958600},{\"expect\":\"2017325\",\"opencode\":\"11,12,21,25,30,35+17\",\"opentime\":\"2017-11-28 20:30:00\",\"opentimestamp\":1511872200},{\"expect\":\"2017324\",\"opencode\":\"03,07,08,22,23,33+01\",\"opentime\":\"2017-11-27 20:30:00\",\"opentimestamp\":1511785800},{\"expect\":\"2017323\",\"opencode\":\"11,13,16,17,24,33+36\",\"opentime\":\"2017-11-26 20:30:00\",\"opentimestamp\":1511699400},{\"expect\":\"2017322\",\"opencode\":\"06,08,19,26,29,36+07\",\"opentime\":\"2017-11-25 20:30:00\",\"opentimestamp\":1511613000},{\"expect\":\"2017321\",\"opencode\":\"01,13,17,25,26,31+05\",\"opentime\":\"2017-11-24 20:30:00\",\"opentimestamp\":1511526600},{\"expect\":\"2017320\",\"opencode\":\"13,17,22,28,30,32+25\",\"opentime\":\"2017-11-23 20:30:00\",\"opentimestamp\":1511440200},{\"expect\":\"2017319\",\"opencode\":\"06,13,23,24,29,35+14\",\"opentime\":\"2017-11-22 20:30:00\",\"opentimestamp\":1511353800},{\"expect\":\"2017318\",\"opencode\":\"03,11,12,16,24,34+04\",\"opentime\":\"2017-11-21 20:30:00\",\"opentimestamp\":1511267400},{\"expect\":\"2017313\",\"opencode\":\"02,05,19,25,30,32+33\",\"opentime\":\"2017-11-16 20:30:00\",\"opentimestamp\":1510835400}]");
        }
    }
    public void getData(String json){
        try {
            JSONArray jsonArray = new JSONArray(json);
            List<LotteryEntity> lotteryEntities = new ArrayList<>();
            if(jsonArray.length()>0){
                for(int i=0;i<jsonArray.length();i++){
                    LotteryEntity lotteryEntity = new LotteryEntity();
                    JSONObject job = jsonArray.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                    lotteryEntity.expect = job.getString("expect");
                    lotteryEntity.opencode = job.getString("opencode");
                    lotteryEntity.opentime = job.getString("opentime");
                    lotteryEntity.opentimestamp = job.getString("opentimestamp");
                    lotteryEntities.add(lotteryEntity);
                }
            }
            lotteryEntityList = lotteryEntities;
            ListView baselistview = (ListView) findViewById(R.id.base_listview);
            baselistview.setAdapter(new MyAdapter(LotteryDeatilsActivity.this));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final class ViewHolder{
        TextView lotteryTime;
        TextView lotteryCode;
        TextView lotteryCode_To;

    }

    public class MyAdapter extends BaseAdapter {
        private LayoutInflater mInflater;

        public MyAdapter(Context context){
            this.mInflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return lotteryEntityList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }
        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            ViewHolder viewHolder = null;
            if(viewHolder==null){
                viewHolder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.activity_lotter, null);
                viewHolder.lotteryTime = (TextView) convertView.findViewById(R.id.lottery_time_tv);
                viewHolder.lotteryCode = (TextView) convertView.findViewById(R.id.lottery_code_tv1);
                viewHolder.lotteryCode_To = (TextView) convertView.findViewById(R.id.lottery_code_tv2);
            }else{
                viewHolder = (ViewHolder) convertView.getTag();
            }
            LotteryEntity lotteryEntity = lotteryEntityList.get(i);
            viewHolder.lotteryTime.setText("第"+lotteryEntity.expect+"期    "+lotteryEntity.opentime);
            if(lotteryEntity.opencode.indexOf('+')==-1){
                viewHolder.lotteryCode_To.setText(lotteryEntity.opencode);
            }else{
                String code[] = lotteryEntity.opencode.split("[+]");
                viewHolder.lotteryCode.setText(code[0]);
                viewHolder.lotteryCode_To.setText(code[1]);
            }
            return convertView;
        }
    }
}
