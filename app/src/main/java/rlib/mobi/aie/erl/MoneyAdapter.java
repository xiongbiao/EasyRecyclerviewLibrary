package rlib.mobi.aie.erl;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import aie.mobi.view.recyclerview.adapter.BaseViewHolder;
import aie.mobi.view.recyclerview.adapter.RecyclerArrayAdapter;


public class MoneyAdapter extends RecyclerArrayAdapter<Transactions.TransactionsBean> {
    public MoneyAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseViewHolder<Transactions.TransactionsBean>(parent, R.layout.item_money) {
            @Override
            public void setData(final  Transactions.TransactionsBean item) {
                super.setData(item);



                holder.setText(R.id.tv1, item.type);
                TextView tv2 = (TextView)holder.getView(R.id.tv2);
                holder.setText(R.id.tv2,item.amount );
//                if(!TextUtils.isEmpty(item.amount)&&item.amount.startsWith("-")){
//                    tv2.setTextColor(ContextCompat.getColor(mContext,R.color.text_color9));
//                }else{
//                    tv2.setTextColor(ContextCompat.getColor(mContext,R.color.text_color10));
//                }
                holder.setText(R.id.tv3, item.title );
                holder.setText(R.id.tv4,"余额："+item.balance);
                holder.setText(R.id.tv6,"余额："+item.balance);
                holder.getView(R.id.tv6).setVisibility(View.VISIBLE);
                holder.setText(R.id.tv5,item.time);
//                holder.setText(R.id.tv6,item.status);

            }
        };
    }
}




//extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//    private Context context;
//    private List<?> list;
//    private LayoutInflater inflater;
//
//    public MoneyAdapter(Context context) {
//        this.context = context;
////        this.list = list;
//        inflater = LayoutInflater.from(context);
//    }
//
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        ProductHolder holder = new ProductHolder(inflater.inflate(R.layout.item_money, null));
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//
//        if (holder instanceof ProductHolder) {
//            ProductHolder hold = (ProductHolder) holder;
//            hold.tvCount.setText("数量1");
//            hold.tvName.setText("商品名");
//            hold.tvPrice.setText("单价:26");
//            hold.tvTime.setText(new Date().toLocaleString());
//            hold.tvSPrice.setText("合计：10000");
//            hold.tvState.setText("已经发货");
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return 20;
//    }
//
//    static class ProductHolder extends RecyclerView.ViewHolder {
//        TextView tvName;
//        TextView tvCount;
//        TextView tvPrice;
//        TextView tvTime;
//        TextView tvSd;
//        TextView tvSPrice;
//        TextView tvState;
//
//        public ProductHolder(View itemView) {
//            super(itemView);
//            tvName = (TextView) itemView.findViewById(R.id.tv_name);
//            tvPrice = (TextView) itemView.findViewById(R.id.tv_price);
//            tvCount = (TextView) itemView.findViewById(R.id.tv_count);
//
//            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
//            tvSd = (TextView) itemView.findViewById(R.id.tv_sd);
//            tvSPrice = (TextView) itemView.findViewById(R.id.tv_s_price);
//            tvState = (TextView) itemView.findViewById(R.id.tv_state);
//        }
//    }
//}
