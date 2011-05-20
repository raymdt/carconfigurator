 package edu.hm.shareit.models;

import edu.hm.shareit.*;

/**
 * This interface contains the constants required for running the tests.
 * @author ab@cs.hm.edu
 *
 */
public interface ShareitTestBaseData {

    String TEST_DATA_EMPTY_XML = "../test-data/empty.xml";
    String TEST_DATA_BASE_XML = "../test-data/base.xml";
    String DTD_FILE_NAME = "../test-data/shareit.dtd";
    String DATABASE_NAME = "../test-data/test-db";
  //  String DATABASE_NAME = "../test-data/charlydb";
    String TEST_DB_URL = ShareitGuiceModule.DB_DRIVER + DATABASE_NAME + ";create=true";

}