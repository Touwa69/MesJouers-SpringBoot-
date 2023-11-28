package com.abbassi.Jouers;

import com.abbassi.Jouers.entities.Equipe;
import com.abbassi.Jouers.entities.Jouer;
import com.abbassi.Jouers.repos.JouerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class JouersApplicationTests {
	@Autowired
	private JouerRepository jouerRepository;



	@Test
	void testCreateJouer() {
		Jouer jouer = new Jouer("Touwa Abbassi", 300.000, new Date());
		jouerRepository.save(jouer);
	}

	@Test
	public void testFindJouer()
	{
		Jouer j = jouerRepository.findById(1L).get();
		System.out.println(j);
	}
	@Test
	public void testUpdateJouer()
	{
		Jouer j = jouerRepository.findById(2L).get();
		j.setPrixJouer(500.000);
		jouerRepository.save(j);
	}

	@Test
	public void testDeleteJouer()
	{
		jouerRepository.deleteById(1L);;
	}

	@Test
	public void testListerTousJouers() {
		List<Jouer> jouers = jouerRepository.findAll();
		for (Jouer j : jouers)
		{
			System.out.println(j);
		}
	}

	@Test
	public void testFindByNomProduitContains () {

		List<Jouer> jouers = jouerRepository.findByNomJouerContains("Touwa");
		for (Jouer j : jouers)
		{
			System.out.println(j);
		}
	}

//	@Test
//	public void testfindByNomPrix() {
//
//		List<Jouer> jouers = jouerRepository.findByNomPrix("Touwa Abbassi", 500.0);
//		for (Jouer j : jouers)
//			{
//				System.out.println(j);
//			}
//		}


	@Test
	public void testFindByCategorie()
	{
		Equipe equipe = new Equipe();
		equipe.setIdEquipe(1L);

		List<Jouer> jouers = jouerRepository.findByEquipe(equipe);
		for (Jouer j : jouers)
		{
			System.out.println(j);
		}
	}


	@Test
	public void testFindByEquipeIdEquipe()
	{
		List<Jouer> jouers = jouerRepository.findByEquipeIdEquipe(1L);
		for (Jouer j : jouers)
		{
			System.out.println(j);
		}
	}


	@Test
	public void testFindByOrderByNomJouerAsc()
	{
		List<Jouer> jouers =
				jouerRepository.findByOrderByNomJouerAsc();
		for (Jouer j: jouers)
		{
			System.out.println(j);
		}
	}


	@Test
	public void testTrierJouersNomsPrix()
	{
		List<Jouer> jouers = jouerRepository.trierJouersNomsPrix();
		for (Jouer j : jouers)
		{
			System.out.println(j);
		}
	}
}
