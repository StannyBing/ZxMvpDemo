package com.stanny.zxmvpdemo.bean;

import java.util.List;

/**
 * Created by Xiangb on 2017/10/18.
 * 功能：
 */

public class CodeSorceEntity {


    /**
     * error : false
     * results : [{"_id":"59de2f22421aa90fe50c015c","createdAt":"2017-10-11T22:48:02.721Z","desc":"用 Kotlin 实现的基于物理的动画","images":["http://img.gank.io/58925abb-3e11-4d6e-9e44-a4567c03d03f"],"publishedAt":"2017-10-17T13:10:43.731Z","source":"web","type":"Android","url":"https://github.com/sagar-viradiya/AndroidPhysicsAnimation","used":true,"who":" Thunder Bouble"},{"_id":"59e46c6a421aa90fe50c0174","createdAt":"2017-10-16T16:23:06.637Z","desc":"Android 通用圆角布局，快速实现圆角需求。","images":["http://img.gank.io/4d9b99ba-cc97-4ef8-b834-477ad8a97100"],"publishedAt":"2017-10-17T13:10:43.731Z","source":"web","type":"Android","url":"https://github.com/GcsSloop/rclayout","used":true,"who":"sloop"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 59de2f22421aa90fe50c015c
         * createdAt : 2017-10-11T22:48:02.721Z
         * desc : 用 Kotlin 实现的基于物理的动画
         * images : ["http://img.gank.io/58925abb-3e11-4d6e-9e44-a4567c03d03f"]
         * publishedAt : 2017-10-17T13:10:43.731Z
         * source : web
         * type : Android
         * url : https://github.com/sagar-viradiya/AndroidPhysicsAnimation
         * used : true
         * who :  Thunder Bouble
         */
        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
