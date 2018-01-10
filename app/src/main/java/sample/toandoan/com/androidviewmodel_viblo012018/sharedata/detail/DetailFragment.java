package sample.toandoan.com.androidviewmodel_viblo012018.sharedata.detail;


import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sample.toandoan.com.androidviewmodel_viblo012018.R;
import sample.toandoan.com.androidviewmodel_viblo012018.sharedata.master.MasterViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements LifecycleOwner{
    private MasterViewModel mViewModel;
    private TextView mUserName;


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(MasterViewModel.class);
        mViewModel.getSelectedItem().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mUserName.setText(s);
            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUserName = view.findViewById(R.id.text_user_name);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

}
