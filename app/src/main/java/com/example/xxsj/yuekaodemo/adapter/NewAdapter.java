package com.example.xxsj.yuekaodemo.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xxsj.yuekaodemo.R;
import com.example.xxsj.yuekaodemo.bean.NewnewsBean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by xxsj on 2017/9/26.
 */

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.MyViewHolder>{

    private Context context;
    private List<NewnewsBean.StoriesBean> list;
    private final DisplayImageOptions options;

    public NewAdapter(FragmentActivity activity, List<NewnewsBean.StoriesBean> list) {
        this.context = activity;
        this.list = list;

        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//让图片进行内存缓存
                .cacheOnDisk(true)//让图片进行sdcard缓存
                .showImageOnLoading(R.mipmap.ic_launcher)//图片正在加载的时候显示的图片
                .displayer(new CircleBitmapDisplayer())//圆形图片
                .build();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_item, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txt_new.setText(list.get(position).getTitle());
        List<String> images = list.get(position).getImages();
        String s = images.get(0);
        ImageLoader.getInstance().displayImage(s, holder.img_new, options);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        private final TextView txt_new;
        private final ImageView img_new;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            txt_new = (TextView) itemView.findViewById(R.id.txt_new);
            img_new = (ImageView) itemView.findViewById(R.id.img_new);
        }
    }
}
