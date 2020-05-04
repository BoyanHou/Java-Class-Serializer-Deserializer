package edu.duke.ece651.classbuilder.package_test_json;
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
		obj.setI1(Integer.valueOf(values.getJSONObject(1).getString("i1")));
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
	public static Ylass2 readYlass2(JSONObject js) throws JSONException {
		HashMap<Integer, Object> map = new HashMap<>();
		return readYlass2(js, map);
	}
	public static Ylass2 readYlass2(JSONObject js, HashMap<Integer, Object> map) throws JSONException {
		if (js == JSONObject.NULL) {
			return null;
		}
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
		if (js == JSONObject.NULL) {
			return null;
		}
		if (js.has("ref")) {
			int key = js.getString("ref").hashCode();
			return (Ylass1)(map.get(key));
		}

		Ylass1 obj = new Ylass1();
		int id = js.getString("id").hashCode();
		map.put(id, obj);

		JSONArray values = js.getJSONArray("values");

		obj.setI1(Integer.valueOf(values.getJSONObject(0).getString("i1")));
		obj.setI2(Integer.valueOf(values.getJSONObject(1).getString("i2")));
		obj.setB1(Boolean.valueOf(values.getJSONObject(2).getString("b1")));
		obj.setB2(Boolean.valueOf(values.getJSONObject(3).getString("b2")));
		obj.setS1(String.valueOf(values.getJSONObject(4).getString("s1")));
		obj.setS2(String.valueOf(values.getJSONObject(5).getString("s2")));
		return obj;
	}
}