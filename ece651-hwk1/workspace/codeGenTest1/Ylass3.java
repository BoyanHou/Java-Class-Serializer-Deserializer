
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Ylass3 {
	private int i1;
	private ArrayList<Integer> list;

	public Ylass3() {
		list = new ArrayList<>();
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
		values.put(new JSONObject().put("i1", String.valueOf(i1)));
		JSONArray list_JSONArray = new JSONArray();
		for (int element : list) {
			list_JSONArray.put(element);
		}
		values.put(new JSONObject().put("list", list_JSONArray));
		json_object.put("values",values);

		return json_object;
	}


	public int getI1() {
		return i1;
	}

	public void setI1(int x) {
		i1 = x;
	}
	int numList() {
		return list.size();
	}

	void addList(int x) {
		list.add(x);
	}

	int getList(int index) {
		return list.get(index);
	}

	void setList(int index, int x) {
		list.set(index, x);
	}


}