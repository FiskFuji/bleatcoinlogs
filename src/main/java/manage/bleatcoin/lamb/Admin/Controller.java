package manage.bleatcoin.lamb.Admin;

import manage.bleatcoin.lamb.Admin.LogEntryService;
import manage.bleatcoin.lamb.Admin.entities.Response;
import manage.bleatcoin.lamb.Admin.entities.LogEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api", produces="application/json")
public class Controller {

    @Autowired
    LogEntryService serv;

    @CrossOrigin
    @PostMapping(value="/create")
    public Object create(@RequestBody List<LogEntry> l) {
        serv.createLog(l);
        return new Response(false, "New Log Entry created.");
    }

    @CrossOrigin
    @GetMapping(value="/allLogs")
    public Collection<LogEntry> getAll() {
        return serv.getAllLogs();
    }

    @CrossOrigin
    @GetMapping("/getById/{l-id}")
    public Object getLogEntryById(@PathVariable(value="l-id") String id) {
        Optional<LogEntry> LogEntry = serv.findLogEntryById(id);
        if(!LogEntry.isPresent())
            return new Response(true, "No Log Entry with given ID: " + id);
        return LogEntry;
    }

    @CrossOrigin
    @PutMapping(value="/update/{l-id}")
    public Object update(@PathVariable(value="l-id") String id, @RequestBody LogEntry l) {
        l.setDate(id);
        Optional<LogEntry> LogEntry = serv.findLogEntryById(id);
        if(!LogEntry.isPresent()) {
            return new Response(true, "No Log Entry with given ID: " + id);
        }
        serv.updateLogEntry(l);
        return new Response(false, "Log Entry with ID " + id + " record updated.");
    }

    @CrossOrigin
    @DeleteMapping(value="/delete/{l-id}")
    public Object delete(@PathVariable(value="l-id") String id) {
        Optional<LogEntry> LogEntry = serv.findLogEntryById(id);
        if(!LogEntry.isPresent()) {
            return new Response(true, "No Log Entry with given ID: " + id);
        }
        serv.deleteLogEntryById(id);
        return new Response(false, "Log Entry with ID " + id + " record deleted.");
    }

    @CrossOrigin
    @DeleteMapping(value="/delete/pleaseDeleteAllLogs")
    public Response deleteAll() {
        serv.deleteAllLogs();
        return new Response(false, "All logs deleted.");
    }
}
