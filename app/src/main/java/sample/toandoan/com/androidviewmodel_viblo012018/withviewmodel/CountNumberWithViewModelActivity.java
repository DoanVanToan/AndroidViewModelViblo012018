package sample.toandoan.com.androidviewmodel_viblo012018.withviewmodel;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import sample.toandoan.com.androidviewmodel_viblo012018.R;

public class CountNumberWithViewModelActivity extends AppCompatActivity implements LifecycleOwner, View.OnClickListener {
    private CountNumberViewModel mViewModel;
    private TextView mTextScoreTeamA, mTextScoreTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        mViewModel = ViewModelProviders.of(this).get(CountNumberViewModel.class);
        registerLiveDataListenner();
        initViews();
        setTitle("Count with ViewModel");
    }

    private void initViews() {
        mTextScoreTeamA = findViewById(R.id.text_score_a);
        mTextScoreTeamB = findViewById(R.id.text_score_b);
        findViewById(R.id.button_plus_a_3).setOnClickListener(this);
        findViewById(R.id.button_plus_a_2).setOnClickListener(this);
        findViewById(R.id.button_plus_a_1).setOnClickListener(this);
        findViewById(R.id.button_plus_b_3).setOnClickListener(this);
        findViewById(R.id.button_plus_b_2).setOnClickListener(this);
        findViewById(R.id.button_plus_b_1).setOnClickListener(this);
    }

    public void registerLiveDataListenner() {
        mViewModel.getScoreTeamA().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                mTextScoreTeamA.setText(String.valueOf(integer));
            }
        });
        mViewModel.getScoreTeamB().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                mTextScoreTeamB.setText(String.valueOf(integer));
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_plus_a_3:
                mViewModel.increaseScroeTeamA(3);
                break;
            case R.id.button_plus_a_2:
                mViewModel.increaseScroeTeamA(2);
                break;
            case R.id.button_plus_a_1:
                mViewModel.increaseScroeTeamA(1);
                break;
            case R.id.button_plus_b_3:
                mViewModel.increaseScroeTeamB(3);
                break;
            case R.id.button_plus_b_2:
                mViewModel.increaseScroeTeamB(2);
                break;
            case R.id.button_plus_b_1:
                mViewModel.increaseScroeTeamB(1);
                break;
        }
    }
}
