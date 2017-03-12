package recyclerview.android.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import recyclerview.android.recyclerview.R;
import recyclerview.android.recyclerview.bean.DataBean;

/**
 * Created by hlk on 2017/3/11.
 */

public class GridAdatpter extends RecyclerView.Adapter<GridAdatpter.GridViewHolder> {

    private Context mContext;
    private List<DataBean> mDatas;

    public GridAdatpter(Context context, List<DataBean> data) {
        this.mContext = context;
        this.mDatas = data;
    }


    @Override
    public GridAdatpter.GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_grid, null);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GridAdatpter.GridViewHolder holder, int position) {
        DataBean bean = mDatas.get(position);
        holder.setData(bean);
    }

    @Override
    public int getItemCount() {
        if (mDatas != null) {
            return mDatas.size();
        }
        return 0;
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivIcon;
        private TextView tvName;

        public GridViewHolder(View itemView) {
            super(itemView);

            ivIcon = (ImageView) itemView.findViewById(R.id.iv_icon);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
        }

        public void setData(DataBean bean) {
            ivIcon.setImageResource(bean.icon);
            tvName.setText(bean.name);
        }
    }
}
