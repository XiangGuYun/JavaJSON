import com.google.gson.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 用GSON读取省事JSON数据，并保存到JavaBean中
 */
public class ReadCitys {

    static List<Region.Province> provinceList = new ArrayList<>();//保存着所有省份的集合

    public static void main(String[] args) {
        JsonParser parser = new JsonParser();
        try {
            //读取本地JSON数据
            JsonElement element = parser.parse(new BufferedReader(new InputStreamReader(
                    new FileInputStream(new File("D:\\java\\JavaJSON\\src\\citys.json"))
            )));
            JsonObject data = element.getAsJsonObject();//转换为JSON对象
            //解析name为provinces的JSON数组
            JsonArray provinces = data.getAsJsonArray("provinces");

            /*
            遍历省份JSON数组
             */
            for (int i = 0; i < provinces.size(); i++) {
                //向内解析城市对象
                JsonObject citysObj = provinces.get(i).getAsJsonObject();
                //向内解析城市数组
                JsonArray citysArr = citysObj.getAsJsonArray("citys");
                //新建一个城市集合，用来存储当前省份的所有城市
                List<Region.City> cityList = new ArrayList<>();
                /*
                遍历和记录当前省份的所有城市信息，并加入到城市集合中
                 */
                for (int j = 0; j < citysArr.size(); j++) {
                    cityList.add(new Region.City(citysArr.get(j).getAsJsonObject().get("citysName").getAsString()));
                }
                //将当前省份添加到省份集合中
                provinceList.add(new Region.Province(
                        citysObj.get("provinceName").getAsString(),//省名
                        cityList)//城市集合
                );
            }
            /*
            打印所有省份
             */
            for (int i = 0; i < provinceList.size(); i++) {
                System.out.println(provinceList.get(i).getProvinceName());
            }
            /*
            打印河北省的所有省份
             */
            for (int i = 0; i < provinceList.get(0).getCityList().size(); i++) {
                System.out.println(provinceList.get(0).getCityList().get(i).getCitysName());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
