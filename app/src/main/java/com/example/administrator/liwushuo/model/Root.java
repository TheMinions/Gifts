package com.example.administrator.liwushuo.model;

import java.util.List;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public class Root {

    /**
     * code : 200
     * data : {"daily_lucky":["http://img02.liwushuo.com/image/160517/6mdg1h4lc.jpg-w720","http://img02.liwushuo.com/image/160513/pz3dmel2b_w.jpg-w720","http://img03.liwushuo.com/image/160513/82aq4bal2.jpg-w720","http://img01.liwushuo.com/image/160513/w2jx5l2nb_w.jpg-w720"],"daily_lucky_webp":["http://img02.liwushuo.com/image/160517/6mdg1h4lc.jpg?imageView2/2/w/720/q/85/format/webp","http://img02.liwushuo.com/image/160513/pz3dmel2b_w.jpg?imageView2/2/w/720/q/85/format/webp","http://img03.liwushuo.com/image/160513/82aq4bal2.jpg?imageView2/2/w/720/q/85/format/webp","http://img01.liwushuo.com/image/160513/w2jx5l2nb_w.jpg?imageView2/2/w/720/q/85/format/webp"]}
     * message : OK
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        private List<String> daily_lucky;
        private List<String> daily_lucky_webp;

        public List<String> getDaily_lucky() {
            return daily_lucky;
        }

        public void setDaily_lucky(List<String> daily_lucky) {
            this.daily_lucky = daily_lucky;
        }

        public List<String> getDaily_lucky_webp() {
            return daily_lucky_webp;
        }

        public void setDaily_lucky_webp(List<String> daily_lucky_webp) {
            this.daily_lucky_webp = daily_lucky_webp;
        }
    }
}
