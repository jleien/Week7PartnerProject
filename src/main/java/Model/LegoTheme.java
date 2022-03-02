/**
*Jake Leiendecker - 900930049
*CIS175 23970 - Java II
*Feb 27, 2022
**/
package Model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author jake
 *
 */
@Entity
public class LegoTheme {
	@Id
	@GeneratedValue
	private int ID;
	private String Category;
	private Boolean LA; //license agreement
	private LocalDate creationDate;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<LegoSet> listOfSets;
	
	public LegoTheme() {
		super();
	}
	
	public LegoTheme(int ID, String Category, Boolean LA, LocalDate creationDate, List<LegoSet> listOfSets) {
		super();
		this.ID = ID;
		this.Category = Category;
		this.LA = LA;
		this.creationDate = creationDate;
		this.listOfSets = listOfSets;
	}
	
	public LegoTheme(String Category, Boolean LA, LocalDate creationDate, List<LegoSet> listOfSets) {
		super();
		this.Category = Category;
		this.LA = LA;
		this.creationDate = creationDate;
		this.listOfSets = listOfSets;
	}
	
	public LegoTheme(String Category, Boolean LA, LocalDate creationDate) {
		super();
		this.Category = Category;
		this.LA = LA;
		this.creationDate = creationDate;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public Boolean getLA() {
		return LA;
	}

	public void setLA(Boolean LA) {
		this.LA = LA;
	}

	public List<LegoSet> getListOfSets() {
		return listOfSets;
	}

	public void setListOfSets(List<LegoSet> listOfSets) {
		this.listOfSets = listOfSets;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	
}
