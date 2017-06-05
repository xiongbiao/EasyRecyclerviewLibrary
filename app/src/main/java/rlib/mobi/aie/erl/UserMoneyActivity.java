package rlib.mobi.aie.erl;

import android.os.Bundle;

import java.util.ArrayList;

import aie.mobi.activity.BaseRVActivity;
import aie.mobi.view.recyclerview.adapter.RecyclerArrayAdapter;


/**
 * 余额明细
 */
public class UserMoneyActivity extends BaseRVActivity<Transactions.TransactionsBean> implements RecyclerArrayAdapter.OnItemLongClickListener {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_money);
        init();
    }


    public void init() {
        initAdapter(MoneyAdapter.class, true, true);
        mAdapter.setOnItemLongClickListener(this);
        mRecyclerView.removeAllItemDecoration();
        onRefresh();
    }

    @Override
    public void onItemClick(int position) {
//        startAct(UserOrderDetailsActivity.class);
    }

    @Override
    public boolean onItemLongClick(int position) {
        return false;
    }


    @Override
    public void onRefresh() {
        super.onRefresh();
        start = 1;
        getdata(true);
    }

    private void getdata(final boolean b){
        Transactions data = new Transactions();
        data.transactions = new ArrayList<>();
        for (int i = 0 ; i < 100;i++){
            Transactions.TransactionsBean transactionsBean = new Transactions.TransactionsBean();
            data.transactions.add(transactionsBean);
        }


        mAdapter.clear();
        mAdapter.addAll(data.transactions);
        mRecyclerView.setRefreshing(false);

        mAdapter.stopMore();
    }


    @Override
    public void onLoadMore() {
        super.onLoadMore();
        start++;
        getdata(false);
    }






}

 
