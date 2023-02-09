package com.example.divarmvp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.divarmvp.R;
import com.example.divarmvp.room.entity.Product;
import com.example.divarmvp.ui.Detail.DetailActivity;

import java.util.ArrayList;
import java.util.List;

import dagger.Provides;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> implements Filterable {

    private Context context;
    private List<Product> list;
    private List<Product> temp;

    public ProductAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
        this.temp = new ArrayList<>();
    }

    public void setList(List<Product> list) {
        this.list = list;
        this.temp = list;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.list_items, parent, false));
    }

    @Override
    public void onBindViewHolder(ProductAdapter.MyViewHolder holder, int position) {

        int id = this.list.get(position).getId();
        String name = this.list.get(position).getName();
        String value = this.list.get(position).getValue();
        String time = this.list.get(position).getTime();
        int imgId = this.list.get(position).getImgId();
        String numberPhone = this.list.get(position).getNumberPhone();
        String details = this.list.get(position).getDetails();

        holder.tvname.setText(name);
        holder.tvvalue.setText(value);
        holder.tvtime.setText(time);
        holder.imgProduct.setImageResource(imgId);

        holder.listItemm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("id", id);
                intent.putExtra("name", name);
                intent.putExtra("value", value);
                intent.putExtra("time", time);
                intent.putExtra("imgId", imgId);
                intent.putExtra("numberPhone", numberPhone);
                intent.putExtra("details", details);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvname, tvvalue, tvtime;
        ImageView imgProduct;
        ConstraintLayout listItemm;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvname = itemView.findViewById(R.id.tvname);
            tvvalue = itemView.findViewById(R.id.tvvalue);
            tvtime = itemView.findViewById(R.id.tvtime);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            listItemm = itemView.findViewById(R.id.listItemm);

        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence fiterRequest) {
                FilterResults filterResults = new FilterResults();

                List<Product> filterlist= new ArrayList<>();
                for(Product item : temp){
                    if(item.getName().contains(fiterRequest)){
                        filterlist.add(item);
                    }

                }

                filterResults.values=filterlist;
                filterResults.count=filterlist.size();

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                list= (List<Product>) results.values;
                notifyDataSetChanged();


            }
        };
    }
}
