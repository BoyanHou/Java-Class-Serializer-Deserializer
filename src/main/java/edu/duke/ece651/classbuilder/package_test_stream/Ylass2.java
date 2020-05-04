package edu.duke.ece651.classbuilder.package_test_stream;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Ylass2 {
	private byte b1;
	private char c1;
	private short s1;
	private long l1;
	private float f1;
	private double d1;

	public Ylass2() {
	}

	public JSONObject toJSON() {
		HashMap<Integer, ArrayList<Object>> map = new HashMap<>();
		return toJSON(map);
	}
	public JSONObject toJSON(HashMap<Integer, ArrayList<Object>> map) {
		String className = "Ylass2";
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
		json_object.put("type", "Ylass2");

		JSONArray values = new JSONArray();

		// start to put into values
		values.put(new JSONObject().put("b1", String.valueOf(b1)));
		values.put(new JSONObject().put("c1", String.valueOf(c1)));
		values.put(new JSONObject().put("s1", String.valueOf(s1)));
		values.put(new JSONObject().put("l1", String.valueOf(l1)));
		values.put(new JSONObject().put("f1", String.valueOf(f1)));
		values.put(new JSONObject().put("d1", String.valueOf(d1)));
		json_object.put("values",values);

		return json_object;
	}


	public byte getB1() {
		return this.b1;
	}

	public void setB1(byte x) {
		this.b1 = x;
	}

	public char getC1() {
		return this.c1;
	}

	public void setC1(char x) {
		this.c1 = x;
	}

	public short getS1() {
		return this.s1;
	}

	public void setS1(short x) {
		this.s1 = x;
	}

	public long getL1() {
		return this.l1;
	}

	public void setL1(long x) {
		this.l1 = x;
	}

	public float getF1() {
		return this.f1;
	}

	public void setF1(float x) {
		this.f1 = x;
	}

	public double getD1() {
		return this.d1;
	}

	public void setD1(double x) {
		this.d1 = x;
	}

}