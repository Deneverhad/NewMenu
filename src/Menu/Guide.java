package Menu;

public class Guide {
	public int x=0,y=0;
	boolean changer=false;
	public int Id;
	public Object[][] OurFirm;
	String login;
	boolean vision=false;
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
}
