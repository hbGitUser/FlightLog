package flightLog.db.dummy;

import java.util.LinkedHashMap;

import flightLog.entities.Flight;
import flightLog.entities.Pilot;

/**
 * threat safe dummy data holder singleton
 */
public class DummyDataHolder {

	private static class Holder {
		private static final DummyDataHolder INSTANCE = new DummyDataHolder();
	}

	public static DummyDataHolder get() {
		return Holder.INSTANCE;
	}

	private LinkedHashMap<Long, Pilot> pilots = new LinkedHashMap<Long, Pilot>();
	private LinkedHashMap<Long, Flight> flights = new LinkedHashMap<Long, Flight>();

	private DummyDataHolder() {
		populatePilots();
		populateFlights();
	}

	private void populatePilots() {
		long id = 1L;
		pilots.put(id, new Pilot(id++, "Becker", "Harold"));
		pilots.put(id, new Pilot(id++, "Hess", "Andreas"));
	}

	private void populateFlights() {
		long id = 1L;
		flights.put(id, new Flight(id++, 1, pilots.get(1L)));
		flights.put(id, new Flight(id++, 2, pilots.get(1L)));
		flights.put(id, new Flight(id++, 1, pilots.get(2L)));
	}

	public LinkedHashMap<Long, Pilot> getPilots() {
		return pilots;
	}

	public LinkedHashMap<Long, Flight> getFlights() {
		return flights;
	}
}
