
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

import org.json.JSONException;

public class Deserializer {

	public static Ylass4 readYlass4(JSONObject js) throws JSONException {
		HashMap<Integer, Object> map = new HashMap<>();
		return readYlass4(js, map);
	}
	public static Ylass4 readYlass4(JSONObject js, HashMap<Integer, Object> map) throws JSONException {
		if (js == JSONObject.NULL) {
			return null;
		}
		if (js.has("ref")) {
			int key = js.getString("ref").hashCode();
			return (Ylass4)(map.get(key));
		}

		Ylass4 obj = new Ylass4();
		int id = js.getString("id").hashCode();
		map.put(id, obj);

		JSONArray values = js.getJSONArray("values");

		obj.setC3(readYlass3(values.getJSONObject(0).getJSONObject("c3"), map));
		obj.setCh1(values.getJSONObject(1).getString("ch1").charAt(0));
		for (int i = 0; i < values.getJSONObject(2).getJSONArray("chars").length(); i++) {
			char element = values.getJSONObject(2).getJSONArray("chars").getString(i).charAt(0);
			obj.addChars(element);
		}
		return obj;
	}
	public static Ylass3 readYlass3(JSONObject js) throws JSONException {
		HashMap<Integer, Object> map = new HashMap<>();
		return readYlass3(js, map);
	}
	public static Ylass3 readYlass3(JSONObject js, HashMap<Integer, Object> map) throws JSONException {
		if (js == JSONObject.NULL) {
			return null;
		}
		if (js.has("ref")) {
			int key = js.getString("ref").hashCode();
			return (Ylass3)(map.get(key));
		}

		Ylass3 obj = new Ylass3();
		int id = js.getString("id").hashCode();
		map.put(id, obj);

		JSONArray values = js.getJSONArray("values");

		obj.setC4(readYlass4(values.getJSONObject(0).getJSONObject("c4"), map));
		obj.setI1(Int.valueOf(values.getJSONObject(1).getString("i1")));
		for (int i = 0; i < values.getJSONObject(2).getJSONArray("list").length(); i++) {
			int element = values.getJSONObject(2).getJSONArray("list").getInt(i);
			obj.addList(element);
		}
		for (int i = 0; i < values.getJSONObject(3).getJSONArray("c4s").length(); i++) {
			JSONObject element = values.getJSONObject(3).getJSONArray("c4s").getJSONObject(i);
			obj.addC4s(readYlass4(element, map));
		}
		return obj;
	}
}