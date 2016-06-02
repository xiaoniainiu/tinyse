package org.giiwa.tinyse.web.admin;

import org.giiwa.core.bean.X;
import org.giiwa.framework.web.Model;
import org.giiwa.framework.web.Path;
import org.giiwa.tinyse.se.SE;

import net.sf.json.JSONObject;

public class tinyse extends Model {

	@Path(path = "status", login = true, access = "access.config.admin")
	public void status() {
		this.set("types", SE.getTypes());
		this.set("m", this);
		this.show("/tinyse/status.html");
	}

	@Path(path = "reset", login = true, access = "access.config.admin")
	public void reset() {
		JSONObject jo = new JSONObject();

		SE.reset();

		jo.put(X.STATE, 200);
		jo.put(X.MESSAGE, "ok");
		this.response(jo);
	}

	/**
	 * 
	 * @param type
	 * @return
	 */
	public int count(String type) {
		return SE.count(type);
	}

	/**
	 * 
	 * @param type
	 * @return
	 */
	public int error(String type) {
		return SE.error(type);
	}

	public float index(String type) {
		return SE.index(type);
	}

	public float seach(String type) {
		return SE.search(type);
	}

	public long seachmax(String type) {
		return SE.searchmax(type);
	}

	public long seachmin(String type) {
		return SE.searchmin(type);
	}

}
