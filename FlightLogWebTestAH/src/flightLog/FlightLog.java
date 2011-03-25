package flightLog;

import java.util.List;

import flightLog.db.FlightLogDatabaseFactory;
import flightLog.entities.Flight;
import flightLog.entities.Pilot;

public class FlightLog {
	
	public List<Pilot> getPilots(Pilot pilot) throws Exception {
		return FlightLogDatabaseFactory.getFlightLogDatabaseImpl().getPilots(pilot);
	}
	
	public Pilot getPilot(Long id) throws Exception {
		return FlightLogDatabaseFactory.getFlightLogDatabaseImpl().getPilot(id);
	}

	public List<Flight> getFlightsForPilotId(Long id) throws Exception {
		return FlightLogDatabaseFactory.getFlightLogDatabaseImpl().getFlightsForPilotId(id);
	}

	public List<Flight> getFlights(Flight flight) throws Exception {
		return FlightLogDatabaseFactory.getFlightLogDatabaseImpl().getFlights(flight);
	}

	public Flight saveFlight(Flight flight) throws Exception {
		return FlightLogDatabaseFactory.getFlightLogDatabaseImpl().saveFlight(flight);
	}
	
	public Flight deleteFlight(Flight flight) throws Exception {
		return FlightLogDatabaseFactory.getFlightLogDatabaseImpl().deleteFlight(flight);
	}

	public Pilot savePilot(Pilot pilot) throws Exception {
		return FlightLogDatabaseFactory.getFlightLogDatabaseImpl().savePilot(pilot);
	}
	
	public Pilot deletePilot(Pilot pilot) throws Exception {
		return FlightLogDatabaseFactory.getFlightLogDatabaseImpl().deletePilot(pilot);
	}

}
