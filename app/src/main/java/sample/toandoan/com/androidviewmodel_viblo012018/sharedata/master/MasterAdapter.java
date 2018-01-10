package sample.toandoan.com.androidviewmodel_viblo012018.sharedata.master;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doan.van.toan on 1/10/18.
 */

public class MasterAdapter extends RecyclerView.Adapter<MasterAdapter.ViewHolder> {
    private List<String> mData;
    private OnItemClickListenner mListenner;

    public MasterAdapter() {
        mData = new ArrayList<>();
    }

    public void addData(List<String> data) {
        if (data == null) {
            return;
        }
        mData.addAll(data);
        notifyDataSetChanged();
    }

    public void setListenner(OnItemClickListenner listenner) {
        mListenner = listenner;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view, mListenner);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;
        private OnItemClickListenner mListenner;

        public ViewHolder(View itemView, OnItemClickListenner listenner) {
            super(itemView);
            mTextView = itemView.findViewById(android.R.id.text1);
            mListenner = listenner;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListenner.onClick(mData.get(getAdapterPosition()));
            }
            });
        }

        public void bindData(String name) {
            if (TextUtils.isEmpty(name)) {
                return;
            }
            mTextView.setText(name);
        }
    }

    public interface OnItemClickListenner {
        void onClick(String result);
    }
}
