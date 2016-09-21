package com.example.administrator.liwushuo.model.classifymodel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhui on 2016/9/21.
 */
public class StrtegyEndList {
    /**
     * code : 200
     * data : {"channel_groups":[{"channels":[{"cover_image_url":"http://img02.liwushuo.com/image/160624/hbd7w1sf4.png","group_id":5,"icon_url":"http://img02.liwushuo.com/image/160414/kwzqtscoa.png-pw144","id":111,"items_count":1165,"name":"礼物","order":10,"status":0,"url":""},{"cover_image_url":"http://img01.liwushuo.com/image/160624/duk8guejk.png","group_id":5,"icon_url":"http://img01.liwushuo.com/image/160401/58kdnthsn.png-pw144","id":112,"items_count":597,"name":"家居","order":9,"status":0,"url":""},{"cover_image_url":"http://img03.liwushuo.com/image/160624/axk8i901f.png","group_id":5,"icon_url":"http://img01.liwushuo.com/image/160414/6eutomjeo.png-pw144","id":110,"items_count":707,"name":"穿搭","order":8,"status":0,"url":""},{"cover_image_url":"http://img01.liwushuo.com/image/160624/ayjeuhtji.png","group_id":5,"icon_url":"http://img01.liwushuo.com/image/160414/abuv6vssc.png-pw144","id":2,"items_count":568,"name":"美物","order":7,"status":0,"url":""},{"cover_image_url":"http://img01.liwushuo.com/image/160624/x5vlfqcn4.png","group_id":5,"icon_url":"http://img03.liwushuo.com/image/160401/5al9xhwg1.png-pw144","id":116,"items_count":196,"name":"饰品","order":6,"status":0,"url":""},{"cover_image_url":"http://img01.liwushuo.com/image/160624/otqmww3av.png","group_id":5,"icon_url":"http://img02.liwushuo.com/image/160401/5dgflkj6g.png-pw144","id":117,"items_count":198,"name":"鞋包","order":5,"status":0,"url":""},{"cover_image_url":"http://img03.liwushuo.com/image/160624/1kx5seb62.png","group_id":5,"icon_url":"http://img01.liwushuo.com/image/160401/58vv7n29y.png-pw144","id":118,"items_count":500,"name":"美食","order":5,"status":0,"url":""},{"cover_image_url":"http://img02.liwushuo.com/image/160624/38778o4e0.png","group_id":5,"icon_url":"http://img02.liwushuo.com/image/160401/fb7e1012t.png-pw144","id":113,"items_count":531,"name":"美护","order":4,"status":0,"url":""},{"cover_image_url":"http://img01.liwushuo.com/image/160624/s69ub7yiq.png","group_id":5,"icon_url":"http://img01.liwushuo.com/image/160401/59hgqd1x8.png-pw144","id":121,"items_count":215,"name":"数码","order":4,"status":0,"url":""},{"cover_image_url":"http://img02.liwushuo.com/image/160624/2ky6x596q.png","group_id":5,"icon_url":"http://img01.liwushuo.com/image/160401/u4r2a9q72.png-pw144","id":3,"items_count":89,"name":"手工","order":3,"status":0,"url":""},{"cover_image_url":"http://img03.liwushuo.com/image/160624/d1xtmp1ig.png","group_id":5,"icon_url":"http://img02.liwushuo.com/image/160401/i69bjp6bm.png-pw144","id":119,"items_count":51,"name":"母婴","order":0,"status":0,"url":""},{"cover_image_url":"http://img02.liwushuo.com/image/160624/y3aqzhu9v.png","group_id":5,"icon_url":"http://img01.liwushuo.com/image/160401/t9t9hzntc.png-pw144","id":122,"items_count":66,"name":"爱动漫","order":0,"status":0,"url":""},{"cover_image_url":"http://img02.liwushuo.com/image/160624/ym66pnx98.png","group_id":5,"icon_url":"http://img02.liwushuo.com/image/160401/3ziqypz1f.png-pw144","id":123,"items_count":31,"name":"爱运动","order":0,"status":0,"url":""},{"cover_image_url":"http://img01.liwushuo.com/image/160606/ad06sqrix.png","group_id":5,"icon_url":"http://img01.liwushuo.com/image/160401/6pdxbaqz2.png-pw144","id":124,"items_count":22,"name":"爱读书","order":0,"status":0,"url":""},{"cover_image_url":"http://img01.liwushuo.com/image/160624/xxvb0a8aj.png","group_id":5,"icon_url":"http://img01.liwushuo.com/image/160401/voku467wc.png-pw144","id":129,"items_count":165,"name":"海淘","order":0,"status":0,"url":""}],"id":5,"name":"品类","order":6,"status":0},{"channels":[{"cover_image_url":"http://img01.liwushuo.com/image/160630/l3222e4cx.png","group_id":1,"icon_url":"http://img01.liwushuo.com/image/160401/y6s6hso8w.png-pw144","id":125,"items_count":99,"name":"创意生活","order":5,"status":0,"url":""},{"cover_image_url":"http://img02.liwushuo.com/image/160630/3b91gmqd9.png","group_id":1,"icon_url":"http://img01.liwushuo.com/image/160401/vx9i89n0s.png-pw144","id":11,"items_count":191,"name":"萌萌哒","order":4,"status":0,"url":""},{"cover_image_url":"http://img01.liwushuo.com/image/160630/0vgsog6tm.png","group_id":1,"icon_url":"http://img02.liwushuo.com/image/160401/i3aupd3j5.png-pw144","id":14,"items_count":307,"name":"文艺风","order":3,"status":0,"url":""},{"cover_image_url":"http://img03.liwushuo.com/image/160630/noqxoncn0.png","group_id":1,"icon_url":"http://img02.liwushuo.com/image/160401/9hmc5ux1f.png-pw144","id":28,"items_count":108,"name":"科技范","order":3,"status":0,"url":""},{"cover_image_url":"http://img03.liwushuo.com/image/160630/5pf8qqzfu.png","group_id":1,"icon_url":"http://img03.liwushuo.com/image/160401/h54c765kw.png-pw144","id":126,"items_count":37,"name":"奇葩搞怪","order":0,"status":0,"url":""},{"cover_image_url":"http://img03.liwushuo.com/image/160630/lg049zh42.png","group_id":1,"icon_url":"http://img02.liwushuo.com/image/160401/laseg7k6q.png-pw144","id":127,"items_count":98,"name":"设计感","order":0,"status":0,"url":""}],"id":1,"name":"风格","order":5,"status":0},{"channels":[{"cover_image_url":"http://img03.liwushuo.com/image/160630/v825nm1kt.png","group_id":2,"icon_url":"http://img02.liwushuo.com/image/160414/j868ssqkl.png-pw144","id":10,"items_count":442,"name":"送女票","order":8,"status":0,"url":""},{"cover_image_url":"http://img03.liwushuo.com/image/160630/6el5oy61b.png","group_id":2,"icon_url":"http://img01.liwushuo.com/image/160401/56j52lxyq.png-pw144","id":9,"items_count":291,"name":"送男票","order":7,"status":0,"url":""},{"cover_image_url":"http://img02.liwushuo.com/image/160630/lnz6djelk.png","group_id":2,"icon_url":"http://img02.liwushuo.com/image/160401/9fml1mzye.png-pw144","id":24,"items_count":90,"name":"送宝贝","order":6,"status":0,"url":""},{"cover_image_url":"http://img02.liwushuo.com/image/160630/tdryuhq9z.png","group_id":2,"icon_url":"http://img01.liwushuo.com/image/160401/tsskwt8rq.png-pw144","id":6,"items_count":217,"name":"送爸妈","order":5,"status":0,"url":""},{"cover_image_url":"http://img01.liwushuo.com/image/160630/opxorjyik.png","group_id":2,"icon_url":"http://img01.liwushuo.com/image/160401/vq7h2y5ru.png-pw144","id":26,"items_count":589,"name":"送基友","order":5,"status":0,"url":""},{"cover_image_url":"http://img02.liwushuo.com/image/160630/1fv08oywk.png","group_id":2,"icon_url":"http://img01.liwushuo.com/image/160401/vmdxu2nrw.png-pw144","id":5,"items_count":1057,"name":"送闺蜜","order":4,"status":0,"url":""},{"cover_image_url":"http://img02.liwushuo.com/image/160630/r4bk4leke.png","group_id":2,"icon_url":"http://img03.liwushuo.com/image/160414/esbe2og0n.png-pw144","id":17,"items_count":102,"name":"送同事","order":2,"status":0,"url":""},{"cover_image_url":"http://img01.liwushuo.com/image/160630/wtbkkei5v.png","group_id":2,"icon_url":"http://img01.liwushuo.com/image/160414/49ludf8iy.png-pw144","id":132,"items_count":32,"name":"新婚夫妇","order":1,"status":0,"url":""},{"cover_image_url":"http://img03.liwushuo.com/image/160630/fr8mza1k1.png","group_id":2,"icon_url":"http://img01.liwushuo.com/image/160414/gglbvbdjd.png-pw144","id":133,"items_count":39,"name":"新手妈妈","order":0,"status":0,"url":""},{"cover_image_url":"http://img02.liwushuo.com/image/160630/1vhj1fqmh.png","group_id":2,"icon_url":"http://img03.liwushuo.com/image/160426/7gmz13c47.png-pw144","id":134,"items_count":156,"name":"送自己","order":0,"status":0,"url":""}],"id":2,"name":"对象","order":4,"status":0}]}
     * message : OK
     */

    private int code;
    private DataEntity data;
    private String message;

    public static StrtegyEndList objectFromData(String str) {

        return new Gson().fromJson(str, StrtegyEndList.class);
    }

    public static StrtegyEndList objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), StrtegyEndList.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<StrtegyEndList> arrayGiftBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<StrtegyEndList>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<StrtegyEndList> arrayGiftBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<StrtegyEndList>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataEntity {
        /**
         * channels : [{"cover_image_url":"http://img02.liwushuo.com/image/160624/hbd7w1sf4.png","group_id":5,"icon_url":"http://img02.liwushuo.com/image/160414/kwzqtscoa.png-pw144","id":111,"items_count":1165,"name":"礼物","order":10,"status":0,"url":""},{"cover_image_url":"http://img01.liwushuo.com/image/160624/duk8guejk.png","group_id":5,"icon_url":"http://img01.liwushuo.com/image/160401/58kdnthsn.png-pw144","id":112,"items_count":597,"name":"家居","order":9,"status":0,"url":""},{"cover_image_url":"http://img03.liwushuo.com/image/160624/axk8i901f.png","group_id":5,"icon_url":"http://img01.liwushuo.com/image/160414/6eutomjeo.png-pw144","id":110,"items_count":707,"name":"穿搭","order":8,"status":0,"url":""},{"cover_image_url":"http://img01.liwushuo.com/image/160624/ayjeuhtji.png","group_id":5,"icon_url":"http://img01.liwushuo.com/image/160414/abuv6vssc.png-pw144","id":2,"items_count":568,"name":"美物","order":7,"status":0,"url":""},{"cover_image_url":"http://img01.liwushuo.com/image/160624/x5vlfqcn4.png","group_id":5,"icon_url":"http://img03.liwushuo.com/image/160401/5al9xhwg1.png-pw144","id":116,"items_count":196,"name":"饰品","order":6,"status":0,"url":""},{"cover_image_url":"http://img01.liwushuo.com/image/160624/otqmww3av.png","group_id":5,"icon_url":"http://img02.liwushuo.com/image/160401/5dgflkj6g.png-pw144","id":117,"items_count":198,"name":"鞋包","order":5,"status":0,"url":""},{"cover_image_url":"http://img03.liwushuo.com/image/160624/1kx5seb62.png","group_id":5,"icon_url":"http://img01.liwushuo.com/image/160401/58vv7n29y.png-pw144","id":118,"items_count":500,"name":"美食","order":5,"status":0,"url":""},{"cover_image_url":"http://img02.liwushuo.com/image/160624/38778o4e0.png","group_id":5,"icon_url":"http://img02.liwushuo.com/image/160401/fb7e1012t.png-pw144","id":113,"items_count":531,"name":"美护","order":4,"status":0,"url":""},{"cover_image_url":"http://img01.liwushuo.com/image/160624/s69ub7yiq.png","group_id":5,"icon_url":"http://img01.liwushuo.com/image/160401/59hgqd1x8.png-pw144","id":121,"items_count":215,"name":"数码","order":4,"status":0,"url":""},{"cover_image_url":"http://img02.liwushuo.com/image/160624/2ky6x596q.png","group_id":5,"icon_url":"http://img01.liwushuo.com/image/160401/u4r2a9q72.png-pw144","id":3,"items_count":89,"name":"手工","order":3,"status":0,"url":""},{"cover_image_url":"http://img03.liwushuo.com/image/160624/d1xtmp1ig.png","group_id":5,"icon_url":"http://img02.liwushuo.com/image/160401/i69bjp6bm.png-pw144","id":119,"items_count":51,"name":"母婴","order":0,"status":0,"url":""},{"cover_image_url":"http://img02.liwushuo.com/image/160624/y3aqzhu9v.png","group_id":5,"icon_url":"http://img01.liwushuo.com/image/160401/t9t9hzntc.png-pw144","id":122,"items_count":66,"name":"爱动漫","order":0,"status":0,"url":""},{"cover_image_url":"http://img02.liwushuo.com/image/160624/ym66pnx98.png","group_id":5,"icon_url":"http://img02.liwushuo.com/image/160401/3ziqypz1f.png-pw144","id":123,"items_count":31,"name":"爱运动","order":0,"status":0,"url":""},{"cover_image_url":"http://img01.liwushuo.com/image/160606/ad06sqrix.png","group_id":5,"icon_url":"http://img01.liwushuo.com/image/160401/6pdxbaqz2.png-pw144","id":124,"items_count":22,"name":"爱读书","order":0,"status":0,"url":""},{"cover_image_url":"http://img01.liwushuo.com/image/160624/xxvb0a8aj.png","group_id":5,"icon_url":"http://img01.liwushuo.com/image/160401/voku467wc.png-pw144","id":129,"items_count":165,"name":"海淘","order":0,"status":0,"url":""}]
         * id : 5
         * name : 品类
         * order : 6
         * status : 0
         */

        private List<ChannelGroupsEntity> channel_groups;

        public static DataEntity objectFromData(String str) {

            return new Gson().fromJson(str, DataEntity.class);
        }

        public static DataEntity objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), DataEntity.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<DataEntity> arrayDataEntityFromData(String str) {

            Type listType = new TypeToken<ArrayList<DataEntity>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<DataEntity> arrayDataEntityFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<DataEntity>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public List<ChannelGroupsEntity> getChannel_groups() {
            return channel_groups;
        }

        public void setChannel_groups(List<ChannelGroupsEntity> channel_groups) {
            this.channel_groups = channel_groups;
        }

        public static class ChannelGroupsEntity {
            private int id;
            private String name;
            private int order;
            private int status;
            /**
             * cover_image_url : http://img02.liwushuo.com/image/160624/hbd7w1sf4.png
             * group_id : 5
             * icon_url : http://img02.liwushuo.com/image/160414/kwzqtscoa.png-pw144
             * id : 111
             * items_count : 1165
             * name : 礼物
             * order : 10
             * status : 0
             * url :
             */

            private List<ChannelsEntity> channels;

            public static ChannelGroupsEntity objectFromData(String str) {

                return new Gson().fromJson(str, ChannelGroupsEntity.class);
            }

            public static ChannelGroupsEntity objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), ChannelGroupsEntity.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<ChannelGroupsEntity> arrayChannelGroupsEntityFromData(String str) {

                Type listType = new TypeToken<ArrayList<ChannelGroupsEntity>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<ChannelGroupsEntity> arrayChannelGroupsEntityFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<ChannelGroupsEntity>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public List<ChannelsEntity> getChannels() {
                return channels;
            }

            public void setChannels(List<ChannelsEntity> channels) {
                this.channels = channels;
            }

            public static class ChannelsEntity {
                private String cover_image_url;
                private int group_id;
                private String icon_url;
                private int id;
                private int items_count;
                private String name;
                private int order;
                private int status;
                private String url;

                public static ChannelsEntity objectFromData(String str) {

                    return new Gson().fromJson(str, ChannelsEntity.class);
                }

                public static ChannelsEntity objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), ChannelsEntity.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<ChannelsEntity> arrayChannelsEntityFromData(String str) {

                    Type listType = new TypeToken<ArrayList<ChannelsEntity>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<ChannelsEntity> arrayChannelsEntityFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<ChannelsEntity>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public String getCover_image_url() {
                    return cover_image_url;
                }

                public void setCover_image_url(String cover_image_url) {
                    this.cover_image_url = cover_image_url;
                }

                public int getGroup_id() {
                    return group_id;
                }

                public void setGroup_id(int group_id) {
                    this.group_id = group_id;
                }

                public String getIcon_url() {
                    return icon_url;
                }

                public void setIcon_url(String icon_url) {
                    this.icon_url = icon_url;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getItems_count() {
                    return items_count;
                }

                public void setItems_count(int items_count) {
                    this.items_count = items_count;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getOrder() {
                    return order;
                }

                public void setOrder(int order) {
                    this.order = order;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
