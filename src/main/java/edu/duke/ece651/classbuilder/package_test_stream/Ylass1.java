package edu.duke.ece651.classbuilder.package_test_stream;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Ylass1 {
	private int i1;
	private int i2;
	private boolean b1;
	private boolean b2;
	private String s1;
	private String s2;

	public Ylass1() {
	}

	public JSONObject toJSON() {
		HashMap<Integer, ArrayList<Object>> map = new HashMap<>();
		return toJSON(map);
	}
	public JSONObject toJSON(HashMap<Integer, ArrayList<Object>> map) {
		String className = "Ylass1";
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
		json_object.put("type", "Ylass1");

		JSONArray values = new JSONArray();

		// start to put into values
		values.put(new JSONObject().put("i1", String.valueOf(i1)));
		values.put(new JSONObject().put("i2", String.valueOf(i2)));
		values.put(new JSONObject().put("b1", String.valueOf(b1)));
		values.put(new JSONObject().put("b2", String.valueOf(b2)));
		values.put(new JSONObject().put("s1", String.valueOf(s1)));
		values.put(new JSONObject().put("s2", String.valueOf(s2)));
		json_object.put("values",values);

		return json_object;
	}


	public int getI1() {
		return this.i1;
	}

	public void setI1(int x) {
		this.i1 = x;
	}

	public int getI2() {
		return this.i2;
	}

	public void setI2(int x) {
		this.i2 = x;
	}

	public boolean getB1() {
		return this.b1;
	}

	public void setB1(boolean x) {
		this.b1 = x;
	}

	public boolean getB2() {
		return this.b2;
	}

	public void setB2(boolean x) {
		this.b2 = x;
	}

	public String getS1() {
		return this.s1;
	}

	public void setS1(String x) {
		this.s1 = x;
	}

	public String getS2() {
		return this.s2;
	}

	public void setS2(String x) {
		this.s2 = x;
	}

}