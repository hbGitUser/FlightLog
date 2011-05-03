package flightLog.db;

import flightLog.Config;

public class FlightLogDatabaseFactory {

	private FlightLogDatabaseIF dbimpl;

	private static class Holder {
		private static final FlightLogDatabaseFactory INSTANCE = new FlightLogDatabaseFactory();
	}

	private FlightLogDatabaseFactory() {
		String dbimplClassName=Config.get().getProperty("dbimpl");
		try {
			Class<FlightLogDatabaseIF> clazz = (Class<FlightLogDatabaseIF>)Class.forName(dbimplClassName);
			dbimpl = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private FlightLogDatabaseIF getDbImpl() {
		return dbimpl;
	}

	public static FlightLogDatabaseIF getFlightLogDatabaseImpl() {
		FlightLogDatabaseFactory f = Holder.INSTANCE;
		return f.getDbImpl();
	}
	// Kommentar
}
