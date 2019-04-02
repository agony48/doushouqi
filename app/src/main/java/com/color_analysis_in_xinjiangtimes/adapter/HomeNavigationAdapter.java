package com.color_analysis_in_xinjiangtimes.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.module.Constant;
import com.color_analysis_in_xinjiangtimes.ui.WebActivity3;

/**
 * author 万强
 * date 16/5/17 上午9:55
 * desc ${TODO}
 */
public class HomeNavigationAdapter extends RecyclerView.Adapter<HomeNavigationAdapter.MyViewHolder> {

    private Context context;
    private String[] titles;

    private int[] headers = new int[]{
            R.mipmap.ssq,
            R.mipmap.dlt,
            R.mipmap.qlc,
            R.mipmap.qxc,
            R.mipmap.dj,
            R.mipmap.ssc,
            R.mipmap.xks,
            R.mipmap.klpk,
    };
    public HomeNavigationAdapter(Context context) {
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
                Intent intent = null;
                switch (position) {
                    case 0://
                        intent = new Intent(context, WebActivity3.class);
                        intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/bet/ssq.do?&agentId=1&vt=5");
                        intent.putExtra(Constant.MESSAGE_EXTRA, "双色球");
                        break;
                    case 1://
                        intent = new Intent(context, WebActivity3.class);
                        intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/bet/dlt.do?&agentId=1&vt=5");
                        intent.putExtra(Constant.MESSAGE_EXTRA, "大乐透");
                        break;
                    case 2:
                    case 3:

                        AlertDialog.Builder builder = new AlertDialog.Builder(
                                context);
                        builder.setTitle("提示");
                        builder.setMessage("应主管部门要求，当前各彩票网站均暂停售彩，已售出彩票兑奖不受影响。购买彩票建议您查询附近的实体网点。就此给您带来的不便，敬请谅解！");
                        builder.setCancelable(false);
                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.create().show();
//                        break;
//                    case 3:
                        break;
                    case 4:
                        intent = new Intent(context, WebActivity3.class);
                        intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/bet/sd11x5.do?agentId=1&vt=5");
                        intent.putExtra(Constant.MESSAGE_EXTRA, "11运夺金");
                        break;
                    case 5:
                        intent = new Intent(context, WebActivity3.class);
                        intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/bet/cqssc.do?agentId=1&vt=5");
                        intent.putExtra(Constant.MESSAGE_EXTRA, "时时彩");
                        break;
                    case 6:
                        intent = new Intent(context, WebActivity3.class);
                        intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/bet/k3.do?agentId=1&vt=5");
                        intent.putExtra(Constant.MESSAGE_EXTRA, "新快3");
                        break;
                    case 7:
                        intent = new Intent(context, WebActivity3.class);
                        intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/bet/klpk.do?agentId=1&vt=5");
                        intent.putExtra(Constant.MESSAGE_EXTRA, "快了扑克3");
                        break;
                }
                if (intent != null) {
                    context.startActivity(intent);
                }
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
