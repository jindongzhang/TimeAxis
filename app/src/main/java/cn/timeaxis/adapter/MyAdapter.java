package cn.timeaxis.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.timeaxis.R;

/**
 * Created by apple on 2018/4/18.
 *
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Hold>{

    private List<String> list = null;

    public MyAdapter() {

    }

    public void setData(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public Hold onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Hold(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text, parent, false));
    }

    @Override
    public void onBindViewHolder(Hold holder, int position) {
        holder.textView.setText(String.valueOf(list.get(position)));
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size(): 0;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public static class Hold extends RecyclerView.ViewHolder{
        TextView textView;
        public Hold(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
