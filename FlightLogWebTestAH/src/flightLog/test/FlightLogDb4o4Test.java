package flightLog.test;

import flightLog.Config;
import flightLog.FlightLog;
import flightLog.entities.Flight;
import flightLog.entities.Pilot;

public class FlightLogDb4o4Test extends FlightLogDbImplBaseTest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Config config = Config.get();
		config.setProperty("dbimpl", "flightLog.db.db4o4.FlightLogDb4o4Impl");		
		config.setProperty("dbfilename", "D:/java/flugbuch/FlightLogWebTestAH/flightlogdb4o4.yap");		
	}
	
	public void testPilots() throws Exception {
		FlightLog flightLog = new FlightLog();
		Pilot p1 = flightLog.savePilot(new Pilot(21L, "Testmeier", "Hugo"));
		Pilot p2 = flightLog.savePilot(new Pilot(22L, "Testnix", "Asterix"));
		printList(flightLog.getPilots(null));
		Flight flight1=flightLog.saveFlight(new Flight(11L, 1, p1));
		Flight flight2=flightLog.saveFlight(new Flight(12L, 1, p2));
		Flight flight3=flightLog.saveFlight(new Flight(13L, 2, p2));
		printList(flightLog.getFlights(null));
		printList(flightLog.getPilots(null));
		printList(flightLog.getFlightsForPilotId(22L));
		flightLog.deleteFlight(flight1);
		flightLog.deleteFlight(flight2);
		flightLog.deleteFlight(flight3);
		printList(flightLog.getPilots(null));
		flightLog.deletePilot(p1);
		flightLog.deletePilot(p2);
		printList(flightLog.getPilots(null));
	}
}
