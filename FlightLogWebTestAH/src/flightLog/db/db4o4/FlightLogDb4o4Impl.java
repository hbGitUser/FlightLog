package flightLog.db.db4o4;

import java.util.ArrayList;
import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import flightLog.db.FlightLogDatabaseIF;
import flightLog.entities.Flight;
import flightLog.entities.Pilot;

public class FlightLogDb4o4Impl implements FlightLogDatabaseIF {

	@Override
	public Pilot savePilot(Pilot pilot) throws Exception {
		ObjectContainer oc = Db4oConnector.get().openClient();
		oc.set(pilot);
		oc.close();
		return pilot;
	}

	@Override
	public List<Pilot> getPilots(Pilot pilot) throws Exception {
		ObjectContainer oc = Db4oConnector.get().openClient();
		ObjectSet objectSet = oc.get(pilot);
		List<Pilot> list = new ArrayList<Pilot>();
		while (objectSet.hasNext()) {
			list.add((Pilot) objectSet.next());
		}
		oc.close();
		return list.size() > 0 ? list : null;
	}

	@Override
	public Pilot getPilot(Long pilotId) throws Exception {
		List<Pilot> list = getPilots(new Pilot(pilotId, null, null));
		return list == null ? null : list.get(0);
	}

	@Override
	public Pilot deletePilot(Pilot pilot) throws Exception {
		ObjectContainer oc = Db4oConnector.get().openClient();
		oc.delete(pilot);
		oc.close();
		return pilot;
	}

	@Override
	public Flight saveFlight(Flight flight) throws Exception {
		ObjectContainer oc = Db4oConnector.get().openClient();
		oc.set(flight);
		oc.close();
		return flight;
	}

	@Override
	public List<Flight> getFlights(Flight flight) throws Exception {
		ObjectContainer oc = Db4oConnector.get().openClient();
		ObjectSet objectSet = oc.get(flight);
		List<Flight> list = new ArrayList<Flight>();
		while (objectSet.hasNext()) {
			list.add((Flight) objectSet.next());
		}
		oc.close();
		return list.size() > 0 ? list : null;
	}

	@Override
	public List<Flight> getFlightsForPilotId(Long pilotId) throws Exception {
		Pilot pilot = getPilot(pilotId); 
		Flight flight=new Flight();
		flight.setPilot(pilot);
		return getFlights(flight);
	}

	@Override
	public Flight deleteFlight(Flight flight) throws Exception {
		ObjectContainer oc = Db4oConnector.get().openClient();
		oc.delete(flight);
		oc.close();
		return flight;
	}
}
