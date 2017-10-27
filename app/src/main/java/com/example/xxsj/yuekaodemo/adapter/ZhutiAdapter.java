package com.example.xxsj.yuekaodemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xxsj.yuekaodemo.R;
import com.example.xxsj.yuekaodemo.XiangqingActivity;
import com.example.xxsj.yuekaodemo.bean.ZhutiBean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class ZhutiAdapter extends RecyclerView.Adapter<ZhutiAdapter.MyViewHolder> {
    private Context context;
    private List<ZhutiBean.OthersBean> list;
    private DisplayImageOptions options;

    public ZhutiAdapter(FragmentActivity activity, List<ZhutiBean.OthersBean> list) {
        this.context = activity;
        this.list = list;
        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//让图片进行内存缓存
                .cacheOnDisk(true)//让图片进行sdcard缓存
                .showImageOnLoading(R.mipmap.ic_launcher)//图片正在加载的时候显示的图片
                .build();
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.zhuti_item, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txt_zhu.setText(list.get(position).getName());

        ImageLoader.getInstance().displayImage(list.get(position).getThumbnail(), holder.ima_zhu, options);
        holder.ima_zhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, XiangqingActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        private final ImageView ima_zhu;
        private final TextView txt_zhu;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            txt_zhu = (TextView) itemView.findViewById(R.id.txt_zhu);
            ima_zhu = (ImageView) itemView.findViewById(R.id.img_zhu);
        }
    }
}
