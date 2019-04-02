package com.color_analysis_in_xinjiangtimes.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.module.Constant;
import com.color_analysis_in_xinjiangtimes.module.news.NewDatas;
import com.color_analysis_in_xinjiangtimes.ui.WebActivity1;
import com.color_analysis_in_xinjiangtimes.utils.GlideUtils;

import java.util.List;

/**
 * author 万强
 * date 16/5/17 上午9:55
 * desc ${TODO}
 */
public class OneNavigationAdapter extends RecyclerView.Adapter<OneNavigationAdapter.MyViewHolder> {

    private Activity context;
    private List<NewDatas> contentlist;
    public OneNavigationAdapter(Activity context,List<NewDatas> contentlist) {
        this.context = context;
        this.contentlist = contentlist;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.one_item, parent,
                false));
        return holder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final NewDatas newDatas = contentlist.get(position);
        holder.one_title_tv.setText(newDatas.title);
        holder.one_desc_tv.setText(newDatas.desc);
        if(newDatas.imageurls.size()!=0){
        GlideUtils.loadImage(context,newDatas.imageurls.get(0).url,holder.one_img);
        }
        holder.contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebActivity1.class);
                intent.putExtra(Constant.STRING_EXTRA2,newDatas.title);
                intent.putExtra(Constant.STRING_EXTRA,newDatas.html);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contentlist == null ? 0 : contentlist.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView one_desc_tv;
        TextView one_title_tv;
        ImageView one_img;
        View contentView;
        public MyViewHolder(View view) {
            super(view);
            contentView = view.findViewById(R.id.content_lt);
            one_desc_tv = (TextView) view.findViewById(R.id.one_desc_tv);
            one_title_tv = (TextView) view.findViewById(R.id.one_title_tv);
            one_img = (ImageView) view.findViewById(R.id.one_img);
        }
    }


}
