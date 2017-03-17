package logic;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.VinkelEjDefineretException;

public class NormalkraftImpl implements Normalkraft {
	
	private Vinkel vinkel;
	private Dimensionerendekraft fdim;
	public String mellemRegning;
	
	@Override
	public void angivDimensionerendekraft(Dimensionerendekraft fdim) throws DimensionerendeKraftEjDefineretException {
		if(fdim!=null) 
			this.fdim = fdim;
		else
			throw new DimensionerendeKraftEjDefineretException();

	}
	@Override
	public void angivVinkel(Vinkel vinkel) throws VinkelEjDefineretException {
		if(vinkel==null) 
			throw new VinkelEjDefineretException();
		this.vinkel = vinkel;
	}

	public double getNewton() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
		double grader = vinkel.getGrader();
		boolean erMaaltTilLodret = vinkel.getMaaltTilLodret();
		double fdimNewton = fdim.getNewton();
		double fnNewton = 0;
		double sin = Math.sin(Math.toRadians(grader));
		double cos = Math.cos(Math.toRadians(grader));
		
		if (erMaaltTilLodret) {
			fnNewton = cos * fdimNewton;
			mellemRegning = "Fn = cos("+vinkel.getGrader()+") * "+fdimNewton;
		} else {
			fnNewton = sin * fdimNewton;
			mellemRegning = "Fn = sin("+vinkel.getGrader()+") * "+fdimNewton;
		}
		
		return fnNewton;
	}

	@Override //TODO Det ser ud til metoden er f�rdig (SA)
	public String getMellemregning() {
		return mellemRegning;
	}

}
