package Menu;

public class Guide {
	
	public int x=0,y=0;
	public boolean changer=false;
	public int Id;
	public Object[][] OurFirm;
	public boolean vision=false;
	public  String EmployID;
	private static Guide guide;
	
	private Guide(){
		init();
	}
	private void init(){
	}
	
	public static Guide getInstance() {
		
		if (guide == null) {
			synchronized(Guide.class) {
				if (guide == null) {
					guide = new Guide();
				}
			}
		}
		return guide;
	}
	
	public void changeValuves(int x, int y){
		this.x = x;
		this.y = y;
		this.changer=true;
	}
	
	protected int getID(){
		return Id;
	}
	public void setFirm(Object[][] firm){
		this.OurFirm=firm;
	}
	
	public String employFirm(){
		for(int i=0;i<OurFirm.length;i++)
		{
			for(int j=0;j<OurFirm[0].length;j++){
				if(EmployID.equals(OurFirm[i][j])){
					return "KAROL CZY ZROBILES JUZ HIBERNATA?";
				}
			}
		}
		return null;
	}
	
}
