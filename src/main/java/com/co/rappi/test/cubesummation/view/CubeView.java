/**
 * 
 */
package com.co.rappi.test.cubesummation.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.co.rappi.test.cubesummation.vo.Matrix3D;
import com.co.rappi.test.cubesummation.vo.TestCase;

/**
 * @author Andrés Lavado
 *
 */
@ManagedBean(name="cubeView")
public class CubeView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4211426717645537892L;
	private String input;
	private String output;
	private Integer t;
	private List<Matrix3D> matrices3D;

	@PostConstruct
	private void init(){
		this.input = "";
		this.output = "";
		this.matrices3D = new ArrayList<>();
	}

	public void process(){
		
		if(matrices3D.size()>0){
			this.matrices3D.clear();
			this.output = "";
		}
		
		if(input.trim().length() == 0){
			launchMessage("Ingrese una entrada correcta");
			return;
		}
		
		String[] inputArray = input.split("\n");
		try{
			t = Integer.valueOf(inputArray[0].trim());
		}catch (NumberFormatException e) {
			launchMessage("El valor T="+inputArray[0]+" no es un valor numérico");
		}
		
		//1 <= T <= 50 
		
		if(!(t>=1 && t<=50)){
			launchMessage("El valor T="+t+" no cumple la regla '1 <= T <= 50'");
			return;
		}
		
		try {
			createMatrices(inputArray);
			applyOperations();
		} catch (Exception e) {
			launchMessage(e.getMessage());
		}
	}

	/**
	 * @param inputArray
	 */
	private void createMatrices(String[] inputArray) throws Exception {
		for (int i = 1; i < inputArray.length;) {
			String[] nm = inputArray[i].split(" ");
			Integer n = null;
			Integer m = null;
			try{
				n = Integer.valueOf(nm[0].trim());
				m = Integer.valueOf(nm[1].trim());
			}catch (NumberFormatException e) {
				launchMessage("Los valores N y M deben ser numéricos, valores actuales: N="+nm[0].trim()+", M="+nm[1].trim());
			}
			
			//1 <= N <= 100 
			//1 <= M <= 1000 
			if(!(n>=1 && n<=100)){
				throw new Exception("El valor N="+n+" no cumple la regla '1 <= N <= 100'");
			}
			
			if(!(m>=1 && m<=1000)){
				throw new Exception("El valor M="+m+" no cumple la regla '1 <= M <= 1000'");
			}
			
			
			i++;
			List<String> operations = new ArrayList<>();
			for (int j = 1; j <= m; j++, i++) {
				operations.add(inputArray[i]);
			}
			matrices3D.add(new Matrix3D(new TestCase(n, m, operations)));
		}
		
		if(matrices3D.size() != t){
			throw new Exception("El valor T="+t+" no corresponde con la cantidad de Test Case ingresados.");
		}
	}

	private void applyOperations() throws Exception {
		List<Integer> outputList = new ArrayList<>();
		for (Matrix3D matrix3d : matrices3D) {
			outputList.addAll(matrix3d.applyOperations());
		}
		
		for (Integer out : outputList) {
			output += out+"\n";
		}
	}
	
	public void clear(){
		this.input = "";
		this.output = "";
		this.matrices3D.clear();
	}

	private void launchMessage(String message){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", message));
	}

	/**
	 * @return the input
	 */
	public String getInput() {
		return input;
	}
	/**
	 * @param input the input to set
	 */
	public void setInput(String input) {
		this.input = input;
	}
	/**
	 * @return the output
	 */
	public String getOutput() {
		return output;
	}
	/**
	 * @param output the output to set
	 */
	public void setOutput(String output) {
		this.output = output;
	}

}
