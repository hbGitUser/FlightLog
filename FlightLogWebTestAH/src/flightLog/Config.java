package flightLog;

import java.util.Properties;

public class Config extends Properties {

	private static class Holder {
		private static final Config INSTANCE = new Config();
	}

	public static Config get() {
		return Holder.INSTANCE;
	}

	private Config() {
	}

}
