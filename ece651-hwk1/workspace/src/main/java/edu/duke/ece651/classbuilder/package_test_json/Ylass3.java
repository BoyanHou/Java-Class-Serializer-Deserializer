package edu.duke.ece651.classbuilder.package_test_json;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Ylass3 {
	private Ylass4 c4;
	private int i1;
	private ArrayList<Integer> list;
	private ArrayList<Ylass4> c4s;

	public Ylass3() {
		list = new ArrayList<>();
		c4s = new ArrayList<>();
	}

	public JSONObject toJSON() {
		HashMap<Integer, ArrayList<Object>> map = new HashMap<>();
		return toJSON(map);
	}
	public JSONObject toJSON(HashMap<Integer, ArrayList<Object>> map) {
		String className = "Ylass3";
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
		json_object.put("type", "Ylass3");

		JSONArray values = new JSONArray();

		// start to put into values
		values.put(new JSONObject().put("c4", c4 == null ? JSONObject.NULL : c4.toJSON(map)));
		values.put(new JSONObject().put("i1", String.valueOf(i1)));
		JSONArray list_JSONArray = new JSONArray();
		for (int element : list) {
			list_JSONArray.put(String.valueOf(element));
		}
		values.put(new JSONObject().put("list", list_JSONArray));
		JSONArray c4s_JSONArray = new JSONArray();
		for (Ylass4 element : c4s) {
			c4s_JSONArray.put(element == null ? JSONObject.NULL : element.toJSON(map));
		}
		values.put(new JSONObject().put("c4s", c4s_JSONArray));
		json_object.put("values",values);

		return json_object;
	}


	public Ylass4 getC4() {
		return this.c4;
	}

	public void setC4(Ylass4 x) {
		this.c4 = x;
	}

	public int getI1() {
		return this.i1;
	}

	public void setI1(int x) {
		this.i1 = x;
	}
	public int numList() {
		return this.list.size();
	}

	public void addList(int x) {
		this.list.add(x);
	}

	public int getList(int index) {
		return this.list.get(index);
	}

	public void setList(int index, int x) {
		this.list.set(index, x);
	}

	public int numC4s() {
		return this.c4s.size();
	}

	public void addC4s(Ylass4 x) {
		this.c4s.add(x);
	}

	public Ylass4 getC4s(int index) {
		return this.c4s.get(index);
	}

	public void setC4s(int index, Ylass4 x) {
		this.c4s.set(index, x);
	}


}