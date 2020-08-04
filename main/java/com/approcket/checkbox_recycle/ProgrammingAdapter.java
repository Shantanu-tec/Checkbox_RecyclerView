package com.approcket.checkbox_recycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class ProgrammingAdapter extends RecyclerView.Adapter<ProgrammingAdapter.ViewHolder> {
    String[] arr;
    // String name;
    Context context;
    private int selectedPosition = -1;
    private CheckBoxCheckedListener checkBoxCheckedListener;

    public ProgrammingAdapter(String[] arr, Context context) {
        this.arr = arr;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        String txt = arr[position];
        holder.textView.setText(txt);
        if (position == selectedPosition) {
            holder.checkBox.setChecked(true);
        } else holder.checkBox.setChecked(false);
//        holder.checkBox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (checkBox.isChecked()) {
//                    selectedPosition = position;
//                } else {
//                    selectedPosition = -1;
//                }
//                notifyDataSetChanged()
//            }
//        });
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxCheckedListener!=null){
                    checkBoxCheckedListener.getCheckBoxCheckedListener(position);

                }

            }
        });
        holder.checkBox.setOnClickListener(onStateChangedListener(holder.checkBox, position));
    }

    private View.OnClickListener onStateChangedListener(final CheckBox checkBox, final int position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    selectedPosition = position;
                } else {
                    selectedPosition = -1;
                }
                notifyDataSetChanged();
            }
        };
    }

    @Override
    public int getItemCount() {
        return arr.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imgview);
            textView = itemView.findViewById(R.id.txtview);
            checkBox=itemView.findViewById(R.id.checkbox);

        }

    }
    public interface CheckBoxCheckedListener{
        void getCheckBoxCheckedListener(int position);
    }
    public void setCheckBoxCheckedListener(CheckBoxCheckedListener checkBoxCheckedListener)
    {
        this.checkBoxCheckedListener=checkBoxCheckedListener;
    }
}