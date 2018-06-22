package me.namtran.geometrysolver;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Welcome on 8/27/2016.
 */
public class CustomAdapter extends ArrayAdapter<HistoryItem> {

    private Context context;
    private int resource;
    private List<HistoryItem> arrHistory;

    public CustomAdapter(Context context, int resource, ArrayList<HistoryItem> arrHistory) {
        super(context, resource, arrHistory);
        this.context = context;
        this.resource = resource;
        this.arrHistory = arrHistory;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.history_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvKetQua = (TextView) convertView.findViewById(R.id.tvKetQua);
            viewHolder.tvAvatar = (TextView) convertView.findViewById(R.id.tvAvatar);
            viewHolder.tvTime = (TextView) convertView.findViewById(R.id.tvTime);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String[] color={"#F55757", "#F665D9", "#6A57E1", "#57C5E1", "#57E15C", "#DCE157", "#E15C57"};
        HistoryItem historyItem = arrHistory.get(position);
        viewHolder.tvAvatar.setBackgroundColor(Color.parseColor(color[position%7]));
        viewHolder.tvAvatar.setText(String.valueOf(position+1));
        viewHolder.tvTitle.setText(historyItem.getTitle());
        viewHolder.tvKetQua.setText(historyItem.getKetqua());
        viewHolder.tvTime.setText(historyItem.getTimeCreate());
        return convertView;
    }

    public class ViewHolder {
        TextView tvTitle, tvKetQua, tvAvatar, tvTime;

    }
}
