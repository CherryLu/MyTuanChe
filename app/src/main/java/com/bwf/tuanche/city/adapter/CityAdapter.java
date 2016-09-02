package com.bwf.tuanche.city.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.tuanche.R;
import com.bwf.tuanche.city.bean.CityBean;

import java.util.List;

/**
 * Created by BWF on 2016/8/31.
 */
public class CityAdapter extends BaseAdapter {
    private Context context;
    private List<CityBean> openCitys;


    public CityAdapter(Context context, List<CityBean> openCitys) {
        this.context = context;
        this.openCitys = openCitys;
    }

    @Override
    public int getCount() {
        return openCitys==null?0:openCitys.size();
    }

    @Override
    public Object getItem(int i) {
        return openCitys==null?null:openCitys.size();
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view==null){
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.cityitem,null);
            holder.item_py = (TextView) view.findViewById(R.id.item_py);
            holder.item_name = (TextView) view.findViewById(R.id.item_name);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        String last_py = "";
        String cru_py = "";
        if (i>=1){
            last_py = openCitys.get(i-1).pinyin.substring(0,1).toUpperCase();
            cru_py = openCitys.get(i).pinyin.substring(0,1);
            if (cru_py.equals(last_py)){
                holder.item_py.setVisibility(View.GONE);
            }else {
                last_py = cru_py;
                holder.item_py.setVisibility(View.VISIBLE);
            }
        }else {
            last_py = openCitys.get(i).pinyin.substring(0, 1).toUpperCase();
            holder.item_py.setVisibility(View.VISIBLE);
        }

        holder.item_py.setText(last_py);
        holder.item_name.setText(openCitys.get(i).name);

        return view;
    }

    public class ViewHolder{
        public TextView item_py;
        public TextView item_name;
    }
}
