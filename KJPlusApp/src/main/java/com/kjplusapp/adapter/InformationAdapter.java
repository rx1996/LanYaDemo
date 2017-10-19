package com.kjplusapp.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kjplusapp.R;
import com.kjplusapp.activity.SignActivity;
import com.kjplusapp.bean.InformationBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/10/13.
 */

public class InformationAdapter extends BaseAdapter {
    private final SignActivity content;
    private final List<InformationBean.DataBean> datas;

    public InformationAdapter(SignActivity content, List<InformationBean.DataBean> datas) {
        this.content = content;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(content, R.layout.item_information, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        InformationBean.DataBean bean = datas.get(position);
        viewHolder.tvName.setText(bean.getPersonName());
        viewHolder.tvDoctor.setText("审核中"+bean.getStafName()+"医生");
//        viewHolder.tvBuMen.setText(bean.getDeptName());
        viewHolder.tvNumber.setText(bean.getPersonMobile());
//        viewHolder.tvPingTai.setText(bean.getOrgName());
//        viewHolder.tvShenFen.setText(bean.getStafType());
        return convertView;
    }


    class ViewHolder {
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_number)
        TextView tvNumber;
        @Bind(R.id.tv_doctor)
        TextView tvDoctor;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
