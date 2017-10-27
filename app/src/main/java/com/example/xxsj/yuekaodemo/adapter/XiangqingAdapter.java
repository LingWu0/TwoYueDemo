package com.example.xxsj.yuekaodemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xxsj.yuekaodemo.R;
import com.example.xxsj.yuekaodemo.bean.XiangqingBean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by xxsj on 2017/9/27.
 */

public class XiangqingAdapter extends RecyclerView.Adapter<XiangqingAdapter.MyViewHolder> {

    private List<XiangqingBean.StoriesBean> list;
    private DisplayImageOptions options;

    public XiangqingAdapter(List<XiangqingBean.StoriesBean> list) {
        this.list = list;
        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//让图片进行内存缓存
                .cacheOnDisk(true)//让图片进行sdcard缓存
                .showImageOnLoading(R.mipmap.ic_launcher)//图片正在加载的时候显示的图片
                .displayer(new CircleBitmapDisplayer())
                .build();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.xiangqing_item, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txtxiangqing.setText(list.get(position).getTitle());
        List<String> images = list.get(position).getImages();
        String s = images.get(0);
        ImageLoader.getInstance().displayImage(s, holder.imgxiangqing, options);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        private final ImageView imgxiangqing;
        private final TextView txtxiangqing;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            txtxiangqing = (TextView) itemView.findViewById(R.id.txt_xiangqing);
            imgxiangqing = (ImageView) itemView.findViewById(R.id.img_xiangqing);
        }
    }
}
