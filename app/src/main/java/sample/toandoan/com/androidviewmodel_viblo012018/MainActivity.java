package sample.toandoan.com.androidviewmodel_viblo012018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import sample.toandoan.com.androidviewmodel_viblo012018.sharedata.ShareDataActivity;
import sample.toandoan.com.androidviewmodel_viblo012018.withoutviewmodel.CountNumberActivity;
import sample.toandoan.com.androidviewmodel_viblo012018.withviewmodel.CountNumberWithViewModelActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_with_viewmodel).setOnClickListener(this);
        findViewById(R.id.button_without_viewmodel).setOnClickListener(this);
        findViewById(R.id.button_share_data).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_with_viewmodel:
                startActivity(new Intent(MainActivity.this,
                        CountNumberWithViewModelActivity.class));
                break;
            case R.id.button_without_viewmodel:
                startActivity(new Intent(MainActivity.this,
                        CountNumberActivity.class));
                break;
            case R.id.button_share_data:
                startActivity(new Intent(MainActivity.this,
                        ShareDataActivity.class));
                break;
        }
    }
}
