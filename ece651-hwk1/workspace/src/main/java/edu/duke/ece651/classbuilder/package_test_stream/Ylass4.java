package edu.duke.ece651.classbuilder.package_test_stream;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Ylass4 {
	private Ylass3 c3;
	private char ch1;
	private ArrayList<Character> chars;

	public Ylass4() {
		chars = new ArrayList<>();
	}

	public JSONObject toJSON() {
		HashMap<Integer, ArrayList<Object>> map = new HashMap<>();
		return toJSON(map);
	}
	public JSONObject toJSON(HashMap<Integer, ArrayList<Object>> map) {
		String className = "Ylass4";
		int classID = className.hashCode();

		JSONObject json_object = new JSONObject();

		int counter = 0;
		if (map.containsKey(classID)) {
			ArrayList<Object> objectList = map.get(classID);
			for (counter = 0; counter < objectList.size(); counter++) {
				if (objectList.get(counter) == this) {
					String id = String.valueOf(classID) + "_" + String.valueOf(counter);
					json_object.put("ref", id);
					return json_object;
				}
			}
		} else {
			ArrayList<Object> list = new ArrayList<>();
			map.put(classID, list);
		}

		map.get(classID).add(this);
		String id = String.valueOf(classID) + "_" + String.valueOf(counter);

		json_object.put("id", String.valueOf(id));
		json_object.put("type", "Ylass4");

		JSONArray values = new JSONArray();

		// start to put into values
		values.put(new JSONObject().put("c3", c3 == null ? JSONObject.NULL : c3.toJSON(map)));
		values.put(new JSONObject().put("ch1", String.valueOf(ch1)));
		JSONArray chars_JSONArray = new JSONArray();
		for (char element : chars) {
			chars_JSONArray.put(String.valueOf(element));
		}
		values.put(new JSONObject().put("chars", chars_JSONArray));
		json_object.put("values",values);

		return json_object;
	}


	public Ylass3 getC3() {
		return c3;
	}

	public void setC3(Ylass3 x) {
		c3 = x;
	}

	public char getCh1() {
		return ch1;
	}

	public void setCh1(char x) {
		ch1 = x;
	}
	public int numChars() {
		return chars.size();
	}

	public void addChars(char x) {
		chars.add(x);
	}

	public char getChars(int index) {
		return chars.get(index);
	}

	public void setChars(int index, char x) {
		chars.set(index, x);
	}


}