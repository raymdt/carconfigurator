package edu.hm.shareit.models;

import java.io.*;

import org.dbunit.*;
import org.dbunit.dataset.*;
import org.dbunit.dataset.xml.*;
import org.dbunit.operation.*;
import org.hibernate.*;

import com.google.inject.*;

import edu.hm.shareit.*;

/**
 * Base class for all tests that use the default (filled) database.
 * @author axel
 *
 */
public abstract class DatabaseTestClass extends JdbcBasedDBTestCase implements ShareitTestBaseData  {
    
    protected final Session session;
    protected final FlatXmlDataSetBuilder datasetBuilder;
    protected final Injector injector;

    public DatabaseTestClass(String name) {
        super(name);
        datasetBuilder = new FlatXmlDataSetBuilder();
        injector = Guice.createInjector(new ShareitTestGuiceModule());
        session = injector.getInstance(SessionFactory.class).getCurrentSession();
    }

    @Override
    protected String getConnectionUrl() {
        return TEST_DB_URL;
    }

    @Override
    protected String getDriverClass() {
        return ShareitGuiceModule.DRIVER_CLASS;
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return datasetBuilder.build(new FileInputStream(TEST_DATA_BASE_XML));
    }

    @Override
    protected DatabaseOperation getSetUpOperation() throws Exception {
        return new TransactionOperation(DatabaseOperation.CLEAN_INSERT);
    }

    public Session getSession() {
        return session;
    }

}