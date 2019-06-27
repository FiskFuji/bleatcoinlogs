package manage.bleatcoin.lamb.Admin;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import manage.bleatcoin.lamb.Admin.entities.LogEntry;
import manage.bleatcoin.lamb.Admin.ILogEntryRepository;
import manage.bleatcoin.lamb.Admin.LogEntryService;
 
@Service
public class LogEntryServImpl implements LogEntryService {

    // DAO Repository use Mongodb-Repository to perform db operations
    @Autowired
    ILogEntryRepository ilr;

    @Override
    public void createLog(List<LogEntry> logs) {
        ilr.saveAll(logs);
    }

    @Override
    public Collection<LogEntry> getAllLogs() {
        return ilr.findAll();
    }

    @Override
    public Optional<LogEntry> findLogEntryById(String id) {
        return ilr.findById(id);
    }

    @Override
    public void deleteLogEntryById(String id) {
        ilr.deleteById(id);
    }

    @Override
    public void updateLogEntry(LogEntry l) {
        ilr.save(l);
    }

    @Override
    public void deleteAllLogs() {
        ilr.deleteAll();
    }
}