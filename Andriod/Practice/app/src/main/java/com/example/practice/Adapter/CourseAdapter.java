package com.example.practice.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.practice.R;
import com.example.practice.databinding.RowCoursedetailsBinding;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    Context context;
    ArrayList<Integer> listImage;
    ArrayList<String> listName;
    public CourseAdapter(Context context, ArrayList<String> listName, ArrayList<Integer> listImage) {
        this.context=context;
        this.listImage=listImage;
        this.listName=listName;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.row_coursedetails,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.ivCourseImage.setImageResource(listImage.get(position));
        holder.binding.tvCourseName.setText(listName.get(position));
    }


    @Override
    public int getItemCount() {
        return listImage.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public RowCoursedetailsBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding= DataBindingUtil.bind(itemView);
        }
    }
}
