package util;

import com.google.gson.Gson;

public class GsonHelp {
private static Gson gson=new Gson();
private GsonHelp() {
	
}
public static Gson getGson(){
	return gson;
	}
}
