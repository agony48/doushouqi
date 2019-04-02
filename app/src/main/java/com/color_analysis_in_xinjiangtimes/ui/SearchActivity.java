package com.color_analysis_in_xinjiangtimes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.module.Constant;

public class SearchActivity extends BaseActivity {
    EditText edit_tv;
    TextView search_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serach);
        edit_tv = (EditText) findViewById(R.id.edit_tv);
        search_tv = (TextView) findViewById(R.id.search_tv);
        search_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this, HomeMoreActivty.class);
                intent.putExtra(Constant.STRING_EXTRA, edit_tv.getText().toString());
                SearchActivity.this.startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void setContentLayout() {

    }
}
