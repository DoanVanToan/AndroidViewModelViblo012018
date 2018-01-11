package sample.toandoan.com.androidviewmodel_viblo012018.withviewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

/**
 * Created by doan.van.toan on 1/10/18.
 */

public class CountNumberViewModel extends AndroidViewModel {
    private MutableLiveData<Integer> mScoreTeamA = new MutableLiveData<>();
    private MutableLiveData<Integer> mScoreTeamB = new MutableLiveData<>();

    public CountNumberViewModel(@NonNull Application application) {
        super(application);
        mScoreTeamA.setValue(0);
        mScoreTeamB.setValue(0);
    }

    public MutableLiveData<Integer> getScoreTeamA() {
        return mScoreTeamA;
    }

    public MutableLiveData<Integer> getScoreTeamB() {
        return mScoreTeamB;
    }

    public void increaseScroeTeamA(int score) {
        mScoreTeamA.setValue(mScoreTeamA.getValue() + score);
    }

    public void increaseScroeTeamB(int score) {
        mScoreTeamB.setValue(mScoreTeamB.getValue() + score);
    }
}
