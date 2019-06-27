package manage.bleatcoin.lamb.Admin;

import manage.bleatcoin.lamb.Admin.entities.LogEntry;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILogEntryRepository extends MongoRepository<LogEntry, String> { }
