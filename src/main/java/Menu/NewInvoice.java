package Menu;

public class NewInvoice {

	public NewInvoice(){
		if(Guide.getInstance().getID()<3) {
			String CompanyName=Guide.getInstance().employFirm();
			System.out.println(CompanyName);
			Guide.getInstance().changeValuves(2,1);
		}
		else{
			Guide.getInstance().changeValuves(2,0);//Next
		}
	}
}
