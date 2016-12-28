/**
 * 
 */
package com.co.rappi.test.cubesummation.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrés Lavado
 *
 */
public class Matrix3D {

	private Integer n;
	private TestCase testCase;
	private List<CellValue> updates;

	/**
	 * 
	 */
	public Matrix3D(TestCase testCase) {
		this.testCase = testCase;
		this.n = testCase.getN();
		this.updates = new ArrayList<>();
	}

	public List<Integer> applyOperations() throws Exception {
		List<Integer> output = new ArrayList<>();
		for (String operation : testCase.getOperations()) {
			String[] operationArray = operation.split(" ");

			if(operationArray[0].equalsIgnoreCase("UPDATE")){
				applyUpdate(operationArray);
			}
			else{
				if(operationArray[0].equalsIgnoreCase("QUERY")){
					output.add(applyQuery(operationArray));
				}
				else{
					throw new Exception("El valor "+operationArray[0]+" no corresponde a una operación valida.");
				}
			}
		}

		return output;
	}

	public void applyUpdate(String[] update) throws Exception{
		try {
			Integer x = Integer.valueOf(update[1].trim());
			Integer y = Integer.valueOf(update[2].trim());
			Integer z = Integer.valueOf(update[3].trim());
			Integer value = Integer.valueOf(update[4].trim());
			/*
			 * 1 <= x,y,z <= N 
				-109 <= W <= 109
			 */
			if(!(x >= 1 && x <= this.n)){
				throw new Exception("El valor de X="+x+" no cumple la regla '1 <= x <= N' con N="+this.n);
			}
			if(!(y >= 1 && y <= this.n)){
				throw new Exception("El valor de Y="+y+" no cumple la regla '1 <= y <= N' con N="+this.n);
			}
			if(!(z >= 1 && z <= this.n)){
				throw new Exception("El valor de Z="+z+" no cumple la regla '1 <= z <= N' con N="+this.n);
			}
			if(!(value >= -1000000000 && value <= 1000000000)){
				throw new Exception("El valor de W="+value+" no cumple la regla '-10^9 <= W <= 10^9'");
			}
			
			this.updates.add(new CellValue(x, y, z, value));
		} catch (NumberFormatException e) {
			throw new Exception("Los valores para X, Y, Z y W deben ser numéricos, valores actuales: ["+update[1].trim()+", "+update[2].trim()+", "+update[3].trim()+"] - W="+update[4].trim());
		}catch (Exception e) {
			throw e;
		}
	}

	public Integer applyQuery(String[] query) throws Exception{
		Integer sum = new Integer(0);
		
		try{
			Integer x1 = Integer.valueOf(query[1].trim());
			Integer y1 = Integer.valueOf(query[2].trim());
			Integer z1 = Integer.valueOf(query[3].trim());
			Integer x2 = Integer.valueOf(query[4].trim());
			Integer y2 = Integer.valueOf(query[5].trim());
			Integer z2 = Integer.valueOf(query[6].trim());
			
			/*
			 * 1 <= x1 <= x2 <= N 
				1 <= y1 <= y2 <= N 
				1 <= z1 <= z2 <= N 
			 */
			
			if(!(x1 >= 1 && x1 <= x2 && x2 <= this.n)){
				throw new Exception("Los valores de X1 y X2 ["+x1+", "+x2+"], con N="+this.n+" no cumplen la regla 1 <= x1 <= x2 <= N");
			}
			if(!(y1 >= 1 && y1 <= y2 && y2 <= this.n)){
				throw new Exception("Los valores de Y1 y Y2 ["+y1+", "+y2+"], con N="+this.n+" no cumplen la regla 1 <= y1 <= y2 <= N");
			}
			if(!(z1 >= 1 && z1 <= z2 && z2 <= this.n)){
				throw new Exception("Los valores de Z1 y Z2 ["+z1+", "+z2+"], con N="+this.n+" no cumplen la regla 1 <= z1 <= z2 <= N");
			}
			
			for (CellValue cellValue : updates) {
				if(x1 <= cellValue.getX() && x2 >= cellValue.getX() &&
						y1 <= cellValue.getY() && y2 >= cellValue.getY() &&
								z1 <= cellValue.getZ() && z2 >= cellValue.getZ())
				{
					sum += cellValue.getValue();
				}
			}
		}catch (NumberFormatException e) {
			new Exception("Los valores de X1 y X2, Y1 y Y2, Z1 y Z2 deben ser numéricos, valores actuales: ["+query[1].trim()+", "+query[2].trim()+"]["+query[3].trim()+", "+query[4].trim()+"]["+query[5].trim()+", "+query[6].trim()+"]");
		}catch (Exception e) {
			throw e;
		}
		
		return sum;
	}

	/**
	 * @return the n
	 */
	public Integer getN() {
		return n;
	}

	/**
	 * @param n the n to set
	 */
	public void setN(Integer n) {
		this.n = n;
	}

	/**
	 * @return the testCase
	 */
	public TestCase getTestCase() {
		return testCase;
	}

	/**
	 * @param testCase the testCase to set
	 */
	public void setTestCase(TestCase testCase) {
		this.testCase = testCase;
	}

	/**
	 * @return the updates
	 */
	public List<CellValue> getUpdates() {
		return updates;
	}

	/**
	 * @param updates the updates to set
	 */
	public void setUpdates(List<CellValue> updates) {
		this.updates = updates;
	}
}
