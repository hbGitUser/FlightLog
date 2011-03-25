package flightLog.db;

import java.util.List;

import flightLog.entities.Flight;
import flightLog.entities.Pilot;

public interface FlightLogDatabaseIF {

	public List<Pilot> getPilots(Pilot pilot) throws Exception;

	public Pilot getPilot(Long pilotId) throws Exception;

	public List<Flight> getFlightsForPilotId(Long pilotId) throws Exception;

	public Flight deleteFlight(Flight flight) throws Exception;

	public List<Flight> getFlights(Flight flight) throws Exception;

	public Flight saveFlight(Flight flight) throws Exception;

	public Pilot deletePilot(Pilot pilot) throws Exception;

	public Pilot savePilot(Pilot pilot) throws Exception;
}
