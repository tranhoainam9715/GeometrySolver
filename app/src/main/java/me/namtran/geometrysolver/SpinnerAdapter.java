package me.namtran.geometrysolver;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SpinnerAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    String[] spinnerTitles;
    int[] spinnerImages;
    Context mContext;
    public SpinnerAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public SpinnerAdapter(@NonNull Context context, String[] titles, int[] images) {
        super(context, R.layout.selector_item);
        this.spinnerTitles = titles;
        this.spinnerImages = images;
        this.mContext = context;
    }
    @Override
    public int getCount() {
        return spinnerTitles.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.selector_item, parent, false);
            mViewHolder.ivGeometry = (ImageView) convertView.findViewById(R.id.ivGeometry);
            mViewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.ivGeometry.setImageResource(spinnerImages[position]);
        mViewHolder.tvName.setText(spinnerTitles[position]);
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getView(position, convertView, parent);
    }
    ////
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        SpinnerAdapter.ViewHolder viewHolder;
//        if (convertView == null) {
//            convertView = LayoutInflater.from(context).inflate(R.layout.selector_item, parent, false);
//            viewHolder = new SpinnerAdapter.ViewHolder();
//            viewHolder.tvName = (TextView)convertView.findViewById(R.id.tvName);
//            viewHolder.ivGeometry = (ImageView)convertView.findViewById(R.id.ivGeometry);
//
//            convertView.setTag(viewHolder);
//        } else {
//            viewHolder = (SpinnerAdapter.ViewHolder) convertView.getTag();
//        }
////        String[] color={"#F55757", "#F665D9", "#6A57E1", "#57C5E1", "#57E15C", "#DCE157", "#E15C57"};
//        geometry_item historyItem = arrHistory.get(position);
//        viewHolder.ivGeometry.setImageResource(historyItem.getImageID());
//        viewHolder.tvName.setText(historyItem.getName());
//        return convertView;
//    }

    public class ViewHolder {
        TextView tvName;
        ImageView ivGeometry;

    }
}
