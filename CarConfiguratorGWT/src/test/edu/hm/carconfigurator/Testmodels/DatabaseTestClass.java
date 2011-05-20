package edu.hm.carconfigurator.Testmodels;

import java.io.FileInputStream;

import org.dbunit.JdbcBasedDBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.operation.TransactionOperation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public abstract class DatabaseTestClass extends JdbcBasedDBTestCase  {
    
    protected final Session session;
    protected final FlatXmlDataSetBuilder datasetBuilder;

    public DatabaseTestClass(String name) {
        datasetBuilder = new FlatXmlDataSetBuilder();
        session = null;
    }

    @Override
    protected String getConnectionUrl() {
        return "test-db";
    }

    @Override
    protected String getDriverClass() {
        return "Car Configurator Test";
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return datasetBuilder.build(new FileInputStream("Test-db-Path"));
    }

    @Override
    protected DatabaseOperation getSetUpOperation() throws Exception {
        return new TransactionOperation(DatabaseOperation.CLEAN_INSERT);
    }

    public Session getSession() {
        return session;
    }

}