import java.util.ArrayList;

/***
 * implementing Activity log to record
 * Order and Deliver logs
 */

public class ActivityLog {

	private static volatile ActivityLog instance = null;
	private ArrayList<String> log;
	
	/**
	 * Constructor
	 */
	private ActivityLog() {
		log = new ArrayList<String>();
		
	}
	
	/**
	 * Used to return the instance of this class
	 * @return instance
	 */
	public static ActivityLog getInstance() {
		if (instance == null) {
			synchronized (ActivityLog.class) {
				if (instance == null) {
					instance = new ActivityLog();
				}
			}
		}
		return instance;
	}
	
	public void addLogRecord(String status){
		//log.add(status);
	}
	
	/**
	 * To get the logs generated
	 * @return log
	 */
	public ArrayList<String> getLogArray(){
		return new ArrayList<String>(log);
	}
	
}
