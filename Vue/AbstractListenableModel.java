package Vue;//??

import java.util.ArrayList;

public abstract class AbstractListenableModel{
	ArrayList<ModelListener> abonnes;
	
	public AbstractListenableModel(){
		this.abonnes = new ArrayList<>();
	}
	
	public void addListener(ModelListener e){
		this.abonnes.add(e);
	}
	
	public void removeListener(ModelListener e){
		this.abonnes.remove(e);
	}
	
	protected void fireChange(){
		for (ModelListener a : this.abonnes){
			a.modelUpdated(this);
		}
	}	
	
}
