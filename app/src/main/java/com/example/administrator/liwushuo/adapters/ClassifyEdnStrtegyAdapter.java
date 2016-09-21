package com.example.administrator.liwushuo.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.model.classifymodel.StrtegyEndList;
import com.example.administrator.liwushuo.ui.ListBottomActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by liuhui on 2016/9/21.
 */
public class ClassifyEdnStrtegyAdapter extends RecyclerView.Adapter<ClassifyEdnStrtegyAdapter.MyViewHolder> {
    private List<StrtegyEndList.DataEntity.ChannelGroupsEntity>mEndData;

    private LayoutInflater inflater;
    private Context mContext;

    public ClassifyEdnStrtegyAdapter(Context context,List<StrtegyEndList.DataEntity.ChannelGroupsEntity>
            bottomData){
       this.mContext = context;
       this.mEndData = bottomData;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        return mEndData.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.classify_strtegy_end_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if(position==0){
            List<StrtegyEndList.DataEntity.ChannelGroupsEntity.ChannelsEntity> channels = mEndData.get
                    (0).getChannels();
            holder.mTextViewPinLei.setText(mEndData.get(0).getName());

            Picasso.with(mContext).load(channels.get(0).getCover_image_url()).into(holder.imageViewLiWu);
            Picasso.with(mContext).load(channels.get(1).getCover_image_url()).into(holder.imageViewJiaJu);
            Picasso.with(mContext).load(channels.get(2).getCover_image_url()).into(holder.imageViewChuanDa);
            Picasso.with(mContext).load(channels.get(3).getCover_image_url()).into(holder.imageViewMeiWu);
            Picasso.with(mContext).load(channels.get(4).getCover_image_url()).into(holder.imageViewShiPin);
            Picasso.with(mContext).load(channels.get(5).getCover_image_url()).into(holder.imageViewXieBao);
            holder.imageViewLiWu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ListBottomActivity.class);
                    intent.putExtra("id",mEndData.get(0).getId());
                    mContext.startActivity(intent);
                }
            });
            holder.imageViewJiaJu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ListBottomActivity.class);
                    intent.putExtra("id",mEndData.get(0).getId());
                    mContext.startActivity(intent);
                }
            });
            holder.imageViewChuanDa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ListBottomActivity.class);
                    intent.putExtra("id",mEndData.get(0).getId());
                    mContext.startActivity(intent);
                }
            });
            holder.imageViewMeiWu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ListBottomActivity.class);
                    intent.putExtra("id",mEndData.get(0).getId());
                    mContext.startActivity(intent);
                }
            });
            holder.imageViewShiPin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ListBottomActivity.class);
                    intent.putExtra("id",mEndData.get(0).getId());
                    mContext.startActivity(intent);
                }
            });
            holder.imageViewXieBao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ListBottomActivity.class);
                    intent.putExtra("id",mEndData.get(0).getId());
                    mContext.startActivity(intent);
                }
            });
        }
        if(position==1){
            List<StrtegyEndList.DataEntity.ChannelGroupsEntity.ChannelsEntity> channels = mEndData.get
                    (1).getChannels();
            holder.mTextViewPinLei.setText(mEndData.get(1).getName());
            Picasso.with(mContext).load(channels.get(0).getCover_image_url()).into(holder.imageViewLiWu);
            Picasso.with(mContext).load(channels.get(1).getCover_image_url()).into(holder.imageViewJiaJu);
            Picasso.with(mContext).load(channels.get(2).getCover_image_url()).into(holder.imageViewChuanDa);
            Picasso.with(mContext).load(channels.get(3).getCover_image_url()).into(holder.imageViewMeiWu);
            Picasso.with(mContext).load(channels.get(4).getCover_image_url()).into(holder.imageViewShiPin);
            Picasso.with(mContext).load(channels.get(5).getCover_image_url()).into(holder.imageViewXieBao);
            holder.imageViewLiWu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ListBottomActivity.class);
                    intent.putExtra("id",mEndData.get(1).getId());
                    mContext.startActivity(intent);
                }
            });
            holder.imageViewJiaJu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ListBottomActivity.class);
                    intent.putExtra("id",mEndData.get(1).getId());
                    mContext.startActivity(intent);
                }
            });
            holder.imageViewChuanDa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ListBottomActivity.class);
                    intent.putExtra("id",mEndData.get(1).getId());
                    mContext.startActivity(intent);
                }
            });
            holder.imageViewMeiWu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ListBottomActivity.class);
                    intent.putExtra("id",mEndData.get(1).getId());
                    mContext.startActivity(intent);
                }
            });
            holder.imageViewShiPin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ListBottomActivity.class);
                    intent.putExtra("id",mEndData.get(1).getId());
                    mContext.startActivity(intent);
                }
            });
            holder.imageViewXieBao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ListBottomActivity.class);
                    intent.putExtra("id",mEndData.get(1).getId());
                    mContext.startActivity(intent);
                }
            });
        }
        if(position==2){
            List<StrtegyEndList.DataEntity.ChannelGroupsEntity.ChannelsEntity> channels = mEndData.get
                    (2).getChannels();
            holder.mTextViewPinLei.setText(mEndData.get(2).getName());
            Picasso.with(mContext).load(channels.get(0).getCover_image_url()).into(holder.imageViewLiWu);
            Picasso.with(mContext).load(channels.get(1).getCover_image_url()).into(holder.imageViewJiaJu);
            Picasso.with(mContext).load(channels.get(2).getCover_image_url()).into(holder.imageViewChuanDa);
            Picasso.with(mContext).load(channels.get(3).getCover_image_url()).into(holder.imageViewMeiWu);
            Picasso.with(mContext).load(channels.get(4).getCover_image_url()).into(holder.imageViewShiPin);
            Picasso.with(mContext).load(channels.get(5).getCover_image_url()).into(holder.imageViewXieBao);
            holder.imageViewLiWu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ListBottomActivity.class);
                    intent.putExtra("id",mEndData.get(2).getId());
                    mContext.startActivity(intent);
                }
            });
            holder.imageViewJiaJu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ListBottomActivity.class);
                    intent.putExtra("id",mEndData.get(2).getId());
                    mContext.startActivity(intent);
                }
            });
            holder.imageViewChuanDa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ListBottomActivity.class);
                    intent.putExtra("id",mEndData.get(2).getId());
                    mContext.startActivity(intent);
                }
            });
            holder.imageViewMeiWu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ListBottomActivity.class);
                    intent.putExtra("id",mEndData.get(2).getId());
                    mContext.startActivity(intent);
                }
            });
            holder.imageViewShiPin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ListBottomActivity.class);
                    intent.putExtra("id",mEndData.get(2).getId());
                    mContext.startActivity(intent);
                }
            });
            holder.imageViewXieBao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ListBottomActivity.class);
                    intent.putExtra("id",mEndData.get(2).getId());
                    mContext.startActivity(intent);
                }
            });
        }

    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView mTextViewPinLei;
        private ImageView imageViewAll;
        private ImageView imageViewLiWu;
        private ImageView imageViewJiaJu;
        private ImageView imageViewChuanDa;
        private ImageView imageViewMeiWu;
        private ImageView imageViewShiPin;
        private ImageView imageViewXieBao;
    public MyViewHolder(View itemView) {
        super(itemView);
        mTextViewPinLei = (TextView) itemView.findViewById(R.id.tv_pinlei_gift);
        imageViewAll = (ImageView) itemView.findViewById(R.id.tv_pinlei_dianji);

        imageViewLiWu = (ImageView) itemView.findViewById(R.id.iv_pinlei_liwu);
        imageViewJiaJu = (ImageView) itemView.findViewById(R.id.iv_pinlei_jiaju);
        imageViewChuanDa = (ImageView) itemView.findViewById(R.id.iv_pinlei_chuanda);
        imageViewMeiWu = (ImageView) itemView.findViewById(R.id.iv_pinlei_meiwu);
        imageViewShiPin = (ImageView) itemView.findViewById(R.id.iv_pinlei_shipin);
        imageViewXieBao = (ImageView) itemView.findViewById(R.id.iv_pinlei_xiebao);
    }

}
}
