package sample.toandoan.com.androidviewmodel_viblo012018.sharedata.master;


import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import sample.toandoan.com.androidviewmodel_viblo012018.R;

import static android.widget.LinearLayout.VERTICAL;

/**
 * A simple {@link Fragment} subclass.
 */
public class MasterFragment extends Fragment implements LifecycleOwner,
        MasterAdapter.OnItemClickListenner {
    private MasterViewModel mViewModel;
    private MasterAdapter mAdapter;


    public MasterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(MasterViewModel.class);
        mViewModel.getData().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable List<String> strings) {
                mAdapter.addData(strings);
            }
        });
    }

    private void initView() {
        RecyclerView recyclerView = getView().findViewById(R.id.recyclerview);
        mAdapter = new MasterAdapter();
        mAdapter.setListenner(this);
        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(recyclerView.getContext(), VERTICAL);
        recyclerView.setAdapter(mAdapter);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_master, container, false);
    }

    @Override
    public void onClick(String result) {
        mViewModel.setSelectedItem(result);
    }
}
