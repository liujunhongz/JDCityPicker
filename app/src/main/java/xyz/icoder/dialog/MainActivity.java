package xyz.icoder.dialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import xyz.icoder.citypicker.AddressSelector;
import xyz.icoder.citypicker.OnAddressSelectedListener;
import xyz.icoder.citypicker.model.City;
import xyz.icoder.citypicker.model.County;
import xyz.icoder.citypicker.model.Province;
import xyz.icoder.citypicker.model.Street;

public class MainActivity extends AppCompatActivity implements OnAddressSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddressSelector selector = new AddressSelector(this);
        selector.setOnAddressSelectedListener(this);
        selector.setAddressProvider(new TestAddressProvider());
        FrameLayout frameLayout = findViewById(R.id.framelayout);
        frameLayout.addView(selector.getView());
    }

    @Override
    public void onAddressSelected(Province province, City city, County county, Street street) {

    }
}
