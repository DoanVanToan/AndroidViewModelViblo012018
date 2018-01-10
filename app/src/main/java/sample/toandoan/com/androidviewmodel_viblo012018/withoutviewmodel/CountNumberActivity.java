package sample.toandoan.com.androidviewmodel_viblo012018.withoutviewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import sample.toandoan.com.androidviewmodel_viblo012018.R;
import sample.toandoan.com.androidviewmodel_viblo012018.withviewmodel.MainViewModel;

public class CountNumberActivity extends AppCompatActivity implements View.OnClickListener {
    private MutableLiveData<Integer> mScoreTeamA = new MutableLiveData<>();
    private MutableLiveData<Integer> mScoreTeamB = new MutableLiveData<>();
    private TextView mTextScoreTeamA, mTextScoreTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        registerLiveDataListenner();
        initViews();
        setTitle("Count without ViewModel");
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
        mScoreTeamA.setValue(0);
        mScoreTeamA.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                mTextScoreTeamA.setText(String.valueOf(integer));
            }
        });
        mScoreTeamB.setValue(0);
        mScoreTeamB.observe(this, new Observer<Integer>() {
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
                increaseScroeTeamA(3);
                break;
            case R.id.button_plus_a_2:
                increaseScroeTeamA(2);
                break;
            case R.id.button_plus_a_1:
                increaseScroeTeamA(1);
                break;
            case R.id.button_plus_b_3:
                increaseScroeTeamB(3);
                break;
            case R.id.button_plus_b_2:
                increaseScroeTeamB(2);
                break;
            case R.id.button_plus_b_1:
                increaseScroeTeamB(1);
                break;
        }
    }

    private void increaseScroeTeamB(int score) {
        mScoreTeamB.setValue(mScoreTeamB.getValue() + score);
    }

    private void increaseScroeTeamA(int score) {
        mScoreTeamA.setValue(mScoreTeamA.getValue() + score);
    }
}
