package com.example.listregistrationform;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    ArrayList<UserDetails> userDetailsArrayList;
    OnClickItemListner listner;
    Context context;

    public CustomAdapter(Context context,ArrayList<UserDetails> userList,OnClickItemListner listner) {
        this.context=context;
        this.listner = listner;
        this.userDetailsArrayList   =userList;
    }
    @Override
    public int getCount() {
        return userDetailsArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return userDetailsArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    class ViewHolder {
        ImageView imageView  ;
        TextView textViewName ;
        TextView textViewDesc;
    }
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder  holder =null;
        UserDetails userDetails = userDetailsArrayList.get(position);

        if (view == null){
            Log.d("LIST_HOLDER"," in null view case  "+position);
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=  inflater.inflate(R.layout.text_image_view_activity,null,false);
            ImageView imageView = view.findViewById(R.id.imageView);
            TextView textViewName = view.findViewById(R.id.textViewName);
            TextView textViewDesc = view.findViewById(R.id.textViewDesc);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                 listner.onItemClick(userDetails);


                }
            });

            holder=  new  ViewHolder();
            holder.imageView=imageView;
            holder.textViewName=textViewName;
            holder.textViewDesc=textViewDesc;

            view.setTag(holder);

        }else {
            Log.d("LIST_HOLDER"," in else case  view case  "+position);

            holder = (ViewHolder) view.getTag();


        }


        holder.textViewName.setText(userDetails.userName);
        holder.imageView.setImageResource(userDetails.icon);
        holder.textViewDesc.setText(userDetails.password);
        return view;
    }



    interface OnClickItemListner{
        void onItemClick(UserDetails userDetails);
    }
}
