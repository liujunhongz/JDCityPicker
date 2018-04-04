package xyz.icoder.citypicker;

import xyz.icoder.citypicker.model.City;
import xyz.icoder.citypicker.model.County;
import xyz.icoder.citypicker.model.Province;
import xyz.icoder.citypicker.model.Street;

public interface OnAddressSelectedListener {
    void onAddressSelected(Province province, City city, County county, Street street);
}
