import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonToken;
import jdk.nashorn.internal.parser.TokenType;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        /**
         * 生成JSON数据（原生）
         */
        //createJSONStringByNative();
        /**
         * 将MAP转换成JSON数据(API)
         */
        //convertMap2JSONStringByAPI();
        /**
         * 从文件中读取JSON字符串（原生）
         */
        //readJsonFromFileByNative();
        /**
         * 从文件中读取JSON对象（API）
         */
        readJsonObjectFromFileByAPI();
      
    }


    private static void readJsonObjectFromFileByAPI() {
        Gson gson = new Gson();
        try {
            Girl girl = gson.fromJson(
                    new BufferedReader(new FileReader("D:\\java\\JavaJSON\\src\\test.json"))
            ,Girl.class);
            System.out.println(gson.toJson(girl));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void readJsonStringFromFileByNative() {
        JsonParser parser = new JsonParser();
        try {
            JsonElement element = parser.parse(new BufferedReader(new InputStreamReader(
                    new FileInputStream(new File("D:\\java\\JavaJSON\\src\\test.json"))
            )));
            System.out.println(element.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void convertMap2JSONStringByAPI() {
        Gson gson = new Gson();
        Map<String,Object> lily = new HashMap<>();
        lily.put("name","lily");
        lily.put("age",22);
        lily.put("school","lanxiang");
        lily.put("single",false);
        lily.put("habit", new String[]{"read","game"});
        System.out.println("map: "+gson.toJson(lily));
    }


    private static void createJSONStringByNative() {
        JsonObject lily = new JsonObject();//外部对象
        JsonObject lily_bf = new JsonObject();//内部对象
        //添加基本类型
        lily.addProperty("name","lily");
        lily.addProperty("age",22);
        lily.addProperty("school","lanxiang");
        lily.addProperty("single",false);
        //添加对象
        lily_bf.addProperty("age", 23);
        lily_bf.addProperty("sex", "male");
        lily.add("bf", lily_bf);
        //添加数组
        lily.add("habit", new JsonParser().parse("['read','music','game']"));

        System.out.println(lily.toString());//将JSON对象转换成JSON字符串
    }
}
