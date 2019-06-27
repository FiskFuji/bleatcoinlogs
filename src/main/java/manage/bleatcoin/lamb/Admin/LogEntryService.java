package manage.bleatcoin.lamb.Admin;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import manage.bleatcoin.lamb.Admin.entities.LogEntry;

public interface LogEntryService {

	public void createLog(List<LogEntry> logs);

    public Collection<LogEntry> getAllLogs();
    
	public Optional<LogEntry> findLogEntryById(String id);

	public void deleteLogEntryById(String id);

	public void updateLogEntry(LogEntry l);

	public void deleteAllLogs();
}