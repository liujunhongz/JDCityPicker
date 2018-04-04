package xyz.icoder.citypicker;

import java.util.List;

import xyz.icoder.citypicker.model.City;
import xyz.icoder.citypicker.model.County;
import xyz.icoder.citypicker.model.Province;
import xyz.icoder.citypicker.model.Street;


public interface AddressProvider {
    void provideProvinces(AddressReceiver<Province> addressReceiver);

    void provideCitiesWith(int provinceId, AddressReceiver<City> addressReceiver);

    void provideCountiesWith(int provinceIndex, int cityIndex, AddressReceiver<County> addressReceiver);

    void provideStreetsWith(int provinceIndex, int cityIndex, int countyIndex, AddressReceiver<Street> addressReceiver);

    interface AddressReceiver<T> {
        void send(List<T> data);
    }
}