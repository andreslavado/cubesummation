/**
 * 
 */
package com.co.rappi.test.cubesummation.vo;

import java.util.List;

/**
 * @author Andrés Lavado
 *
 */
public class TestCase {
	private Integer n;
	private Integer m;
	private List<String> operations;
	
	/**
	 * @param n
	 * @param m
	 * @param operations
	 */
	public TestCase(Integer n, Integer m, List<String> operations) {
		this.n = n;
		this.m = m;
		this.operations = operations;
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
	 * @return the m
	 */
	public Integer getM() {
		return m;
	}
	/**
	 * @param m the m to set
	 */
	public void setM(Integer m) {
		this.m = m;
	}
	/**
	 * @return the operations
	 */
	public List<String> getOperations() {
		return operations;
	}
	/**
	 * @param operations the operations to set
	 */
	public void setOperations(List<String> operations) {
		this.operations = operations;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TestCase [n=" + n + ", m=" + m + ", operations=" + operations + "]";
	}
}
