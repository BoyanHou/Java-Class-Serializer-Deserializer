
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

import org.json.JSONException;

public class Deserializer {

	public static Ylass2 readYlass2(JSONObject js) throws JSONException {
		HashMap<Integer, Object> map = new HashMap<>();
		return readYlass2(js, map);
	}
	public static Ylass2 readYlass2(JSONObject js, HashMap<Integer, Object> map) throws JSONException {
		if (js.has("ref")) {
			int key = js.getString("ref").hashCode();
			return (Ylass2)(map.get(key));
		}

		Ylass2 obj = new Ylass2();
		int id = js.getString("id").hashCode();
		map.put(id, obj);

		JSONArray values = js.getJSONArray("values");

		obj.setB1(Byte.valueOf(values.getJSONObject(0).getString("b1")));
		obj.setC1(values.getJSONObject(1).getString("c1").charAt(0));
		obj.setS1(Short.valueOf(values.getJSONObject(2).getString("s1")));
		obj.setL1(Long.valueOf(values.getJSONObject(3).getString("l1")));
		obj.setF1(Float.valueOf(values.getJSONObject(4).getString("f1")));
		obj.setD1(Double.valueOf(values.getJSONObject(5).getString("d1")));
		return obj;
	}
	public static Ylass1 readYlass1(JSONObject js) throws JSONException {
		HashMap<Integer, Object> map = new HashMap<>();
		return readYlass1(js, map);
	}
	public static Ylass1 readYlass1(JSONObject js, HashMap<Integer, Object> map) throws JSONException {
		if (js.has("ref")) {
			int key = js.getString("ref").hashCode();
			return (Ylass1)(map.get(key));
		}

		Ylass1 obj = new Ylass1();
		int id = js.getString("id").hashCode();
		map.put(id, obj);

		JSONArray values = js.getJSONArray("values");

		obj.setI1(Int.valueOf(values.getJSONObject(0).getString("i1")));
		obj.setI2(Int.valueOf(values.getJSONObject(1).getString("i2")));
		obj.setB1(Boolean.valueOf(values.getJSONObject(2).getString("b1")));
		obj.setB2(Boolean.valueOf(values.getJSONObject(3).getString("b2")));
		obj.setS1(String.valueOf(values.getJSONObject(4).getString("s1")));
		obj.setS2(String.valueOf(values.getJSONObject(5).getString("s2")));
		return obj;
	}
}