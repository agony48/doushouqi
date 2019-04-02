package com.color_analysis_in_xinjiangtimes.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.module.Constant;
import com.color_analysis_in_xinjiangtimes.ui.HomeMoreActivty;

/**
 * author 万强
 * date 16/5/17 上午9:55
 * desc ${TODO}
 */
public class Home2NavigationAdapter extends RecyclerView.Adapter<Home2NavigationAdapter.MyViewHolder> {

    private Context context;
    private String[] titles;

    private int[] headers = new int[]{
            R.mipmap.classly_1,
            R.mipmap.classly_2,
            R.mipmap.classly_3,
            R.mipmap.classly_4,
            R.mipmap.classly_5,
    };
    public Home2NavigationAdapter(Context context) {
        this.context = context;
        titles = context.getResources().getStringArray(R.array.home_navi_array);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.home_navi_item_layout, parent,
                false));
        return holder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.nameView.setText(titles[position]);
        holder.headerView.setImageResource(headers[position]);
        holder.contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HomeMoreActivty.class);
                intent.putExtra(Constant.STRING_EXTRA, titles[position]);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return titles == null ? 0 : titles.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nameView;
        ImageView headerView;
        View contentView;

        public MyViewHolder(View view) {
            super(view);
            contentView = view.findViewById(R.id.content_lt);
            nameView = (TextView) view.findViewById(R.id.home_navi_name_tv);
            headerView = (ImageView) view.findViewById(R.id.home_navi_header_iv);
        }
    }


}
