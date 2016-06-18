/**
 * Created by Rita Liang on 2016/4/30.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="view_application")
public class Application implements Serializable {

    /* @Id
    @GeneratedValue
    public Long id;
 */
	@Id
	@GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid")
	@Column(name="idCardNo")
    public String id;

    public String applyItem;

    public String signDoctor;

    public String applyDepartment;

    //public Date applyTime;

	public String applyTime;
	
    public String examAddress;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "idCardNo", insertable = false, updatable = false)
    public Person person;

    public Application(){};

    /* public Application(Long id, String idCardNo, String applyItem, String signDoctor,
                       String applyDepartment, Date applyTime, String examAddress){
        this.id = id;
        this.idCardNo = idCardNo;
        this.applyItem = applyItem;
        this.signDoctor = signDoctor;
        this.applyDepartment = applyDepartment;
        this.applyTime = applyTime;
        this.examAddress = examAddress;
    }
	 */
	 
    public Application(String id, String applyItem, String signDoctor,
                       String applyDepartment, String applyTime, String examAddress){
        this.id = id;
        this.applyItem = applyItem;
        this.signDoctor = signDoctor;
        this.applyDepartment = applyDepartment;
        this.applyTime = applyTime;
        this.examAddress = examAddress;
    }

    public String toString(){
        return this.applyItem + "  " + this.signDoctor;
    }
}
