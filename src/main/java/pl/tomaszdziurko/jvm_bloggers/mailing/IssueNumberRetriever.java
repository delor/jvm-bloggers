package pl.tomaszdziurko.jvm_bloggers.mailing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class IssueNumberRetriever {

    public static final String GET_NEXTVALUE_FROM_ISSUE_NUMBER_SEQUENCE = "select nextval('MAILING_ISSUE_NUMBER_SEQ') as issue";

    private final DataSource dataSource;

    @Autowired
    public IssueNumberRetriever(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public long getNextIssueNumber() {
        try {
            Statement statement = dataSource.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(GET_NEXTVALUE_FROM_ISSUE_NUMBER_SEQUENCE);
            resultSet.next();
            return resultSet.getLong("issue");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
