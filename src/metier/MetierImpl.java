package metier;

import dao.IDao;

public class MetierImpl implements IMetier {
    // couplage faible
	private IDao dao;
	
	public MetierImpl(IDao dao) {
		this.dao = dao;
	}

	@Override
	public double calcul() {
		double temp=dao.getData();
		double res=temp*Math.cos(temp*3.14)*700;
		return res;
	}
	

}
