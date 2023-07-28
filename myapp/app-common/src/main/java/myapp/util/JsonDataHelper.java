package myapp.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collection;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JsonDataHelper {
  public static <T> void loadJson(String filename, List<T> list, Class<T> clazz) {
    try {
      FileReader in0 = new FileReader(filename);
      BufferedReader in = new BufferedReader(in0);

      StringBuilder strBuilder = new StringBuilder();

      String line = null;
      while ((line = in.readLine()) != null) {
        strBuilder.append(line);
      }
      in.close();

      Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
      Collection<T> objects = gson.fromJson(strBuilder.toString(),
              TypeToken.getParameterized(Collection.class,clazz).getType());
      list.addAll(objects);
      
      
    } catch(Exception e) {
      System.out.println(filename + " 파일을 읽는 중 오류 발생!");
    }
    
  }

  public static void saveJson(String filename, List<?> list) {
    try {
      FileWriter out0 = new FileWriter(filename);
      BufferedWriter out = new BufferedWriter(out0);

      Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
      out.write(gson.toJson(list));
      out.close();
    } catch (Exception e) {
      System.out.println("메뉴 정보를 저장하는 중 오류 발생!");
    } 
  }
}
