package com.color_analysis_in_xinjiangtimes.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.ui.AboutActivity;
import com.color_analysis_in_xinjiangtimes.ui.BaseFragment;
import com.color_analysis_in_xinjiangtimes.view.CheckerboardView;
import com.color_analysis_in_xinjiangtimes.view.ChessBoardBridge;

/**
 * author lishan
 * date 2016-08-30 14:12:56
 * desc 我的
 */
public class MeFragmentcopy extends BaseFragment implements ChessBoardBridge {
    private TextView mTvTurns;
    private CheckerboardView mChessBoard;
    public static MeFragmentcopy newInstance() {
        MeFragmentcopy fragment = new MeFragmentcopy();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tiyan, container, false);
        mTvTurns = (TextView) view.findViewById(R.id.tv_turns);
        mChessBoard = (CheckerboardView) view.findViewById(R.id.checkerboard);
        mChessBoard.addChessBoardBridge(this);
        return view;
    }

    @Override
    public void updateTurns(boolean isBlueTurns) {
        if (isBlueTurns) {
            mTvTurns.setText("蓝色方回合");
            mTvTurns.setBackgroundResource(android.R.color.holo_blue_light);
        } else {
            mTvTurns.setText("红色方回合");
            mTvTurns.setBackgroundResource(android.R.color.holo_red_light);
        }
    }
}
