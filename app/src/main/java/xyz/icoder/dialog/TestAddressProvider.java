package xyz.icoder.dialog;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import xyz.icoder.citypicker.AddressProvider;
import xyz.icoder.citypicker.model.City;
import xyz.icoder.citypicker.model.County;
import xyz.icoder.citypicker.model.Province;
import xyz.icoder.citypicker.model.Street;


public class TestAddressProvider implements AddressProvider {

    String json = "{\"list\":[{\"addressDistrictVOList\":[{\"addressSectorVOList\":[{\"districtId\":1,\"sectorId\":1,\"sectorName\":\"Base\"},{\"districtId\":1,\"sectorId\":2,\"sectorName\":\"Rukozo\"}],\"districtId\":1,\"districtName\":\"Rulindo\",\"provinceId\":1},{\"addressSectorVOList\":[],\"districtId\":2,\"districtName\":\"Gakenke\",\"provinceId\":1}],\"name\":\"Northern Province\",\"provinceId\":1},{\"addressDistrictVOList\":[],\"name\":\"Eastern Province\",\"provinceId\":2},{\"addressDistrictVOList\":[],\"name\":\"Southern Province\",\"provinceId\":3},{\"addressDistrictVOList\":[],\"name\":\"Western Province\",\"provinceId\":4},{\"addressDistrictVOList\":[],\"name\":\"Kigali City\",\"provinceId\":5},{\"addressDistrictVOList\":[],\"name\":\"Northern provinc\",\"provinceId\":6}]}";
    private final List<ProvinceCitys.Address> addresses;

    public TestAddressProvider() {
        addresses = new Gson().fromJson(json, ProvinceCitys.class).list;
    }

    @Override
    public void provideProvinces(AddressReceiver<Province> addressReceiver) {
        Province province;
        List<Province> provinces = new ArrayList<>();
        for (ProvinceCitys.Address address : addresses) {
            province = new Province();
            province.name = address.name;
            provinces.add(province);
        }
        addressReceiver.send(provinces);
    }

    @Override
    public void provideCitiesWith(int provinceId, AddressReceiver<City> addressReceiver) {

        City city;
        List<City> cities = new ArrayList<>();
        for (ProvinceCitys.Address.AddressDistrictVOList address : addresses.get(provinceId).addressDistrictVOList) {
            city = new City();
            city.name = address.districtName;
            cities.add(city);
        }

        addressReceiver.send(cities);
    }

    @Override
    public void provideCountiesWith(int provinceIndex, int cityIndex, AddressReceiver<County> addressReceiver) {
        County county;
        List<County> counties = new ArrayList<>();
        for (ProvinceCitys.Address.AddressDistrictVOList.AddressSectorVOList addressDistrictVOList : addresses.get(provinceIndex).addressDistrictVOList.get(cityIndex).addressSectorVOList) {
            county = new County();
            county.name = addressDistrictVOList.sectorName;
            counties.add(county);
        }
        addressReceiver.send(counties);
    }

    @Override
    public void provideStreetsWith(int provinceIndex, int cityIndex, int countyIndex, AddressReceiver<Street> addressReceiver) {
        addressReceiver.send(new ArrayList<Street>());
    }
}
