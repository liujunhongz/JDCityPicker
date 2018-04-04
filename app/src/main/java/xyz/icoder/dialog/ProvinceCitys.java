package xyz.icoder.dialog;

import java.util.List;

/**
 * @author su
 * @date 2018/3/18
 * @description
 */

public class ProvinceCitys {

    public List<Address> list;

    public static class Address {
        public String name;
        public int provinceId;
        public List<AddressDistrictVOList> addressDistrictVOList;

        public static class AddressDistrictVOList {
            public int districtId;
            public String districtName;
            public int provinceId;
            public List<AddressSectorVOList> addressSectorVOList;

            public static class AddressSectorVOList {
                public int districtId;
                public int sectorId;
                public String sectorName;
            }
        }
    }
}
