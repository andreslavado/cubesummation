/**
 * 
 */
package com.co.rappi.test.cubesummation.vo;

/**
 * @author Andrés Lavado
 *
 */
public class CellValue {
	private Integer x, y, z, value;
	
	/**
	 * @param x
	 * @param y
	 * @param z
	 * @param value
	 */
	public CellValue(Integer x, Integer y, Integer z, Integer value) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.value = value;
	}

	/**
	 * @return the x
	 */
	public Integer getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(Integer x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public Integer getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(Integer y) {
		this.y = y;
	}

	/**
	 * @return the z
	 */
	public Integer getZ() {
		return z;
	}

	/**
	 * @param z the z to set
	 */
	public void setZ(Integer z) {
		this.z = z;
	}

	/**
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Integer value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CellValue [x=" + x + ", y=" + y + ", z=" + z + ", value=" + value + "]";
	}
	
}
