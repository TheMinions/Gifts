package com.example.administrator.liwushuo.model.classifymodel;

import java.util.List;

/**
 * Created by liuhui on 2016/9/21.
 */
public class SeekList {


    /**
     * code : 200
     * data : {"hot_words":["钢笔","情侣","手机壳","双肩包","手表","杯子","钱包","宿舍","项链","手链","水杯","耳机"],"placeholder":"选份走心好礼送给Ta"}
     * message : OK
     */

    private int code;
    /**
     * hot_words : ["钢笔","情侣","手机壳","双肩包","手表","杯子","钱包","宿舍","项链","手链","水杯","耳机"]
     * placeholder : 选份走心好礼送给Ta
     */

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
        private String placeholder;
        private List<String> hot_words;

        public String getPlaceholder() {
            return placeholder;
        }

        public void setPlaceholder(String placeholder) {
            this.placeholder = placeholder;
        }

        public List<String> getHot_words() {
            return hot_words;
        }

        public void setHot_words(List<String> hot_words) {
            this.hot_words = hot_words;
        }
    }
}
