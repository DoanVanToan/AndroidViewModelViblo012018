package sample.toandoan.com.androidviewmodel_viblo012018.sharedata.master;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doan.van.toan on 1/10/18.
 */

public class MasterViewModel extends AndroidViewModel {
    private MutableLiveData<List<String>> mData = new MutableLiveData<>();
    private MutableLiveData<String> mSelectedItem = new MutableLiveData<>();

    public MasterViewModel(@NonNull Application application) {
        super(application);
        mData.setValue(getSampleData());
    }

    public MutableLiveData<List<String>> getData() {
        return mData;
    }

    public List<String> getSampleData() {
        List<String> result = new ArrayList<>();
        result.add("Susanna Mcmillian");
        result.add("Cheryl Stockman");
        result.add("Jesus Pitts");
        result.add("Shirly Grado");
        result.add("Stevie Kucera");
        result.add("Oneida Lafrance");
        result.add("Ashli Kenna");
        result.add("Madlyn Keasey");
        result.add("Sharonda Wisneski");
        result.add("Eliz Hildebrand");
        result.add("Tod Kellerhouse");
        result.add("Sung Farnan");
        result.add("Elenor Darrow");
        result.add("Max Garlick");
        result.add("Yolanda Digirolamo");
        result.add("Liane Scoby");
        result.add("Jed Hunger");
        result.add("Hilario Schreffler");
        result.add("Shanda Eadie");
        result.add("Londa Shelnutt");
        return result;
    }

    public MutableLiveData<String> getSelectedItem() {
        return mSelectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        mSelectedItem.setValue(selectedItem);
    }
}
