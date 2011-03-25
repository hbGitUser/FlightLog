package flightLog.db.dummy;

import java.util.ArrayList;
import java.util.List;

import flightLog.db.FlightLogDatabaseIF;
import flightLog.entities.Flight;
import flightLog.entities.Pilot;

public class FlightLogDummyDBImpl implements FlightLogDatabaseIF {

	@Override
	public List<Flight> getFlights(Flight flight) throws Exception {
		return getFlights();
	}

	public List<Flight> getFlights() throws Exception {
		return new ArrayList<Flight>(DummyDataHolder.get().getFlights().values());
	}
	
	@Override
	public List<Flight> getFlightsForPilotId(Long pilotId) throws Exception {
		List<Flight> allFlights = getFlights();
		List<Flight> pilotFlights = new ArrayList<Flight>();
		for(Flight f : allFlights){
			if(f.getPilot() != null && f.getPilot().getId().equals(pilotId)) {
				pilotFlights.add(f);				
			}
		}
		return pilotFlights.size() > 0 ? pilotFlights : null;
	}

	@Override
	public Flight saveFlight(Flight flight) throws Exception {
		DummyDataHolder.get().getFlights().put(flight.getId(), flight);
		return flight;
	}

	@Override
	public Flight deleteFlight(Flight flight) throws Exception {
		DummyDataHolder.get().getFlights().remove(flight.getId());
		return null;
	}

	@Override
	public List<Pilot> getPilots(Pilot pilot) throws Exception {
		return new ArrayList<Pilot>(DummyDataHolder.get().getPilots().values());
	}
	
	@Override
	public Pilot getPilot(Long id) throws Exception {
		return DummyDataHolder.get().getPilots().get(id);
	}

	@Override
	public Pilot savePilot(Pilot pilot) throws Exception {
		DummyDataHolder.get().getPilots().put(pilot.getId(), pilot);
		return null;
	}
	
	@Override
	public Pilot deletePilot(Pilot pilot) throws Exception {
		DummyDataHolder.get().getPilots().remove(pilot.getId());
		return null;
	}

}
