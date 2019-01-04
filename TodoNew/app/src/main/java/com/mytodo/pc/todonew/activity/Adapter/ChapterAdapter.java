package com.mytodo.pc.todonew.activity.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mytodo.pc.todonew.R;
import com.mytodo.pc.todonew.activity.Activity.SectionActivity;
import com.mytodo.pc.todonew.activityInterface.ItemClickListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class ChapterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    //public ItemClickListener clickListener;
    private JSONArray menuItemJsonArray;


    public ChapterAdapter(Context context,JSONArray menuItemJsonArray) {
        this.mContext = context;
        //this.clickListener = itemClickListener;
        this.menuItemJsonArray=menuItemJsonArray;
    }

    public class MenuItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView menuItemA;
        private TextView menuItemB;
        private TextView menuItemC;
        public ItemClickListener clickListener;
       // private TextView menuItemD;

        MenuItemViewHolder(View itemView) {
            super(itemView);

            menuItemA = (TextView) itemView.findViewById(R.id.menu_item_a);
            menuItemB = (TextView) itemView.findViewById(R.id.menu_item_b);
            menuItemC = (TextView) itemView.findViewById(R.id.menu_item_c);
            //menuItemD = (TextView) itemView.findViewById(R.id.menu_item_d);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) clickListener.onClick(v, getAdapterPosition());

        }

        public void setClickListener(ItemClickListener clickListener) {
            this.clickListener = clickListener;
        }
    }


    @Override
    public int getItemCount() {
        return menuItemJsonArray.length();
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View menuItemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chapter_row_list, viewGroup, false);
        return new MenuItemViewHolder(menuItemLayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        MenuItemViewHolder menuItemHolder = (MenuItemViewHolder) holder;
        try {
            JSONObject job= (JSONObject) menuItemJsonArray.get(position);

            menuItemHolder.menuItemA.setText(job.getString("A"));
            menuItemHolder.menuItemB.setText(job.getString("B"));
            menuItemHolder.menuItemC.setText(job.getString("C"));

            menuItemHolder.setClickListener(new ItemClickListener() {
                @Override
                public void onClick(View view, int position) {
                    try {
                        Log.e("-->",menuItemJsonArray.get(position).toString());

                    Intent intent = new Intent(mContext, SectionActivity.class);
                    intent.putExtra("itemA", menuItemJsonArray.get(position).toString());
                    intent.putExtra("itemB", menuItemJsonArray.get(position).toString());
                    intent.putExtra("itemC", menuItemJsonArray.get(position).toString());
                    mContext.startActivity(intent);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}