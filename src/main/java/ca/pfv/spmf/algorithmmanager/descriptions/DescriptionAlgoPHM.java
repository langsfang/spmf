package ca.pfv.spmf.algorithmmanager.descriptions;

import java.io.IOException;

import ca.pfv.spmf.algorithmmanager.DescriptionOfAlgorithm;
import ca.pfv.spmf.algorithmmanager.DescriptionOfParameter;
import ca.pfv.spmf.algorithms.frequentpatterns.hui_miner.AlgoPHM;
/* This file is copyright (c) 2008-2016 Philippe Fournier-Viger
* 
* This file is part of the SPMF DATA MINING SOFTWARE
* (http://www.philippe-fournier-viger.com/spmf).
* 
* SPMF is free software: you can redistribute it and/or modify it under the
* terms of the GNU General Public License as published by the Free Software
* Foundation, either version 3 of the License, or (at your option) any later
* version.
* 
* SPMF is distributed in the hope that it will be useful, but WITHOUT ANY
* WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
* A PARTICULAR PURPOSE. See the GNU General Public License for more details.
* You should have received a copy of the GNU General Public License along with
* SPMF. If not, see <http://www.gnu.org/licenses/>.
*/

/**
 * This class describes the PHM algorithm parameters. 
 * It is designed to be used by the graphical and command line interface.
 * 
 * @see AlgoPHM
 * @author Philippe Fournier-Viger
 */
public class DescriptionAlgoPHM extends DescriptionOfAlgorithm {

	/**
	 * Default constructor
	 */
	public DescriptionAlgoPHM(){
	}

	@Override
	public String getName() {
		return "PHM";
	}

	@Override
	public String getAlgorithmCategory() {
		return "PERIODIC PATTERN MINING";
	}

	@Override
	public String getURLOfDocumentation() {
		return "http://www.philippe-fournier-viger.com/spmf/index.php?link=documentation.php#phm";
	}

	@Override
	public void runAlgorithm(String[] parameters, String inputFile, String outputFile) throws IOException {
		int minutil = getParamAsInteger(parameters[0]);
		int minPeriodicity = getParamAsInteger(parameters[1]);  // transactions
		int maxPeriodicity = getParamAsInteger(parameters[2]);  // transactions
		int minAveragePeriodicity = getParamAsInteger(parameters[3]);  // transactions
		int maxAveragePeriodicity = getParamAsInteger(parameters[4]);  // transactions
		// Applying the algorithm
		AlgoPHM algo = new AlgoPHM();
		algo.runAlgorithm(inputFile, outputFile, minutil,minPeriodicity,maxPeriodicity,minAveragePeriodicity,maxAveragePeriodicity);
		algo.printStats();
	}

	@Override
	public DescriptionOfParameter[] getParametersDescription() {
        
		DescriptionOfParameter[] parameters = new DescriptionOfParameter[5];
		parameters[0] = new DescriptionOfParameter("Minimum utility", "(e.g. 20)", Integer.class, false);
		parameters[1] = new DescriptionOfParameter("Minimum periodicity", "(e.g. 1 transactions)", Integer.class, false);
		parameters[2] = new DescriptionOfParameter("Maximum periodicity", "(e.g. 3 transactions)", Integer.class, false);
		parameters[3] = new DescriptionOfParameter("Minimum average periodicity", "(e.g. 1 transactions)", Integer.class, false);
		parameters[4] = new DescriptionOfParameter("Maximum average periodicity", "(e.g. 2 transactions)", Integer.class, false);
		return parameters;
	}

	@Override
	public String getImplementationAuthorNames() {
		return "Philippe Fournier-Viger";
	}

	@Override
	public String[] getInputFileTypes() {
		return new String[]{"Database of instances","Transaction database", "Transaction database with utility values"};
	}

	@Override
	public String[] getOutputFileTypes() {
		return new String[]{"Patterns",  "Periodic ca.pfv.spmf.patterns", "High-utility ca.pfv.spmf.patterns","Periodic frequent ca.pfv.spmf.patterns", "Periodic high-utility itemsets"};
	}
	
}