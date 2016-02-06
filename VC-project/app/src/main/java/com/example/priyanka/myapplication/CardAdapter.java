package com.example.priyanka.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



/**
 * Created by MadhuriKambalapalli on 1/31/16.
 */

import android.widget.Toast;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    List<EventItem> mItems;
    private Context context;

    public CardAdapter() {
        super();
        mItems = new ArrayList<EventItem>();

        /*
       EventItem event1 = new EventItem("Event 1","Come join us to feed hungry by providing food on this sunday at santa clara","charity1.jpg");
         EventItem event2 = new EventItem("Event 2","Lets make our community green by joining hands in cleaning","charity2.jpg");
       EventItem event3 = new EventItem("Event 3","Lets celebrate New year by giving unused things to needy","charity3.jpg");
       EventItem event4 = new EventItem("Event 4","Need volunteer for church mass which includes winter donation drive","charity4.jpg");
       EventItem event5 = new EventItem("Event 5","This is the event everyone looking for.","charity5.jpg");

         */
        EventItem event = new EventItem();
        event.setName("Eevent 1");
        event.setDesc("Come join us to feed hungry by providing food on this sunday at santa clara");
        event.setImage(R.drawable.charity1);
        event.setDate(Calendar.getInstance().getTime());
        event.setLink("");
        mItems.add(event);

        event = new EventItem();
        event.setName("Event  2");
        event.setDesc("Lets make our community green by joining hands in cleaning");
        event.setImage(R.drawable.charity2);
        event.setDate(Calendar.getInstance().getTime());
        event.setLink("www.green.com");
        mItems.add(event);


        event = new EventItem();
        event.setName("Event 3");
        event.setDesc("Lets celebrate New year by giving unused things to needy");
        event.setImage(R.drawable.charity3);
        event.setDate(Calendar.getInstance().getTime());
        event.setLink("www.events.com");
        mItems.add(event);

        event = new EventItem();
        event.setName("Event 4");
        event.setDesc("Need volunteer for church mass which includes winter donation drive");
        event.setImage(R.drawable.charity4);
        event.setDate(Calendar.getInstance().getTime());
        event.setLink("www.santaclarachurch.com");
        mItems.add(event);


        event = new EventItem();
        event.setName("Event 5");
        event.setDesc("This is the event everyone looking for.");
        event.setImage(R.drawable.charity5);
        event.setDate(Calendar.getInstance().getTime());
        event.setLink("www.eventbrite.com");
        mItems.add(event);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view, viewGroup, false);
        context=viewGroup.getContext();
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        EventItem event = mItems.get(i);
        viewHolder.tvEvent.setText(event.getName());
        viewHolder.tvDesc.setText(event.getDesc());

        viewHolder.imgThumbnail.setImageResource(event.getImage());
        viewHolder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (isLongClick) {

                    System.out.println("clicked");

                } else {
                    Intent iint = new Intent(context, EventDetailsActivity.class);
                    iint.putExtra("event", mItems.get(position));
                    context.startActivity(iint);
                    System.out.println("ssssclicked");

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        public ImageView imgThumbnail;
        public TextView tvEvent;
        public TextView tvDesc;
        private ItemClickListener clickListener;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            tvEvent = (TextView)itemView.findViewById(R.id.tv_event);
            tvDesc = (TextView)itemView.findViewById(R.id.tv_des_event);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }
        public void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getPosition(), false);
        }

        @Override
        public boolean onLongClick(View view) {
            clickListener.onClick(view, getPosition(), true);
            return true;
        }
    }
}



