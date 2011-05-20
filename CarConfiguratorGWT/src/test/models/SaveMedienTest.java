package edu.hm.shareit.ressource;

import junit.framework.TestCase;
import edu.hm.shareit.models.ressource.Buch;
import edu.hm.shareit.models.ressource.DVD;
import edu.hm.shareit.models.ressource.Medien;

public class SaveMedienTest extends TestCase{
	
	public void testToStringBuch() {
		
		Medien buch = new Buch("title","isbn",Medien.Fachgebiet.ALLGEMEIN,"beschreibung","author");
		String s = buch.toString();
		
		assertTrue(s.length()>1);
		assertFalse(s.length()<2);
		
		String s1 = buch.getAuthorformatiert();
		assertTrue(s1.length()>1);
		assertFalse(s.length()<2);
		buch.setAuthorformatiert("bingo");
		assertEquals("author/", buch.getAuthorformatiert());

		
		buch.setId(1L);
		Medien buch2 = new Buch("title","isbn",Medien.Fachgebiet.ALLGEMEIN,"beschreibung","author");
		buch2.setId(1L);
		assertTrue(buch.equals(buch2));
		
		Medien buch3 = new Buch("title","isbn",Medien.Fachgebiet.ALLGEMEIN,"beschreibung","author");

		assertFalse(buch2.equals(buch3));
		
		assertEquals(buch.getMedienTyp(),"Buch");
		
		assertEquals(buch.getBeschreibung(),"beschreibung");
		
		buch.setFree(true);
		
		assertTrue(buch.isFree());
		

	}
	
	
	public void testToStringDVD() {
		
		Medien dvd = new DVD("title","isbn",Medien.Fachgebiet.ALLGEMEIN,"beschreibung","author");
		String s = dvd.toString();
		assertTrue(s.length()>1);
		assertFalse(s.length()<2);
		
		String s1 = dvd.getAuthorformatiert();
		assertTrue(s1.length()>1);
		assertFalse(s.length()<2);
		dvd.setAuthorformatiert("bingo");
		assertEquals("author/", dvd.getAuthorformatiert());
		
		dvd.setId(1L);
		Medien dvd2 = new DVD("title","isbn",Medien.Fachgebiet.ALLGEMEIN,"beschreibung","author");
		dvd2.setId(1L);
		assertTrue(dvd.equals(dvd2));
		
		Medien dvd3 = new DVD("title","isbn",Medien.Fachgebiet.ALLGEMEIN,"beschreibung","author");

		assertFalse(dvd2.equals(dvd3));
		
		assertEquals(dvd.getMedienTyp(),"DVD");
		
		assertEquals(dvd.getBeschreibung(),"beschreibung");
		
dvd.setFree(true);
		
		assertTrue(dvd.isFree());
		

	}
	
	

}
