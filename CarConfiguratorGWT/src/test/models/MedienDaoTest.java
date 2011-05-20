package edu.hm.shareit.ressource;


import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.hm.shareit.dbaccess.ressourcemanagement.MedienDao;
import edu.hm.shareit.dbaccess.usermanagement.PersonDAO;
import edu.hm.shareit.models.DatabaseTestClass;
import edu.hm.shareit.models.ressource.Buch;
import edu.hm.shareit.models.ressource.DVD;
import edu.hm.shareit.models.ressource.Medien;
import edu.hm.shareit.models.usermanagement.Person;

public class MedienDaoTest extends DatabaseTestClass{
	PersonDAO persondao;
	private MedienDao mediendao;
	private Transaction tx;
	private Person charly;
	private Person raymond;
	private Medien linuxBuch;
	private Medien physikBuch;
	private Medien v2bDVD;
	private Medien galileoDVD;
	
	Long linuxId;
	Long physikId;
	Long v2bId;
	Long galileoId;
	
	public MedienDaoTest() throws Exception {
		super(DATABASE_NAME);
       //super(TEST_DATA_BASE_XML);
		mediendao= new MedienDao(injector.getInstance(SessionFactory.class));

	}
	
	
	@Before
	public void setUp() throws Exception {
		charly = new Person("charly","tchinda","mbiep","charlypass",new SimpleDateFormat("MM/dd/yyyy").parse("29/02/1988"));
		raymond = new Person("raymond","raymdtong","simtong","raymondpass",new SimpleDateFormat("MM/dd/yyyy").parse("29/02/1988"));
		linuxBuch = new Buch("linux wissen","123",Medien.Fachgebiet.INFORMATIK,"Ein sehr sehr gutes Buch über Linux","michael kofler");
		physikBuch = new Buch("physik","234",Medien.Fachgebiet.PHYSIK,"patt mitchel","Mit diesem Buch lernen Sie alles über Atomphysik","barbara mayer");
		v2bDVD = new DVD("photoshop","345",Medien.Fachgebiet.INFORMATIK,"VideoTraining von video2brain","abraham lincoln");
		galileoDVD = new DVD("wirtschaft","456",Medien.Fachgebiet.WIRTSCHAFT,"Aus dem Jahr 1900,jedoch sehr sehr gut","freddy daoud");

		
		tx = session.beginTransaction();
	}
	
	
	@After
	public void  tearDown() {
	tx.commit();
	}
	
	@Test
public void testCreateMedienBuch() {
		
		mediendao.createMedienBuch("BuchTest", "123Buch", Medien.Fachgebiet.INFORMATIK,"Ein Testbuch ,ein echtes Testbuch,descriptor", "Author Test");
	
		List list = session.createQuery("from Medien where title = 'BuchTest'").list();
		assertTrue(list.size()>0);
//		Buch buch = (Buch)session.get(Medien.class, 1L);
//		assertNotNull(buch);
		}

	@Test
	public void testCreateMedienDVD() {
		mediendao.createMedienDVD("DVD TEST", "123DVD", Medien.Fachgebiet.GEOGRAPHIE,"Eine DVD zum testen.....ehehehe", "DVD author");
		
		List list = session.createQuery("from Medien where title = 'DVD TEST'").list();
		assertTrue(list.size()>0);
//		DVD dvd = (DVD)session.get(Medien.class, 2L);
//		assertNotNull(dvd);
	}
	
	
	
	
	@Test
	public void testMedien() {
		mediendao.createMedien(linuxBuch);
		Long linuxId = linuxBuch.getId(); 
		mediendao.createMedien(physikBuch);
		Long physikId = physikBuch.getId();
		
		Buch b1 = (Buch)session.get(Medien.class, linuxId);
		assertEquals("linux wissen", b1.getTitle());
		
		Buch b2 = (Buch)session.get(Medien.class,physikId);
		assertEquals("physik",b2.getTitle());
		
		assertTrue(mediendao.findMedienByTitle("physik")!=null);
	}
	
	
	@Test
	public void testFindMedienByIsbn() {
	List<Medien> list = mediendao.findMedienByISBN("123DVD");
	
	assertTrue(list.size()>0);
	
}
	
	@Test
	public void testFindMedienById() {
	Medien medien	= mediendao.findById(1L);
	
	assertEquals(medien.getTitle(),"BuchTest");
	
	assertEquals(mediendao.findMedienById(1L).getTitle(),"BuchTest");
	}
	
	
	@Test
	public void testInsertOwnerOnCreate() {
		Medien linux = new Buch("linux ","12367",Medien.Fachgebiet.INFORMATIK,"eine Beschreibung,beschreibung beschreibung","michael");

		Person person = (Person)session.get(Person.class, "addam");
		linux.setOwner(person);
		mediendao.createMedien(linux);
		
		assertEquals("addam", linux.getOwner().getUserName());
	}
	
	
	@Test
	public void testInsertOwner() {
		Medien medien = (Buch)session.get(Medien.class, 1L);

		Person person = (Person)session.get(Person.class, "addam");

		medien.setOwner(person);
		
		Medien medien1 =(Medien)session.get(Medien.class, 2L);
		
		medien1.setOwner(person);
		

		
		List list = session.createQuery("from Medien where owner_username ='addam'").list();
		
		assertTrue(list.size()>1);
		
		assertTrue(mediendao.findMedienByOwner(person).size()>0);
	}
	
	
	@Test
	public void testFindMedienByUser() {
		
		List list = mediendao.findMedienByOwner("addam");
		
		
		assertTrue(list.size()>0);
		
	}
	
	@Test
	public void testFindAllMedien() {
		
		List list = mediendao.findAllMedien();
		
		assertTrue(list.size()>3);
	}
	
	
	
	
	@Test
	public void testDeleteAllMedien() throws Exception {
		
		tx= session.beginTransaction();
		List list = session.createQuery("from Medien").list();
		for(Object o : list) {
			
			((Medien)o).setOwner(null);
			}
		
		list = session.createQuery("from Medien where owner_username='addam'").list();

		assertTrue(list.size()==0);
		
		 
	}
	
	
	public void testReset()throws Exception{
		super.setUp();

	}
	
	
	
}
