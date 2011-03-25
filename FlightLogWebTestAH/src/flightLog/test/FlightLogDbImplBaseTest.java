package flightLog.test;

import java.util.List;

import junit.framework.TestCase;

public class FlightLogDbImplBaseTest extends TestCase {

	protected void printList(List list) throws Exception {
		System.out.println("-- Objects:");
		for (Object o: list) {
			System.out.println(o);
		}
	}
}
