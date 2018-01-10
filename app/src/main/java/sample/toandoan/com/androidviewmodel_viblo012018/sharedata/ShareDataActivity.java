package sample.toandoan.com.androidviewmodel_viblo012018.sharedata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import sample.toandoan.com.androidviewmodel_viblo012018.R;

public class ShareDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_data);
        setTitle("Share data between two fragments");
    }
}
