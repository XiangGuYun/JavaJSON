import java.util.List;

/**
 * { //Region
 *     "provinces": [
 *         {
 *             "citys": [
 *                 {
 *                     "citysName": "石家庄市"
 *                 },
 */
public class  Region{

    private List<Province> provinceList;//存储所有省份

    public List<Province> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<Province> provinceList) {
        this.provinceList = provinceList;
    }

    public static class Province{
        private String provinceName;
        private List<City> cityList;

        public Province(String provinceName, List<City> cityList) {
            this.provinceName = provinceName;
            this.cityList = cityList;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public List<City> getCityList() {
            return cityList;
        }

        public void setCityList(List<City> cityList) {
            this.cityList = cityList;
        }
    }

    public static class City{
        private String citysName;

        public City(String citysName) {
            this.citysName = citysName;
        }

        public String getCitysName() {
            return citysName;
        }

        public void setCitysName(String citysName) {
            this.citysName = citysName;
        }
    }


}
