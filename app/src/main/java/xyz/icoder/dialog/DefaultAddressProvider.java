//package xyz.icoder.dialog;
//
//import android.content.Context;
//
//
//import java.util.ArrayList;
//
//import xyz.icoder.citypicker.model.City;
//import xyz.icoder.citypicker.model.County;
//import xyz.icoder.citypicker.model.Province;
//import xyz.icoder.citypicker.model.Street;
//
//
//public class DefaultAddressProvider implements AddressProvider {
//    public DefaultAddressProvider(Context context) {
//        FlowManager.init(new FlowConfig.Builder(context.getApplicationContext()).build());
//    }
//
//    @Override
//    public void provideProvinces(final AddressReceiver<Province> addressReceiver) {
//        final FlowQueryList<Province> provinceQueryList = SQLite.select()
//                .from(Province.class)
//                .flowQueryList();
//        addressReceiver.send(new ArrayList<>(provinceQueryList));
//    }
//
//    @Override
//    public void provideCitiesWith(int provinceId, final AddressReceiver<City> addressReceiver) {
//        final FlowQueryList<City> cityQueryList = SQLite.select()
//                .from(City.class)
//                .where(City_Table.province_id.eq(provinceId))
//                .flowQueryList();
//        addressReceiver.send(new ArrayList<>(cityQueryList));
//    }
//
//    @Override
//    public void provideCountiesWith(int cityId, final AddressReceiver<County> addressReceiver) {
//        final FlowQueryList<County> countyQueryList = SQLite.select()
//                .from(County.class)
//                .where(County_Table.city_id.eq(cityId))
//                .flowQueryList();
//        addressReceiver.send(new ArrayList<>(countyQueryList));
//    }
//
//    @Override
//    public void provideStreetsWith(int countyId, final AddressReceiver<Street> addressReceiver) {
//        final FlowQueryList<Street> streetQueryList = SQLite.select()
//                .from(Street.class)
//                .where(Street_Table.county_id.eq(countyId))
//                .flowQueryList();
//        addressReceiver.send(new ArrayList<>(streetQueryList));
//    }
//}