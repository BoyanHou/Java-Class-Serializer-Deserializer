
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

import org.json.JSONException;

public class Deserializer {

	public static Ylass3 readYlass3(JSONObject js) throws JSONException {
		HashMap<Integer, Object> map = new HashMap<>();
		return readYlass3(js, map);
	}
	public static Ylass3 readYlass3(JSONObject js, HashMap<Integer, Object> map) throws JSONException {
		if (js.has("ref")) {
			int key = js.getString("ref").hashCode();
			return (Ylass3)(map.get(key));
		}

		Ylass3 obj = new Ylass3();
		int id = js.getString("id").hashCode();
		map.put(id, obj);

		JSONArray values = js.getJSONArray("values");

		obj.setI1(Int.valueOf(values.getJSONObject(0).getString("i1")));
		for (int i = 0; i < values.getJSONObject(1).getJSONArray("list").length(); i++) {
			int element = values.getJSONObject(1).getJSONArray("list").getInt(i);
			obj.addList(element);
		}
		return obj;
	}
}