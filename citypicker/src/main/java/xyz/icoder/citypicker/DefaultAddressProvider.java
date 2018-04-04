package xyz.icoder.citypicker;

import java.util.ArrayList;

import xyz.icoder.citypicker.model.City;
import xyz.icoder.citypicker.model.County;
import xyz.icoder.citypicker.model.Province;
import xyz.icoder.citypicker.model.Street;


public class DefaultAddressProvider implements AddressProvider {
    public DefaultAddressProvider() {
    }

    @Override
    public void provideProvinces(final AddressReceiver<Province> addressReceiver) {
        addressReceiver.send(new ArrayList<Province>());
    }

    @Override
    public void provideCitiesWith(int provinceId, final AddressReceiver<City> addressReceiver) {
        addressReceiver.send(new ArrayList<City>());
    }

    @Override
    public void provideCountiesWith(int provinceIndex, int cityIndex, final AddressReceiver<County> addressReceiver) {
        addressReceiver.send(new ArrayList<County>());
    }

    @Override
    public void provideStreetsWith(int provinceIndex, int cityIndex, int countyIndex, final AddressReceiver<Street> addressReceiver) {
        addressReceiver.send(new ArrayList<Street>());
    }
}
