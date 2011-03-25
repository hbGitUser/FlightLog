package flightLog.test;

import flightLog.Config;
import flightLog.FlightLog;
import flightLog.entities.Flight;
import flightLog.entities.Pilot;

public class FlightLogDummyDBTest extends FlightLogDbImplBaseTest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Config config = Config.get();
		config.setProperty("dbimpl", "flightLog.db.dummy.FlightLogDummyDBImpl");		
	}
	
	public void testPilots() throws Exception {
		FlightLog flightLog = new FlightLog();
				
		printList(flightLog.getPilots(null));
		flightLog.savePilot(new Pilot(9L, "Testmeier", "Hugo"));
		printList(flightLog.getPilots(null));
		flightLog.deletePilot(new Pilot(1L, null, null));
		printList(flightLog.getPilots(null));
	}
	
	public void testFlights() throws Exception {		
		FlightLog flightLog = new FlightLog();
		
		printList(flightLog.getFlights(null));
		flightLog.saveFlight(new Flight(8L, 88, new Pilot(8L, "Testnix", "Obelix")));
		printList(flightLog.getFlights(null));
		flightLog.deleteFlight(new Flight(1L, null, null));
		printList(flightLog.getFlights(null));
	}
}
