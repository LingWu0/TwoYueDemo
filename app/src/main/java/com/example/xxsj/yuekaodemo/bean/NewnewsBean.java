package com.example.xxsj.yuekaodemo.bean;

import java.util.List;

/**
 * Created by xxsj on 2017/9/26.
 */

public class NewnewsBean {


    /**
     * date : 20170926
     * stories : [{"images":["https://pic2.zhimg.com/v2-2818944a0cbeb264b94a072d716d44d9.jpg"],"type":0,"id":9630795,"ga_prefix":"092610","title":"为什么要「脱裤子放屁」？一不小心可能就得多赔 35 亿美元"},{"images":["https://pic1.zhimg.com/v2-1453248d69fdd6e1336c0a679538c010.jpg"],"type":0,"id":9626002,"ga_prefix":"092609","title":"你骑着共享单车经过的轨迹，都被我们用来做城市规划了"},{"images":["https://pic2.zhimg.com/v2-8d164b361ef6a631e6bdfd3db429b359.jpg"],"type":0,"id":9627387,"ga_prefix":"092608","title":"《星球大战》看过一百多遍，却没想过为什么都叫它星「球」"},{"images":["https://pic1.zhimg.com/v2-9cb623ac9091ffd20d84d44f370dc974.jpg"],"type":0,"id":9631247,"ga_prefix":"092607","title":"钱包到月末又快瘪了，感觉花钱的方式越来越刺激和意想不到"},{"images":["https://pic2.zhimg.com/v2-229ef8a429fa6081c69b88130280cbfd.jpg"],"type":0,"id":9631230,"ga_prefix":"092607","title":"「我已经没有了成长的能力」，这是一家 AI 创业公司的离场告白"},{"images":["https://pic4.zhimg.com/v2-1785330ca9740f02c077d995c197eb4f.jpg"],"type":0,"id":9631365,"ga_prefix":"092607","title":"消费贷的「原罪」：有人拆东墙补西墙，有人薅羊毛反被割韭菜"},{"images":["https://pic2.zhimg.com/v2-4821873eb7e45c070c0d14a135c8599d.jpg"],"type":0,"id":9631117,"ga_prefix":"092606","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic4.zhimg.com/v2-7f8939f40ed72ae81c60f8a73a0eed8b.jpg","type":0,"id":9626002,"ga_prefix":"092609","title":"你骑着共享单车经过的轨迹，都被我们用来做城市规划了"},{"image":"https://pic1.zhimg.com/v2-3871865883943494572f946051e06968.jpg","type":0,"id":9631365,"ga_prefix":"092607","title":"消费贷的「原罪」：有人拆东墙补西墙，有人薅羊毛反被割韭菜"},{"image":"https://pic1.zhimg.com/v2-049481169f4c12178b2dbe86894c33f0.jpg","type":0,"id":9631230,"ga_prefix":"092607","title":"「我已经没有了成长的能力」，这是一家 AI 创业公司的离场告白"},{"image":"https://pic2.zhimg.com/v2-8764cc4b26d2644bf2c6558707f669a9.jpg","type":0,"id":9631626,"ga_prefix":"092518","title":"6 年来腾讯首次更换启动图，这背后是一张纯正的「中华牌」"},{"image":"https://pic3.zhimg.com/v2-cc509d11e20028007de48dc5b4fd426e.jpg","type":0,"id":9631048,"ga_prefix":"092517","title":"辉煌中国 · 肯尼亚独立后的首条铁路，是中国修建的"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic2.zhimg.com/v2-2818944a0cbeb264b94a072d716d44d9.jpg"]
         * type : 0
         * id : 9630795
         * ga_prefix : 092610
         * title : 为什么要「脱裤子放屁」？一不小心可能就得多赔 35 亿美元
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic4.zhimg.com/v2-7f8939f40ed72ae81c60f8a73a0eed8b.jpg
         * type : 0
         * id : 9626002
         * ga_prefix : 092609
         * title : 你骑着共享单车经过的轨迹，都被我们用来做城市规划了
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
