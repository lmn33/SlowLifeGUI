import static org.junit.Assert.*;
import org.junit.Test;
//import org.junit.Test;
import static org.mockito.Mockito.*;




public class MainPanelTests {
	private RunContinuousButton _runContinuous;
	private MainPanel mp;
	
	//MainPanel.runContinuous()
	//Makes sure that the _running boolean is initialized to false
	@Test
	public void testRunContinuousFalse()  
	{
		MainFrame mf = new MainFrame(15);
		mp=new MainPanel(15);
		assertFalse(mp.running);
	}
	
	//Ensures that the size is the same as passed in
	@Test
	public void testCellsSize()
	{
		int i=15;
		mp=new MainPanel(i);
		assertEquals(mp.getCellsSize(),i);
	}
	
	//ensures that _running is set to false after all runs
	@Test
	public void testRunContinuous()  
	{
		MainFrame mf = new MainFrame(15);
		mp=new MainPanel(15);
		int i=0;
		int max=100000;
		while(i!=max)
		{
			mp.run();
			++i;
		}
		
		assertFalse(mp.running);
	}
	
	
	//MainPanel.backup()
	//Makes sure the backups are still the same after they have been run once
	@Test
	public void testCells()
	{
		int i=15;
		mp=new MainPanel(i);
		mp.run();
		assertEquals(mp.getBackUp(),mp.getCellsArray());
	}
	
	//MainPanel.backup()
	//Makes sure the backups are still the same after they have been run multiple times
	@Test
	public void testCellsAfterMultipleRuns()
	{
		int i=15;
		mp=new MainPanel(i);
		int counter=0;
		int max=10000;
		while(counter!=max)
		{
			mp.run();
			++counter;
		}
		assertEquals(mp.getBackUp(),mp.getCellsArray());
	}
	
	//MainPanel.backup()
	//Makes sure the backup is not used when there are no runs
	@Test
	public void testCellsAfterWithNoRuns()
	{
		int i=15;
		mp=new MainPanel(i);
		
		assertNotEquals(mp.getBackUp(),mp.getCellsArray());
	}
	
	
	//MainPanel.convertToInt()
	//Ensures that convertInt returns same int
	@Test
	public void testConvertToInt()
	{
		int i=15;
		mp=new MainPanel(i);
		
		
		
		assertEquals(mp.showConvertInt(i),i);
	}
	
		//MainPanel.convertToInt()
		//Ensures that convertInt returns same int after multiple runs
		@Test
		public void testConvertToIntMultipleRuns()
		{
			int i=15;
			mp=new MainPanel(i);
			
			
			while(i<1000)
			{
				assertEquals(mp.showConvertInt(i),i);
				++i;
			}
		}

		//MainPanel.convertToInt()
		//ensures it works for negative numbers
		@Test
		public void testConvertToIntNegative()
		{
			int i=15;
			mp=new MainPanel(i);
			int x=-19;
			
			assertEquals(mp.showConvertInt(x),x);
		}
}