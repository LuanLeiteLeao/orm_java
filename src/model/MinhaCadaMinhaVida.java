package model;

public class MinhaCadaMinhaVida extends ModelGeneric {
	public Integer test1;
	public Integer test2;
	public Integer test3;
	
	public Integer getTest1() {
		return test1;
	}
	
	public void setTest1(Integer test1) {
		this.test1 = test1;
	}
	
	public Integer getTest2() {
		return test2;
	}
	
	public void setTest2(Integer test2) {
		this.test2 = test2;
	}
	
	public Integer getTest3() {
		return test3;
	}
	
	public void setTest3(Integer test3) {
		this.test3 = test3;
	}
	
	@Override
	public String toString() {
		
		return getTest1()+" "+getTest2()+" "+getTest3();
	}
}
