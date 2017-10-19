package com.kjplusapp.fragment.information;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.kjplusapp.R;
import com.kjplusapp.common.BaseFragment;
import com.kjplusapp.common.MyTableTextView;

/**
 * Created by Administrator on 2017/10/10.
 */

public class TijianFragment extends BaseFragment {
    private LinearLayout mainLinerLayout;
    private LinearLayout mainLinerLayout1;
    private String[] name={"时间","体检种类","医生","操作"};
    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_tijian, null);
        mainLinerLayout = (LinearLayout) view.findViewById(R.id.MyTable);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        mainLinerLayout1 = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.table_title,null);
        MyTableTextView title = (MyTableTextView) mainLinerLayout1.findViewById(R.id.time);
        title.setText(name[0]);
        MyTableTextView title1 = (MyTableTextView) mainLinerLayout1.findViewById(R.id.type);
        title1.setText(name[1]);
        MyTableTextView title2 = (MyTableTextView) mainLinerLayout1.findViewById(R.id.doctor);
        title2.setText(name[2]);
        MyTableTextView title3 = (MyTableTextView) mainLinerLayout1.findViewById(R.id.operation);
        title3.setText(name[3]);
        mainLinerLayout.addView(mainLinerLayout1);

        mainLinerLayout1 = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.table,null);
        MyTableTextView txt = (MyTableTextView) mainLinerLayout1.findViewById(R.id.time);
        txt.setText("20171016 09:13");
        MyTableTextView txt1 = (MyTableTextView) mainLinerLayout1.findViewById(R.id.type);
        txt1.setText("老年人");
        MyTableTextView txt2 = (MyTableTextView) mainLinerLayout1.findViewById(R.id.doctor);
        txt2.setText("张三");
        MyTableTextView txt3 = (MyTableTextView) mainLinerLayout1.findViewById(R.id.operation);
        txt3.setText("详情");
        mainLinerLayout.addView(mainLinerLayout1);
    }
}
