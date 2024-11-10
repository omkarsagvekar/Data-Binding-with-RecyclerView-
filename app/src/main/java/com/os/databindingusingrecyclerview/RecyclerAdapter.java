package com.os.databindingusingrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.os.databindingusingrecyclerview.databinding.RecyclerviewItemBinding;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    Context context;
    List<InfoModel> list;
    private final MyDialogFragment.OnDialogDismissListener onDialogDismissListener;

    public RecyclerAdapter(Context context, List<InfoModel> list, MyDialogFragment.OnDialogDismissListener onDialogDismissListener) {
        this.context = context;
        this.list = list;
        this.onDialogDismissListener = onDialogDismissListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerviewItemBinding binding = RecyclerviewItemBinding.inflate(LayoutInflater.from(context), parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        InfoModel infoModel = list.get(position);
        holder.bind(infoModel);
        holder.itemView.setOnClickListener(view -> {
            AppCompatActivity activity = (AppCompatActivity) view.getContext();
            MyDialogFragment dialog = MyDialogFragment.newInstance(list.get(position).getName(), list.get(position).getSirName(), list.get(position).getAge());
            dialog.setOnDialogDismissListener(onDialogDismissListener);
            dialog.show(activity.getSupportFragmentManager(), "MyDialogFragment");
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private final  RecyclerviewItemBinding binding;
        public MyViewHolder(RecyclerviewItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(InfoModel infoModel){
            binding.setData(infoModel); // Set the user object to the binding
            binding.executePendingBindings(); // Refresh UI immediately
        }
    }
}
