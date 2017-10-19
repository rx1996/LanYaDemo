package com.kjplusapp.fragment.measuremen;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.kjplusapp.R;
import com.kjplusapp.common.BaseFragment;
import com.kjplusapp.common.MyTableTextView;

/**
 * Created by Administrator on 2017/10/16.
 */

public class UrineMeasuremenFragment extends BaseFragment {
    private LinearLayout mainLinerLayout;
    private LinearLayout mainLinerLayout1;
    private String[] name={"时间","尿蛋白","嘌呤","学红星","测量人"};
    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_urine_measuremen,null);
        mainLinerLayout = (LinearLayout) view.findViewById(R.id.My_Table);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        mainLinerLayout1 = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.measuremen_title,null);
        MyTableTextView title = (MyTableTextView) mainLinerLayout1.findViewById(R.id.time);
        title.setText(name[0]);
        MyTableTextView title1 = (MyTableTextView) mainLinerLayout1.findViewById(R.id.urine_protein);
        title1.setText(name[1]);
        MyTableTextView title2 = (MyTableTextView) mainLinerLayout1.findViewById(R.id.purine);
        title2.setText(name[2]);
        MyTableTextView title3 = (MyTableTextView) mainLinerLayout1.findViewById(R.id.red_star);
        title3.setText(name[3]);
        MyTableTextView title4 = (MyTableTextView) mainLinerLayout1.findViewById(R.id.measuremen_person);
        title4.setText(name[4]);
        mainLinerLayout.addView(mainLinerLayout1);

        mainLinerLayout1 = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.measuremen_table,null);
        MyTableTextView txt = (MyTableTextView) mainLinerLayout1.findViewById(R.id.time);
        txt.setText("20171016 09:13");
        MyTableTextView txt1 = (MyTableTextView) mainLinerLayout1.findViewById(R.id.urine_protein);
        txt1.setText("4");
        MyTableTextView txt2 = (MyTableTextView) mainLinerLayout1.findViewById(R.id.purine);
        txt2.setText("6.2");
        MyTableTextView txt3 = (MyTableTextView) mainLinerLayout1.findViewById(R.id.red_star);
        txt3.setText("6");
        MyTableTextView txt4 = (MyTableTextView) mainLinerLayout1.findViewById(R.id.measuremen_person);
        txt4.setText("张三");
        mainLinerLayout.addView(mainLinerLayout1);
    }
}
