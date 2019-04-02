package com.color_analysis_in_xinjiangtimes.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.module.Constant;
import com.color_analysis_in_xinjiangtimes.module.LotterDetailsEntity;
import com.color_analysis_in_xinjiangtimes.ui.WebActivity1;

import java.util.List;

/**
 * Created by Administrator on 2017/12/7.
 */

public class LotterZxAdapter extends BaseAdapter {
    private Activity mContext;
    private LayoutInflater mInflater;
    private List<LotterDetailsEntity> lotter;
    public LotterZxAdapter(Activity activity,List<LotterDetailsEntity> lotterDetailsEntityListView){
        mContext = activity;
        this.mInflater = LayoutInflater.from(activity);
        this.lotter = lotterDetailsEntityListView;
    }
    @Override
    public int getCount() {
        return lotter.size();
    }
    @Override
    public LotterDetailsEntity getItem(int i) {
        return getItem(i);
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(viewHolder==null){
            viewHolder = new ViewHolder();
            view = mInflater.inflate(R.layout.activity_lotter_raw, null);
            viewHolder.lotteryData = (TextView) view.findViewById(R.id.lottery_name_tv);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        final LotterDetailsEntity detailsEntity =lotter.get(i);
        viewHolder.lotteryData.setText(detailsEntity.name);
        viewHolder.lotteryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, WebActivity1.class);
                intent.putExtra(Constant.TYPE,Constant.WebType.BANNER.ordinal());
                intent.putExtra(Constant.STRING_EXTRA,detailsEntity.url);
                mContext.startActivity(intent);
            }
        });
        return view;
    }

    public final class ViewHolder{
        TextView lotteryData;
    }
}
