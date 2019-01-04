package com.mytodo.pc.todonew.activity.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mytodo.pc.todonew.activity.Activity.DescriptionActivity;
import com.mytodo.pc.todonew.R;
import com.mytodo.pc.todonew.activityInterface.ItemClickListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    ArrayList<String> mSection = new ArrayList<>();

    // private ItemClickListener clickListener;
    private JSONArray menuItemJsonArray;


    public SectionAdapter(Context context, JSONArray menuItemJsonArray) {
        this.mContext = context;
        this.menuItemJsonArray = menuItemJsonArray;
        //  this.clickListener = itemClickListener;

    }


    public class MenuItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView menuItemtitle;
        private TextView menuItemE;
        public ItemClickListener clickListener;


        MenuItemViewHolder(View itemView) {
            super(itemView);

            menuItemtitle = (TextView) itemView.findViewById(R.id.menu_title);
            menuItemE = (TextView) itemView.findViewById(R.id.menu_item_e);
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
        //  return 0;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View menuItemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.section_row, viewGroup, false);
        return new SectionAdapter.MenuItemViewHolder(menuItemLayoutView);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //int viewType = getItemViewType(position);
        SectionAdapter.MenuItemViewHolder menuItemHolder = (SectionAdapter.MenuItemViewHolder) holder;
        try {
            final JSONObject jsonObject = (JSONObject) menuItemJsonArray.get(position);

            menuItemHolder.menuItemtitle.setText(jsonObject.getString("title"));
            menuItemHolder.menuItemE.setText(jsonObject.getString("E"));

            menuItemHolder.setClickListener(new ItemClickListener() {
                @Override
                public void onClick(View view, int position) {

                    try{
                    // Log.e("-->", menuItemJsonArray.get(position).toString());



                        /*Intent intent = new Intent(mContext, DescriptionActivity.class);
                        intent.putExtra("itemtitle", menuItemJsonArray.get(position).toString());
                        intent.putExtra("itemE", menuItemJsonArray.get(position).toString());
                        Log.d(TAG, "onClick: ");
                        intent.putExtra("itemF",menuItemJsonArray.get(position).toString());
                        mContext.startActivity(intent);*/


                        Intent intent = new Intent(mContext, DescriptionActivity.class);
                        intent.putExtra("itemE",jsonObject.getString("E"));
                        intent.putExtra("itemF", jsonObject.getString("F"));
                       // Log.d("", "onClick: ");
                        //intent.putExtra("itemF",menuItemJsonArray.get(position).toString());
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