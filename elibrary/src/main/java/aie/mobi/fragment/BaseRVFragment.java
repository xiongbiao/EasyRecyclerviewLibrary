package aie.mobi.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;



import java.lang.reflect.Constructor;

import aie.mobi.view.recyclerview.EasyRecyclerView;
import aie.mobi.view.recyclerview.adapter.OnLoadMoreListener;
import aie.mobi.view.recyclerview.adapter.RecyclerArrayAdapter;
import aie.mobi.view.recyclerview.swipe.OnRefreshListener;
import aie.mobi.view.recyclerview.utils.NetworkUtils;
import mobi.aie.elibrary.R;


/**
 * @author xiongbiao.
 * @date 16/9/3.
 */
public abstract class BaseRVFragment<T> extends Fragment implements OnLoadMoreListener, OnRefreshListener, RecyclerArrayAdapter.OnItemClickListener {

    protected EasyRecyclerView mRecyclerView;
    public View mView;

    protected RecyclerArrayAdapter<T> mAdapter;
    Context mContext;
    protected int start = 1;
    protected int limit = 20;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    protected void initAdapter(boolean refreshable, boolean loadmoreable) {
        if (mAdapter != null) {
            mAdapter.setOnItemClickListener(this);
            mAdapter.setError(R.layout.common_error_view).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mAdapter.resumeMore();
                }
            });
            if (loadmoreable) {
                mAdapter.setMore(R.layout.common_more_view, this);
                mAdapter.setNoMore(R.layout.common_nomore_view);
            }
            if (refreshable && mRecyclerView != null) {
                mRecyclerView.setRefreshListener(this);
            }
        }
        if (mRecyclerView != null) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecyclerView.setItemDecoration(ContextCompat.getColor(mContext, R.color.common_divider_narrow), 1, 0, 0);
            mRecyclerView.setAdapterWithProgress(mAdapter);
        }
    }

    protected void initAdapter(Class<? extends RecyclerArrayAdapter<T>> clazz, boolean refreshable, boolean loadmoreable) {
        if(mView!=null){
            mRecyclerView = (EasyRecyclerView)mView.findViewById(R.id.recyclerview);
            mAdapter = (RecyclerArrayAdapter) createInstance(clazz);
            initAdapter(refreshable, loadmoreable);
        }
    }

    public Object createInstance(Class<?> cls) {
        Object obj;
        try {
            Constructor c1 = cls.getDeclaredConstructor(new Class[]{Context.class});
            c1.setAccessible(true);
            obj = c1.newInstance(new Object[]{mContext});
        } catch (Exception e) {
            obj = null;
        }
        return obj;
    }

    @Override
    public void onLoadMore() {
        if (!NetworkUtils.isConnected(mContext)) {
            mAdapter.pauseMore();
            return;
        }
    }

    @Override
    public void onRefresh() {
        start = 0;
        if(mContext==null)return;
        if (!NetworkUtils.isConnected(mContext)) {
            mAdapter.pauseMore();
            return;
        }
    }

    protected void loaddingError(){
        mAdapter.clear();
        mAdapter.pauseMore();
        mRecyclerView.setRefreshing(false);
    }
}
