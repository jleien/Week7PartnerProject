/**
*Jake Leiendecker - 900930049
*CIS175 23970 - Java II
*Feb 27, 2022
**/
package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author jake
 *
 */
@Entity
@Table(name = "sets")
public class LegoSet {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int ID;
	@Column(name = "setName")
	private String setName;
	@Column(name = "numPieces")
	private int numPieces;
	@Column(name = "age")
	private int age;
	@Column(name = "price")
	private double price;
	@Column(name = "theme")
	private String theme;
	
	public LegoSet() {
		super();
	}
	
	public LegoSet(int ID, String setName, int numPieces, int age, double price, String theme) {
		setID(ID);
		setSetName(setName);
		setNumPieces(numPieces);
		setAge(age);
		setPrice(price);
		setTheme(theme);
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getSetName() {
		return setName;
	}

	public void setSetName(String setName) {
		this.setName = setName;
	}

	public int getNumPieces() {
		return numPieces;
	}

	public void setNumPieces(int numPieces) {
		this.numPieces = numPieces;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	
}