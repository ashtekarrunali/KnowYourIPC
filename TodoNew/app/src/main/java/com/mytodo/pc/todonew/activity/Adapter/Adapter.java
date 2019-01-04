package com.mytodo.pc.todonew.activity.Adapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mytodo.pc.todonew.R;
import com.mytodo.pc.todonew.activity.com.mytodo.pc.todonew.model.Intro;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context context;
    private List<Intro> intros;

    public Adapter(Context context, List<Intro> intros) {
        this.context = context;
        this.intros = intros;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, int position) {
        viewHolder.itemView.setTag(intros.get(position));
        Intro in = intros.get(position);
        viewHolder.desc.setText(in.getDescription());
        viewHolder.icon.setImageResource(in.getIcon());

    }


    @Override
    public int getItemCount() {
        return intros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView desc;
        public ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            desc = (TextView) itemView.findViewById(R.id.desc);

            icon = (ImageView) itemView.findViewById(R.id.icon);


        }
    }
}
