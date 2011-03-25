package flightLog.db.db4o4;

import javax.naming.ConfigurationException;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectServer;

import flightLog.Config;

public class Db4oConnector {

	ObjectServer server;

	private static class Holder {
		private static final Db4oConnector INSTANCE = new Db4oConnector();
	}

	public static Db4oConnector get() {
		return Holder.INSTANCE;
	}

	private Db4oConnector() {
		String dbfilename = Config.get().getProperty("dbfilename");
		if (dbfilename == null) {
			throw new RuntimeException(new ConfigurationException(
					"missing property dbfilename"));
		}
		server = Db4o.openServer(dbfilename, 0);
	}

	public ObjectContainer openClient() {
		return server.openClient();
	}

	public void closeServer() {
		if (server != null)
			server.close();
	}
}
