package shapiro.mco243.scheduler;

public class Job {

	private String name;

	private Priority priority;
	private Priority dynamicPriority;

	private JobState state;
	private JobType type;
	private int timeLeftToRun;

	private long lastRanAtTime;

	public Job(String name, Priority priority, JobType type, int timeLeftToRun) {
		this.name = name;
		this.priority = priority;
		this.timeLeftToRun = timeLeftToRun;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Priority getDynamicPriority() {
		return dynamicPriority;
	}

	public void setDynamicPriority(Priority dynamicPriority) {
		this.dynamicPriority = dynamicPriority;
	}

	public JobState getState() {
		return state;
	}

	public void setState(JobState state) {
		this.state = state;
	}

	public int getTimeLeftToRun() {
		return timeLeftToRun;
	}

	public void setTimeLeftToRun(int timeLeftToRun) {
		this.timeLeftToRun = timeLeftToRun;
	}

	public long getLastRanAtTime() {
		return lastRanAtTime;
	}

	public void setLastRanAtTime(long lastRanAtTime) {
		this.lastRanAtTime = lastRanAtTime;
	}

	public JobType getType() {
		return type;
	}

	public void setType(JobType type) {
		this.type = type;
	}

	public void decrementTimeLeftToRun(int time) {
		timeLeftToRun -= time;
	}

	public boolean isFinished() {
		return timeLeftToRun <= 0;
	}

}
